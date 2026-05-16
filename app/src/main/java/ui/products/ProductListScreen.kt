package ui.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import intent.ProductIntent
import model.Product
import viewModel.ProductViewModel

@ExperimentalMaterial3Api
@Composable
/*
* Contains the UI for displaying (User interactions)
* Creates the list of products in the application.
* This class handle the following:
* - Display products from ProductState
* - Handle loading state
* - Send intents to ViewModel
* - Render product cards
*/
fun ProductListScreen(
    viewModel: ProductViewModel
) {

    val state = viewModel.state.value

    // Loading the products
    LaunchedEffect(Unit) {

        viewModel.processIntent(
            ProductIntent.LoadProducts
        )
    }

    //UI customization
    Scaffold(
        containerColor = Color(0xFFF5F5F5),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(

                    containerColor =
                        Color(0xFF1E1E1E)
                ),
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment =
                            Alignment.Center
                    ) {
                        Text(
                            text = "Products Store",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight =
                                FontWeight.Bold
                        )
                    }
                }
            )
        }

    ) { paddingValues ->

        //Responsible for loading screen
        if(state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment =
                    Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Color.Black
                )
            }
        } else {
            // Products list
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    bottom = 100.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                verticalArrangement =
                    Arrangement.spacedBy(16.dp)
            ) {
                items(state.products) { product ->
                    ProductItem(product)
                }
            }
        }
    }
}

@Composable
fun ProductItem(
    product: Product
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Column {

            // Loading images of products
            AsyncImage(
                model = product.thumbnail,
                contentDescription =
                    product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )

            // Products data
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                // Handle each product title.
                Text(
                    text = product.title,
                    style =
                        MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                // Handle the description of products
                Text(
                    text = product.description,
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                // Calling the price of product
                Text(
                    text = "$${product.price}",
                    color = Color(0xFF2E7D32),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}