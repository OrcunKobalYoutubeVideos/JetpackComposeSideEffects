package com.youtube.composeeffects

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay

data class ProductItem(val id:Int, val name:String)

sealed interface ProductsProduceViewState{
    data object Loading : ProductsProduceViewState
    data class Success(val list:List<ProductItem>) : ProductsProduceViewState
}

class ProductProduceState(val response:ProductsProduceViewState)

@Composable
fun Example_produceState(){
    val list by produceState(initialValue = ProductProduceState(response = ProductsProduceViewState.Loading)) {
        value = ProductProduceState(response = ProductsProduceViewState.Success(list = getProductList()))
    }

    when(val viewState = list.response){
        ProductsProduceViewState.Loading -> CircularProgressIndicator()
        is ProductsProduceViewState.Success -> {
            LazyColumn {
                items(viewState.list){ product->    
                    Text(text = "id:${product.id} ${product.name}")
                }
            }
        }
    }
}

suspend fun getProductList(): List<ProductItem> {
    delay(3000)
    return listOf(
        ProductItem(id = 1, name = "tablet"),
        ProductItem(id = 2, name = "bilgisayar"),
        ProductItem(id = 3, name = "telefon"),
        ProductItem(id = 4, name = "masa")
    )
}
