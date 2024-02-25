package com.tryden.breedly.ui.feature.breed_favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tryden.breedly.R
import com.tryden.breedly.utils.Constants.EMPTY_LIST

/**
 * Composable for error states.
 */
@Composable
fun EmptyFavoritesList() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_empty_folder),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(.3f)
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = EMPTY_LIST,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun EmptyFavoritesListPreview() {
    EmptyFavoritesList()
}