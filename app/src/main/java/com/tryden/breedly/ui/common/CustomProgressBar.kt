package com.tryden.breedly.ui.common

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

/**
 * Composable for displaying breed attributes as a progress bar.
 */
@Composable
fun CustomProgressBar(key: String, value: Int) {
    var progressCount: Int by remember { mutableStateOf(0) }
    var progress by remember { mutableStateOf(0f) }
    progressCount = value

    /* to avoid the direct calculation of progress variable which is a Float
     and it can sometimes cause problems like it shows 0.4 to 0.400004 so, here I have use
     progressCount and we will increase and decrease it and then convert it to progress(Float)
     and then use that progress with our ProgressBar Width*/
    when (progressCount) {
        0 -> progress = 0.0f
        1 -> progress = 0.2f
        2 -> progress = 0.4f
        3 -> progress = 0.6f
        4 -> progress = 0.8f
        5 -> progress = 1.0f
    }

    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        ), label = "$value/5"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
    ) {
        // for the text above the progressBar
        Row(
            modifier = Modifier
                .widthIn(min = 100.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = key)
        }
        // Progress Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(17.dp)
        ) {
            // for the background of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
            )
            // for the progress of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .animateContentSize()
            ) {
                Text(
                    text = "$value/5",
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.align(Alignment.CenterEnd).padding(horizontal = 8.dp)
                )
            }
        }
    }

//    Use this when you want the progress bar(s)
    LaunchedEffect(key1 = true) {
        progressCount = 2
    }

}