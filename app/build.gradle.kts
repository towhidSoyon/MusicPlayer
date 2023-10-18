plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.towhid.musicplayer"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.towhid.musicplayer"
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

    /*implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.compose.material3:material3:1.1.0-alpha02")
    implementation("com.google.android.material:material:1.4.0")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-rc01")

    //coil
    implementation("io.coil-kt:coil-compose:1.4.0")

    //glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")

    //palette
    implementation("androidx.palette:palette-ktx:1.0.0")

    //timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    //accompanists
    implementation("com.google.accompanist:accompanist-insets:0.22.0-rc")
    implementation("com.google.accompanist:accompanist-pager:0.22.0-rc")

    //firebase
    implementation(platform("com.google.firebase:firebase-bom:29.0.3"))
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.4.2")

    //hilt
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-compiler:2.38.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-rc01")

    //exoplayer
    implementation("com.google.android.exoplayer:exoplayer-core:2.16.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.16.1")
    implementation("com.google.android.exoplayer:exoplayer-dash:2.16.1")
    implementation("com.google.android.exoplayer:exoplayer-smoothstreaming:2.16.1")
    implementation("com.google.android.exoplayer:extension-mediasession:2.16.1")

    //room
    implementation("androidx.room:room-ktx:2.4.0")
    implementation("androidx.room:room-runtime:2.4.0")
    kapt("androidx.room:room-compiler:2.4.0")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.2.1")

    //unit testing
    kaptTest("com.google.dagger:hilt-android-compiler:2.38.1")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    testImplementation("app.cash.turbine:turbine:0.7.0")
//    testImplementation "io.mockk:mockk:$mockK_version"
//    testImplementation "io.mockk:mockk-agent-jvm:$mockK_version"

    //android testing
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.38.1")
    androidTestImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.38.1")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    androidTestImplementation("app.cash.turbine:turbine:0.7.0")
    androidTestImplementation("io.mockk:mockk-android:1.12.2")
    androidTestImplementation("io.mockk:mockk-agent-android:1.12.2")
    // Test rules and transitive dependencies:
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.5")
    // Needed for createComposeRule, but not createAndroidComposeRule:
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.0.5")*/


    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.compose.ui:ui:1.0.5")
    implementation("androidx.compose.material:material:1.0.5")
    implementation("androidx.compose.ui:ui-tooling-preview:1.0.5")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.activity:activity-compose:1.4.0")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.5")
    debugImplementation("androidx.compose.ui:ui-tooling:1.0.5")
    implementation("androidx.compose.material3:material3:1.0.0-alpha02")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-rc01")

    //coil
    implementation("io.coil-kt:coil-compose:1.4.0")

    //glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")

    //palette
    implementation("androidx.palette:palette-ktx:1.0.0")

    //timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    //accompanists
    /*implementation("com.google.accompanist:accompanist-insets:0.22.0-rc")
    implementation("com.google.accompanist:accompanist-pager:$0.22.0-rc")*/

    //firebase
    implementation(platform("com.google.firebase:firebase-bom:29.0.3"))
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.4.2")

    //hilt
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-compiler:2.38.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-rc01")

    //exoplayer
    implementation("com.google.android.exoplayer:exoplayer-core:2.16.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.16.1")
    implementation("com.google.android.exoplayer:exoplayer-dash:2.16.1")
    implementation("com.google.android.exoplayer:exoplayer-smoothstreaming:2.16.1")
    implementation("com.google.android.exoplayer:extension-mediasession:2.16.1")

    //room
    implementation("androidx.room:room-ktx:2.4.0")
    implementation("androidx.room:room-runtime:2.4.0")
    kapt("androidx.room:room-compiler:2.4.0")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.2.1")

    //unit testing
    kaptTest("com.google.dagger:hilt-android-compiler:2.38.1")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    testImplementation("app.cash.turbine:turbine:0.7.0")
//    testImplementation "io.mockk:mockk:$mockK_version"
//    testImplementation "io.mockk:mockk-agent-jvm:$mockK_version"

    //android testing
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.38.1")
    androidTestImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.38.1")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    androidTestImplementation("app.cash.turbine:turbine:0.7.0")
    androidTestImplementation("io.mockk:mockk-android:1.12.2")
    androidTestImplementation("io.mockk:mockk-agent-android:1.12.2")
    // Test rules and transitive dependencies:
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.5")
    // Needed for createComposeRule, but not createAndroidComposeRule:
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.0.5")


//    implementation('com.google.apis:google-api-services-youtube:v3-rev20210915-1.32.1')
//
//    implementation 'com.github.yausername.youtubedl-android:library:0.13.+'

}