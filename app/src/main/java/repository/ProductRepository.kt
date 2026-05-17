package repository

import model.Product

/*
 * ProductRepository
 *
 * Handles product data operations.
 */
class ProductRepository(

    private val apiService: APIService
) {

    /*
     * Fetch all products
     */
    suspend fun getProducts(): List<Product> {
        return apiService
            .getProducts()
            .products
    }

    /*
     * Search products
     */
    suspend fun searchProducts(
        query: String
    ): List<Product> {
        return apiService
            .searchProducts(query)
            .products
    }
}
