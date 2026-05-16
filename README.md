# A Product Store App

An Android shopping application that is build using Kotlin language and Jetpack Compose. My App is feaches productes from an online API then displays them in a clean and scrollable user interface.

## Features 

1. Fetch products from API
2. Modern UI with Jetpack Compose
3.  Product image loading using Coil
4. Scrollable product list
5. State management using MVI(Model-View-Intent) architecture
6. Retrofit networking
7. Loading and error handling

---

## Technologies Used

- Kotlin
- Jetpack Compose
- Retrofit
- Coil
- Coroutines
- Material 3
- MVI Architecture

## Architecture

The project follows the MVI (Model-View-Intent) architecture.

UI → Intent → ViewModel → Repository → API → State → UI

---

# Folder Structure

```text
model/
repository/
viewModel/
state/
intent/
ui/
```

---

# How It Works

1. User opens the app  
2. ProductIntent triggers product loading  
3. ViewModel requests data from Repository  
4. Repository fetches data using Retrofit  
5. ProductState updates the UI  
6. Jetpack Compose automatically recomposes the screen
