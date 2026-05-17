package viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import intent.ProductIntent
import kotlinx.coroutines.launch
import repository.ProductRepository
import state.ProductState

/*
 * Handles business logic
 * and manages UI state.
 * Receives user intents
 * Fetches products from repository
 * Updates ProductState
 * Handles loading and errors
 */
class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    /*
    * Holds the current UI state and
    * Composes auto updates the UI when state changes
    */
    var state = mutableStateOf(
        ProductState()
    )
        private set
    /*
    * the func receives user intents
    * and performs actions as well
    */
    fun processIntent(
        intent: ProductIntent
    ) {
        when(intent) {
            is ProductIntent.LoadProducts -> {
                loadProducts()
            }
            is ProductIntent.SearchProducts -> {
                searchProducts(intent.query)
            }
        }
    }

    /*
     * fetches products from repository package
     * using Kotlin Coroutines.
     */
    private fun loadProducts() {
        viewModelScope.launch {
            state.value = ProductState(
                isLoading = true
            )
            try {
                val products =
                    repository.getProducts()
                state.value = ProductState(
                    products = products
                )
            } catch (e: Exception) {
                state.value = ProductState(
                    error = e.message ?: "Unknown error"
                )
            }
        }
    }

    private fun searchProducts(

        query: String
    ) {
        viewModelScope.launch {
            try {
                val products =
                    repository.searchProducts(query)
                state.value = ProductState(
                    products = products
                )

            } catch (e: Exception) {
                state.value = ProductState(
                    error =
                        e.message ?: "Search failed"
                )
            }
        }
    }
}
