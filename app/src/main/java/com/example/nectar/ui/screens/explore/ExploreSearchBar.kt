package com.example.nectar.ui.screens.explore


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.example.nectar.domain.model.SearchFilter
import com.example.nectar.ui.theme.Black
import com.example.nectar.ui.theme.SearchBackgroundColor
import com.example.nectar.ui.theme.SearchTextColor

@Composable
fun ExploreSearchBar(
    searchQuery: SearchFilter,
    modifier: Modifier = Modifier,
    onSearch: (SearchFilter) -> Unit = {},
    cancelSearch: () -> Unit = {},
    autoFocus: Boolean = false
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    BackHandler(enabled = searchQuery.queryText.isNotEmpty()) {
        cancelSearch()
    }
    LaunchedEffect(autoFocus) {
        if (autoFocus) {
            focusRequester.requestFocus()
            keyboardController?.show()
        }
    }
    OutlinedTextField(
        value = searchQuery.queryText,
        onValueChange = {
            onSearch(searchQuery.copy(queryText = it))
        },
        modifier = modifier
            .height(52.dp)
            .background(
                color = SearchBackgroundColor, shape = RoundedCornerShape(15.dp)
            )
            .focusRequester(focusRequester),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Black,
                modifier = Modifier.size(25.dp)

            )
        },
        trailingIcon = {
            if (searchQuery.queryText.isNotEmpty()) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear Search",
                    tint = SearchTextColor,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            onSearch(searchQuery.copy(queryText = ""))
                            focusManager.clearFocus()
                            cancelSearch()

                        })
            }
        },
        placeholder = {
            Text(text = "Search Store", color = SearchTextColor)
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.titleMedium,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,

            )
    )


}
