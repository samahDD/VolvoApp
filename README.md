# A Product Store App

A modern Android shopping application built using Kotlin and Jetpack Compose.  
The app fetches products from an online API and displays them in a clean and interactive user interface.

---

# Features

## Product List Screen
- Fetches products from the DummyJSON API
- Displays product image, title, price, and rating
- Modern card-based UI using Jetpack Compose
- Scrollable product list using LazyColumn

## Search Functionality
- Real-time product search
- Uses API search endpoint:

```text
https://dummyjson.com/products/search?q={query}
```

- Updates products automatically while typing

## Product Details Screen
- Opens when a product card is clicked
- Displays:
  - Product image
  - Product title
  - Full description
  - Product brand
  - Stock status
  - Product price
- Includes back button navigation

## State Management
- Handles:
  - Loading state
  - Success state
  - Error state
- UI automatically updates when state changes

---

# Technologies Used

- Kotlin
- Jetpack Compose
- Retrofit
- Coil
- Coroutines
- Material 3
- Navigation Compose
- MVI Architecture

---

# Architecture

The project follows the MVI (Model-View-Intent) architecture.

# Project Structure

```text
intent/
model/
repository/
state/
ui/
viewModel/
```

## Folder Explanation

### model/
Contains data models used in the application.

Classes
- Product
- ProductResponse

### repository/
Handles API communication and data operations.

Classes
- APIService
- ProductRepository

### viewModel/
Contains business logic and state management.

Class
- ProductViewModel

### state/
Contains UI state classes.

Class
- ProductState

### intent/
Contains user actions/intents.

Class
- ProductIntent

### ui/
Contains all Jetpack Compose UI screens.

Classes
- ProductListScreen
- ProductDetailScreen

---

# API

This project uses the DummyJSON API.

## Get Products

```text
https://dummyjson.com/products
```

## Search Products

```text
https://dummyjson.com/products/search?q={query}
```

---

# Libraries

## Retrofit
Used for API communication.

## Coil
Used for loading product images from URLs.

## Coroutines
Used for asynchronous background operations.

## Navigation Compose
Used for screen navigation.

---

# How the App Works

1. User opens the app
2. ProductIntent.LoadProducts is triggered
3. ViewModel requests products from Repository
4. Repository fetches data from APIService
5. ProductState updates the UI
6. Products are displayed on screen
7. User can search products using the search bar
8. User can click a product to open details screen
9. User can navigate back to the product list

---

# Future Improvements

- Add product categories
- Add filtering options
- Add dark mode support
- Add offline caching using Room Database
- Add authentication system
- Add pagination
- Add favorites functionality
- Improve UI animations

---

# Implemented by 

Samah Diab

# Always remember, Am I testing the code or the code is testing me ????
