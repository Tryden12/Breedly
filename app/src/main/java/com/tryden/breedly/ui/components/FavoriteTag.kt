package com.tryden.breedly.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tryden.breedly.utils.Constants.FAVORITE

/**
 * Composables for showing favorite tag on breed cards.
 */

@Composable
fun FavoriteTag(modifier: Modifier) {
    ChipView(title = FAVORITE, colorResource = MaterialTheme.colorScheme.onTertiary)
}

@Composable
fun ChipView(title: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.tertiary)
    ) {
        Text(
            text = title, modifier = Modifier.padding(8.dp, 4.dp),
            style = MaterialTheme.typography.labelSmall,
            letterSpacing = 1.sp,
            color = colorResource
        )
    }
}