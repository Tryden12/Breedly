package com.tryden.breedly.ui.feature.breed_favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tryden.breedly.ui.common.shimmerBrush

/**
 * Composable for loading state of breed list screen.
 */
@Composable
fun LoadingFavorites(modifier: Modifier = Modifier) {
    val height = 200.dp

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(10) {
            Row(
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Start,
                modifier = modifier.fillMaxWidth()
            ) {
                Spacer(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(
                            shimmerBrush(
                                targetValue = 1300f,
                                showShimmer = true
                            )
                        )
                )
                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                        .padding(6.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .weight(1f)
                        .background(
                            shimmerBrush(
                                targetValue = 1300f,
                                showShimmer = true
                            )
                        )
                )
                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                        .padding(6.dp)
                        .size(25.dp)
                        .clip(CircleShape)
                        .background(
                            shimmerBrush(
                                targetValue = 1300f,
                                showShimmer = true
                            )
                        )
                )
            }
        }
    }

}

@Preview
@Composable
fun LoadingFavoritesPreview() {
    LoadingFavorites()
}