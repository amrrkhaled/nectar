package com.example.nectar.data.local.converters

import androidx.room.TypeConverter
import org.json.JSONObject

class Converter {

    @TypeConverter
    fun fromMap(value: Map<String, String>?): String {
        return JSONObject(value ?: emptyMap<String, String>()).toString()
    }

    @TypeConverter
    fun toMap(value: String): Map<String, String> {
        val jsonObject = JSONObject(value)
        val map = mutableMapOf<String, String>()
        jsonObject.keys().forEach { key ->
            map[key] = jsonObject.getString(key)
        }
        return map
    }
}