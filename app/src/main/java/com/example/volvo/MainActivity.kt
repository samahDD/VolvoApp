package com.example.volvo

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import repository.APIService
import repository.ProductRepository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import ui.products.ProductDetailScreen
import ui.products.ProductListScreen

import viewModel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)

class MainActivity : ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        val retrofit = Retrofit.Builder()
            .baseUrl(
                "https://dummyjson.com/"
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )

            .build()
        val apiService = retrofit.create(
            APIService::class.java
        )
        val repository = ProductRepository(
            apiService
        )
        val viewModel = ProductViewModel(
            repository
        )
        setContent {
            val navController =
                rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "products"
            ) {
                composable(
                    "products"
                ) {
                    ProductListScreen(
                        viewModel = viewModel,
                        onProductClick = { productId ->
                            navController.navigate(
                                "details/$productId"
                            )
                        }
                    )
                }

                composable(
                    "details/{productId}"
                ) { backStackEntry ->
                    val productId =
                        backStackEntry.arguments
                            ?.getString("productId")
                            ?.toInt()
                    val product =
                        viewModel.state.value.products.find {

                            it.id == productId
                        }
                    product?.let {

                        ProductDetailScreen(
                            product = it,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
