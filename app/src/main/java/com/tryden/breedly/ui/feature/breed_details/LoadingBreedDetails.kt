package com.tryden.breedly.ui.feature.breed_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.unit.dp
import com.tryden.breedly.ui.common.shimmerBrush

/**
 * Composable for loading breed details screen.
 */
@Composable
fun LoadingBreedDetails(modifier:Modifier = Modifier) {

    val paddingValues = PaddingValues(horizontal = 12.dp, vertical = 4.dp)

    LazyColumn(modifier.fillMaxWidth()) {
        item {
            // Breed image
            Box(
                modifier = modifier
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
                    .height(400.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp, topEnd = 0.dp,
                            bottomEnd = 25.dp, bottomStart = 25.dp
                        )
                    )
                    .fillMaxWidth()
                ,
            )
        }
        item {
            Spacer(modifier = modifier.padding(paddingValues))
        }
        item {
            // Breed name, height, weight
            Row(
                modifier = modifier.fillMaxWidth().padding(paddingValues)
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.End,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .weight(.15f)
                ) {
                    // Heart icon
                    Spacer(
                        modifier = modifier
                            .align(Alignment.End)
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .weight(.8f)
                ) {
                    // Breed Name
                    Spacer(
                        modifier = modifier
                            .height(45.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth(.9f)
                            .background(
                                shimmerBrush(
                                    targetValue = 1300f,
                                    showShimmer = true
                                )
                            )
                    )
                    // Breed height & weight
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier.fillMaxWidth().padding(paddingValues)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(
                                top = 4.dp,
                                start = 12.dp,
                                end = 12.dp,
                                bottom = 4.dp
                            )
                        ) {
                            Spacer(
                                modifier = modifier
                                    .height(24.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .padding(bottom = 4.dp)
                                    .fillMaxWidth(.25f)                                    .background(
                                        shimmerBrush(
                                            targetValue = 1300f,
                                            showShimmer = true
                                        )
                                    )
                            )
                            Spacer(
                                modifier = modifier
                                    .height(24.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .fillMaxWidth(.25f)                                    .background(
                                        shimmerBrush(
                                            targetValue = 1300f,
                                            showShimmer = true
                                        )
                                    )
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(
                                top = 4.dp,
                                start = 12.dp,
                                end = 12.dp,
                                bottom = 4.dp
                            )
                        ) {
                            Spacer(
                                modifier = modifier
                                    .height(24.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .padding(bottom = 4.dp)
                                    .fillMaxWidth(.25f)                                    .background(
                                        shimmerBrush(
                                            targetValue = 1300f,
                                            showShimmer = true
                                        )
                                    )
                            )
                            Spacer(
                                modifier = modifier
                                    .height(24.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .fillMaxWidth(.25f)
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(.15f)
                ) {
                    // do nothing
                }
            }
        }
        item {
            Spacer(modifier = modifier.padding(4.dp))
        }
        item {
            // Breed attributes
            Column(modifier.fillMaxWidth().padding(paddingValues)) {
                repeat(5) {
                    Spacer(
                        modifier = modifier
                            .height(22.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth(.4f)
                            .padding(bottom = 2.dp)
                            .background(
                                shimmerBrush(
                                    targetValue = 1300f,
                                    showShimmer = true
                                )
                            )
                    )
                    Spacer(
                        modifier = modifier
                            .height(20.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .padding(bottom = 4.dp)
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
        item {
            Spacer(modifier = modifier.padding(4.dp))
        }
    }
}