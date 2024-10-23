package com.youtube.composeeffects

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.filter

@Composable
fun Example_snapshotFlow(){
    var count by remember {
        mutableIntStateOf(0)
    }
    val countFlow = remember {
        snapshotFlow { count }
    }
    var collectedCount by remember {
        mutableStateOf(listOf<Int>())
    }

    LaunchedEffect(key1 = countFlow) {
        countFlow.filter {
            it % 2 == 0
        }.collect { newValue->
            if( newValue > 0 )
                collectedCount += newValue
        }
    }

    Text(text = "count:$count")
    Button(onClick = { count++}) {
        Text(text = "Arttır")
    }

    if( collectedCount.isNotEmpty() ){
        Column {
            for (item in collectedCount){
                Text(text = "Collected item : $item")
            }
        }
    }

}