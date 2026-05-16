package com.example.volvo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import repository.APIService
import repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ui.products.ProductListScreen
import viewModel.ProductViewModel

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creates Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
        // Create API service
        val apiService = retrofit.create(
            APIService::class.java
        )
        // Create repository
        val repository = ProductRepository(
            apiService
        )
        // Create ViewModel
        val viewModel = ProductViewModel(
            repository
        )
        // Start Compose UI
        setContent {
            ProductListScreen(
                viewModel
            )
        }
    }
}