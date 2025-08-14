package com.example.nectar.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.nectar.data.local.entity.CartItemEntity
import com.example.nectar.data.local.relations.CartWithProduct
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface CartItemDao {

    @Transaction
    @Query("SELECT * FROM cart_items")
    fun getCartWithProducts(): Flow<List<CartWithProduct>>

    @Query("DELETE FROM cart_items")
    suspend fun deleteAll()

    @Transaction
    suspend fun insertOrIncrement(cartItem: CartItemEntity) {
        val existing = getCartItemByProductId(cartItem.productId)
        if (existing != null) {
            val updated = existing.copy(quantity = existing.quantity + cartItem.quantity)
            insert(updated) // REPLACE will update
        } else {
            insert(cartItem)
        }
    }
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cartItem: CartItemEntity)

    @Query("SELECT * FROM cart_items WHERE product_id = :productId LIMIT 1")
    suspend fun getCartItemByProductId(productId: Int): CartItemEntity?

    @Query("UPDATE cart_items SET quantity = :quantity WHERE product_id = :productId")
    suspend fun updateQuantity(productId: Int, quantity: Int)

    @Query("UPDATE cart_items SET quantity = quantity + :amount WHERE product_id = :productId")
    suspend fun incrementQuantity(productId: Int, amount: Int = 1)

    @Query("UPDATE cart_items SET quantity = quantity - :amount WHERE product_id = :productId")
    suspend fun decrementQuantity(productId: Int, amount: Int = 1)

    @Query("DELETE FROM cart_items WHERE product_id = :productId")
    suspend fun removeFromCart(productId: Int)

    @Query("DELETE FROM cart_items")
    suspend fun clearCart()

    @Query("""
    SELECT ROUND(SUM(price * quantity), 2) 
    FROM cart_items 
    INNER JOIN products ON cart_items.product_id = products.id
    """)
    fun getTotalPrice(): Flow<Double>


}