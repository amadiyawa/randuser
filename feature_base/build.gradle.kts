
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.amadiyawa.feature_base"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    api(libs.kotlin)
    api(libs.playCore)
    api(libs.androidx.core.ktx)
    api(libs.timber)
    api(libs.androidx.appcompat)
    api(libs.coroutines)
    api(libs.material)
    api(libs.androidx.activity.compose)
    api(libs.navigationCompose)
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.material3)
    api(libs.androidx.material3.android)
    api(libs.bundles.koin)
    api(libs.bundles.retrofit)
    api(libs.bundles.compose)
    api(libs.bundles.koin)
    api(libs.bundles.retrofit)
    api(libs.bundles.lifecycle)
    api(libs.bundles.room)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}