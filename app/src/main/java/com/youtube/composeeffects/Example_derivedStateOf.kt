package com.youtube.composeeffects

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.TextUnit

@Composable
fun Example_derivedStateOf(){
    var counter by remember {
        mutableIntStateOf(0)
    }
    val doubleCounter by remember {
        derivedStateOf {
            counter * 2
        }
    }

    Text(text = "counter:$counter")
    Text(text = "doubleCounter:$doubleCounter")

    Button(onClick = { counter++ }) {
        Text("Arttır")
    }
}