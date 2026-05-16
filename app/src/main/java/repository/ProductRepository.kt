package repository

import model.Product

class ProductRepository(
    private val apiService: APIService
){

    /*
    * The suspend function fetches products from API source
    * and returns the product list.
    */
    suspend fun getProducts(): List<Product>{
        return apiService.getProducts().products
    }
}