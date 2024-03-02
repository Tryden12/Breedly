package com.tryden.breedly.ui.feature.breed_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.ui.common.FavoriteHeart

/**
 * Composable for displaying breed name, average height, and average weight.
 */
@Composable
fun BreedDetailsNameCard(
    dogBreed: DogBreed,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End,
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .weight(.15f)
        ) {
            FavoriteHeart(breed = dogBreed, size = 1.3f, modifier = Modifier.padding(12.dp, 8.dp))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth().weight(.8f)
        ) {
            Text(
                text = dogBreed.name,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(paddingValues)
            )
            if (dogBreed.avgHeight.isNotEmpty() && dogBreed.avgWeight.isNotEmpty()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(
                            top = 4.dp,
                            start = 12.dp,
                            end = 25.dp,
                            bottom = 4.dp
                        )
                    ){
                        Text(
                            text = dogBreed.avgWeight,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Weight",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = modifier
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(
                            top = 4.dp,
                            start = 25.dp,
                            end = 12.dp,
                            bottom = 4.dp
                        )
                    ){
                        Text(
                            text = dogBreed.avgHeight,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Height",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = modifier
                        )
                    }
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth().fillMaxHeight().weight(.15f)
        ) {
            // do nothing
        }
    }

}