package com.youtube.composeeffects

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

@Composable
fun Example_rememberUpdatedState(){
    var message by remember {
        mutableStateOf("ezgi")
    }

    Button(onClick = { message = "orçun" }) {
        Text(text = "Değiştir")
    }

    ShowMessage(message)

}

@Composable
fun ShowMessage(message:String){
    val updatedMessage by rememberUpdatedState(newValue = message)
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        println("message:$updatedMessage")
    }
}
