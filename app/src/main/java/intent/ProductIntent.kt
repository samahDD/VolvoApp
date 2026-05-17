package intent

/*
 * ProductIntent
 *
 * Represents user actions
 * in the application.
 */

sealed class ProductIntent {
    /*
     * Load all products
     */
    object LoadProducts : ProductIntent()
    /*
     * Search products
     */
    data class SearchProducts(
        val query: String
    ) : ProductIntent()
}
