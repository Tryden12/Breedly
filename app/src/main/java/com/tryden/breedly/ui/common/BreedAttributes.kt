package com.tryden.breedly.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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