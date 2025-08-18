package com.example.nectar.ui.screens.explore

import com.example.nectar.R


fun normalizeCategory(displayName: String): String {
    return displayName
        .replace("\n", "")   // remove newlines
        .trim()               // remove extra spaces
                 // normalize casing
}