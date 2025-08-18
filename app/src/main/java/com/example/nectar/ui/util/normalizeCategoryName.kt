package com.example.nectar.ui.util



fun normalizeCategory(displayName: String): String {
    return displayName
        .replace("\n", "")
        .trim()

}