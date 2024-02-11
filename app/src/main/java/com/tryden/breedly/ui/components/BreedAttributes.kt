package com.tryden.breedly.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.viewmodels.BreedDetailsViewModel

/**
 * Composable for displaying the dog breed's attributes.
 */

@Composable
fun BreedAttributes(
    dogBreed: DogBreed,
    viewModel: BreedDetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val breedAttributesMap = viewModel.createAttributesMap(dogBreed)

    for (key in breedAttributesMap) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(4.dp)
        ){
            val attributeLevel = key.value
            val backgroundColor = if (attributeLevel < 3) {
                MaterialTheme.colorScheme.scrim
            } else if (attributeLevel == 3) {
                MaterialTheme.colorScheme.secondary
            } else {
                MaterialTheme.colorScheme.tertiary
            }

            Column(modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .background(backgroundColor)
                .padding(8.dp)
            ) {
                Text(text = key.key)
            }
            Column(Modifier
                .padding(4.dp)
                .weight(1f)
            )  {
                Text(text = key.value.toString())
            }
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