plugins {

    alias(libs.plugins.android.application)

    alias(libs.plugins.kotlin.compose)
}

android {

    namespace = "com.example.volvo"

    compileSdk = 36

    defaultConfig {

        applicationId = "com.example.volvo"

        minSdk = 24

        versionCode = 1

        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {

        sourceCompatibility =
            JavaVersion.VERSION_11

        targetCompatibility =
            JavaVersion.VERSION_11
    }


    buildFeatures {

        compose = true
    }
}

dependencies {

    // Compose BOM
    implementation(
        platform(libs.androidx.compose.bom)
    )

    // Compose
    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.compose.material3)

    implementation(libs.androidx.compose.ui)

    implementation(libs.androidx.compose.ui.graphics)

    implementation(
        libs.androidx.compose.ui.tooling.preview
    )

    // Core Android
    implementation(libs.androidx.core.ktx)

    implementation(
        libs.androidx.lifecycle.runtime.ktx
    )
    implementation("io.coil-kt:coil-compose:2.7.0")

    implementation(
        "androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4"
    )

    implementation(
        "com.squareup.retrofit2:retrofit:2.11.0"
    )

    //Gson Converter.
    implementation(
        "com.squareup.retrofit2:converter-gson:2.11.0"
    )

    //Coroutines
    implementation(
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1"
    )

    //testing
    testImplementation(libs.junit)

    androidTestImplementation(
        platform(libs.androidx.compose.bom)
    )

    androidTestImplementation(
        libs.androidx.compose.ui.test.junit4
    )

    androidTestImplementation(
        libs.androidx.espresso.core
    )

    androidTestImplementation(
        libs.androidx.junit
    )

    // Debug
    debugImplementation(
        libs.androidx.compose.ui.test.manifest
    )

    debugImplementation(
        libs.androidx.compose.ui.tooling
    )
}