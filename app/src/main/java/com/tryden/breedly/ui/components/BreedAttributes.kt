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
    breedAttributesMap: Map<String, Int>,
    paddingValues: PaddingValues
) {
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