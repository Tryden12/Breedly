plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.tryden.breedly"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tryden.breedly"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")


    // Material design
    implementation("androidx.compose.material:material:1.3.0")
    implementation("androidx.compose.material:material-icons-extended:1.3.0")
    implementation("com.google.android.material:material:1.7.0")

    // Hilt dependency injection
    implementation ("com.google.dagger:hilt-android:2.43.2")
    implementation ("androidx.appcompat:appcompat:1.5.1")
    kapt ("com.google.dagger:hilt-compiler:2.43.2")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Okhttp3
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    api("com.squareup.okhttp3:logging-interceptor:4.9.1")

    // Retrofit2 and Moshi
    api("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    // Room Persistence
    implementation("androidx.room:room-ktx:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3")

    // Compose navigation
    implementation("androidx.navigation:navigation-compose:2.6.0-alpha03")

    // Navigation animation
    implementation("com.google.accompanist:accompanist-navigation-animation:0.25.1")

    // View pager
    implementation("com.google.accompanist:accompanist-pager:0.25.1")

    // Coil
    implementation("io.coil-kt:coil:2.2.0")
    implementation("io.coil-kt:coil-compose:2.2.0")
    implementation("io.coil-kt:coil-svg:2.2.0")



    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Mockk
    testImplementation("io.mockk:mockk:1.12.5")

    // Coroutines testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("androidx.arch.core:core-testing:2.1.0")

    // Kotest
    testImplementation("io.kotest:kotest-assertions-core:5.4.2")
    testApi("org.jetbrains.kotlin:kotlin-test")

    // Debug
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}