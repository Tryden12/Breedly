package com.tryden.breedly.ui.common

import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

/**
 * Divider for the BreedlyApp.
 */

@Composable
fun BreedlyDivider() {
    Divider(
        color = MaterialTheme.colorScheme.primary,
        thickness = .5.dp,
        startIndent = 75.dp,
    )
}