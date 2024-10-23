package com.youtube.composeeffects

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Example_SideEffect(){
    var tabbarTitle by remember {
        mutableStateOf("Anasayfa")
    }

    SideEffect {
        sendAnalytics(tabbarTitle)
    }

    Text(text = tabbarTitle)
    Button(onClick = {tabbarTitle = "Profil"  }) {
        Text(text = "Profili Gör")
    }
    Button(onClick = {tabbarTitle = "Ayarlar"  }) {
        Text(text = "Ayarlar")
    }

}

fun sendAnalytics(tabbarTitle: String) {
    println("send to firebase : $tabbarTitle")
}
