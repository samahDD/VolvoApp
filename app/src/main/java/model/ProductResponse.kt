package model

/*
 * The API returns a list of products
 * inside the "products" field (As a list)
 */
data class ProductResponse(

    val products: List<Product>
)