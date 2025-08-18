package com.example.nectar.ui.navigation

import kotlinx.serialization.Serializable


@Serializable
object Splash
@Serializable
object Onboarding
@Serializable
object Shop
@Serializable
object Cart

@Serializable
object Filter
@Serializable
data class Category (val name: String)
@Serializable
object Favourite
@Serializable
object Explore

@Serializable
object Account

@Serializable
data class Product (val id: Int)

@Serializable
object Order
