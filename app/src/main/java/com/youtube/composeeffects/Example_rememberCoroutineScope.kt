package com.youtube.composeeffects

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Example_rememberCoroutineScope(){
    val scope = rememberCoroutineScope()
    var counter by remember {
        mutableIntStateOf(0)
    }


    Text(text = "counter:$counter")
    Button(onClick = { counter++ }) {
        Text(text = "Arttır")
    }

    Button(onClick = {
        scope.launch {
            delay(2000)
            println("API REQUEST")
        }
    }) {
        Text(text = "İstek Yap")
    }

    Button(onClick = {
        scope.cancel()
    }) {
        Text(text = "İstek İptal Et")
    }

}