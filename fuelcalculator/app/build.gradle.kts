plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.fuelcalculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fuelcalculator"
        minSdk = 31
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

dependencies {
    // Implementa a biblioteca Kotlin extensions para componentes principais do Android
    implementation(libs.androidx.core.ktx)
    // Implementa a biblioteca Kotlin extensions para o ciclo de vida do Android
    implementation(libs.androidx.lifecycle.runtime.ktx)
    // Implementa a biblioteca Jetpack Compose para atividades
    implementation(libs.androidx.activity.compose)
    // Implementa a Bill of Materials (BoM) para Jetpack Compose, gerenciando versões das dependências
    implementation(platform(libs.androidx.compose.bom))
    // Implementa a biblioteca Material3 para Jetpack Compose
    implementation("androidx.compose.material3:material3:1.2.1")
    // Implementa bibliotecas adicionais do Jetpack Compose UI
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    // Implementa a biblioteca Material3 a partir da definição no arquivo de versões compartilhadas
    implementation(libs.androidx.material3)
    // Implementa a biblioteca de navegação para Jetpack Compose
    implementation(libs.androidx.navigation.compose)
    // Implementa a biblioteca de testes JUnit
    testImplementation(libs.junit)
    // Implementa a biblioteca JUnit para testes instrumentados no Android
    androidTestImplementation(libs.androidx.junit)
    // Implementa a biblioteca Espresso para testes de UI no Android
    androidTestImplementation(libs.androidx.espresso.core)
    // Implementa a Bill of Materials (BoM) para Jetpack Compose nos testes instrumentados no Android
    androidTestImplementation(platform(libs.androidx.compose.bom))
    // Implementa a biblioteca JUnit4 para testes de UI no Jetpack Compose
    androidTestImplementation(libs.androidx.ui.test.junit4)
    // Implementa a biblioteca de ferramentas de UI para debug no Jetpack Compose
    debugImplementation(libs.androidx.ui.tooling)
    // Implementa a biblioteca de manifesto de teste para debug no Jetpack Compose
    debugImplementation(libs.androidx.ui.test.manifest)
}

