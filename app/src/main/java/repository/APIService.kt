package repository

import model.ProductResponse
import retrofit2.http.GET

/*
 * Retrofit interface used
 * for network requests
 * This interface communicates
 * with the DummyJSON API.
 */
interface APIService {

    @GET("products")
    suspend fun getProducts(): ProductResponse
}