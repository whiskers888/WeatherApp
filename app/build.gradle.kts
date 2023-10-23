plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}


android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    implementation (project(":domain"))

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-tooling:1.6.0-alpha04")
    implementation ("androidx.compose.material:material-icons-extended:1.6.0-alpha04")
    implementation ("androidx.compose.material:material:1.6.0-alpha04")
    implementation ("androidx.compose.runtime:runtime-livedata:1.6.0-alpha04")

    testImplementation ("junit:junit:4.13.2")

    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.6.0-alpha04")

    // Accompanist
    implementation ("com.google.accompanist:accompanist-insets:0.24.1-alpha")
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.24.1-alpha")

    //Dagger2
    val daggerVersion = "2.48"
    implementation ("com.google.dagger:dagger:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")

    //hilt
    val hiltVersion = "2.33-beta"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    //implementation("com.google.dagger:hilt-android-testing:$hiltVersion")
    kapt("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
}