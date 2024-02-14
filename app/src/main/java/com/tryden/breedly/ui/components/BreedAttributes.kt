package com.tryden.breedly.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.inchesToFeet
import com.tryden.breedly.viewmodels.BreedDetailsViewModel

/**
 * Composable for displaying the dog breed's attributes.
 */

@Composable
fun BreedAttributes(
    dogBreed: DogBreed,
    breedAttributesMap: Map<String, Int>,
    viewModel: BreedDetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {

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

    Spacer(modifier = modifier.padding(4.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
    ) {

        for (key in breedAttributesMap) {
            CustomProgressBar(key = key.key, value = key.value)
        }
    }

}
/**
 * Trainability
 * Energy
 * Playfulness
 * Barking
 * Protectiveness
 * Shedding
 */