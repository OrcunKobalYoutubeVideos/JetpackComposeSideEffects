package com.youtube.composeeffects

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

@Composable
fun Example_LaunchedEffect() {
    var counter by remember {
        mutableIntStateOf(0)
    }
    LaunchedEffect(key1 = counter) {
        println("calıstı :$counter")
        getData()
    }
    Text(text = "counter:$counter")
    Button(onClick = { counter++ }) {
        Text(text = "Arttır")
    }
}

suspend fun getData(){
    delay(3000)
    println("get data calıstı")
}