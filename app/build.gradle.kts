plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.javicia.seguriapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.javicia.seguriapp"
        minSdk = 21
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
kapt {
    correctErrorTypes = true
}
dependencies {

    val hiltVersion = "2.45"
    val Room = "2.6.1"
    val navVersion = "2.5.3"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)


    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)


    implementation(libs.androidx.navigation.compose)

    // icons
    implementation(libs.androidx.material.icons.extended)

    //Constraint
    implementation (libs.androidx.constraintlayout.compose)

    //Splash
    implementation(libs.androidx.core.splashscreen)

    //Room
    implementation("androidx.room:room-ktx:${Room}")
    implementation ("androidx.room:room-runtime:${Room}")
    kapt("androidx.room:room-compiler:${Room}")
    implementation ("androidx.room:room-paging:${Room}")

    //Firebase
    implementation(libs.firebase.bom)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.auth)
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation(libs.firebase.storage)

    //Analytics
    implementation ("com.google.firebase:firebase-analytics-ktx:21.6.2")


    // Dependency for Firebase Android 11
    implementation (libs.grpc.okhttp)

    //Coroutines - Firebase
    implementation (libs.kotlinx.coroutines.play.services)

    //Gson
    implementation (libs.gson)

    //shimmer
    implementation (libs.shimmer)

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}