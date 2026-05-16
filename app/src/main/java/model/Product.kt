package model

/*
* Data class that represents
* a product from the API.
*
* Contains:
* - Product id
* - Product title
* - Product description
* - Product image
* - Product price
* - Product Brand
* - product stock
*/
data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String,
    val price: Double,
    val brand: String,
    val stock: Int
)
