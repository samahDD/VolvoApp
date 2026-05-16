package state
import model.Product
/*
* Represents the current UI state of the product screen
* Contains the loading state, product list, and error message
*/
data class ProductState (
    val isLoading: Boolean =false,
    val products: List<Product> =emptyList(),
    val error: String = ""
)