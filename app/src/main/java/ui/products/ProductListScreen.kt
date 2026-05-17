package ui.products

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable

/*
*
* Displays all products
* and handles search and clicks as well
*/
fun ProductListScreen(
    viewModel: ProductViewModel,
    onProductClick: (Int) -> Unit
) {
    val state = viewModel.state.value
    var searchText by remember {

        mutableStateOf("")
    }
    LaunchedEffect(Unit) {
        viewModel.processIntent(
            ProductIntent.LoadProducts
        )
    }
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
        if (state.isLoading) {
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                OutlinedTextField(

                    value = searchText,

                    onValueChange = {

                        searchText = it

                        viewModel.processIntent(

                            ProductIntent.SearchProducts(it)
                        )
                    },

                    label = {

                        Text("Search Products")
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 100.dp
                    ),
                    verticalArrangement =
                        Arrangement.spacedBy(16.dp)

                ) {
                    items(state.products) { product ->
                        ProductItem(
                            product = product,
                            onClick = {
                                onProductClick(product.id)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable

/*
* Product card UI
*/
fun ProductItem(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column {
            AsyncImage(
                model = product.thumbnail,
                contentDescription =
                    product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
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
                Text(
                    text = "$${product.price}",
                    color = Color(0xFF2E7D32),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                Text(
                    text = "⭐ ${product.rating}",
                    color = Color.DarkGray,

                    fontSize = 16.sp
                )
            }
        }
    }
}
