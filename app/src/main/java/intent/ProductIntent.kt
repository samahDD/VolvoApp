package intent

/*
 * This file contains user actions
 * The ViewModel listens to these actions,
 * and performs tasks based on them
 */
sealed class ProductIntent {
    object LoadProducts: ProductIntent()
}