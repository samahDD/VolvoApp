package ui.products

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage

import model.Product

@Composable

/*
* Product details screen
*/
fun ProductDetailScreen(

    product: Product,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                onBackClick()
            }
        ) {
            Text(
                text = "Back"
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        AsyncImage(

            model = product.thumbnail,

            contentDescription =
                product.title,

            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),

            contentScale =
                ContentScale.Crop
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = product.title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = product.description
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(

            text = "Brand: ${product.brand}",

            style =
                MaterialTheme.typography.titleMedium
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(

            text = "Stock: ${product.stock}",

            style =
                MaterialTheme.typography.titleMedium
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )
        Text(
            text = "$${product.price}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }

}