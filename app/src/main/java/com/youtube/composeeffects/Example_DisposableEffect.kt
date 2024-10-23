package com.youtube.composeeffects

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun Example_DisposableEffect(){
    var showDisposable by remember {
        mutableStateOf(false)
    }

    if( showDisposable )
        Disposable(
            onStop = {
                println("onStop calıstı")
            },
            onStart = {
                println("onStart calıstı")
            }
        )

    Button(onClick = { showDisposable = !showDisposable }) {
        Text(text = if(  showDisposable ) "Gizle" else "Göster" )
    }

}

@Composable
fun Disposable(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onStart:() ->Unit,
    onStop:() ->Unit,
){

    DisposableEffect(key1 = lifecycleOwner) {
        //register olunacak
        println("register oldu")
        val observer = LifecycleEventObserver{_,event ->
            if( event == Lifecycle.Event.ON_STOP ){
                onStop()
            }
            if( event == Lifecycle.Event.ON_START ){
                onStart()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            //register olduysan unregister yapılacak
            lifecycleOwner.lifecycle.removeObserver(observer)
            println("on dispose oldu")
        }
    }

}