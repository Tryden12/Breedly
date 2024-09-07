package com.tryden.breedly.ui.feature.breed_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.tryden.breedly.ui.common.shimmerBrush

/**
 * Composable for loading state of breed list screen.
 */
@Composable
fun LoadingBreedList() {
    val height = 200.dp

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        content = {

            items(10) {
                Spacer(
                    modifier = Modifier
                        .height(height)
                        .padding(6.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(
                            shimmerBrush(
                                targetValue = 1300f,
                                showShimmer = true
                            )
                        )
                )
            }
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    )
}