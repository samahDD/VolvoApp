package repository

import model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * Retrofit interface used
 * for network requests
 * This interface communicates
 * with the DummyJSON API.
 */
interface APIService {

    @GET("products")
    suspend fun getProducts(): ProductResponse
    @GET("products/search")
    suspend fun searchProducts(
        @Query("q") query: String
    ): ProductResponse
}
