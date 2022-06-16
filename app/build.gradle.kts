plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        applicationId = ProjectSetting.PROJECT_APP_ID
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK
        versionCode = ProjectSetting.PROJECT_VERSION_CODE
        versionName = ProjectSetting.PROJECT_VERSION_NAME

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Naming APK // AAB
        setProperty("archivesBaseName", "${ProjectSetting.NAME_APK}(${versionName})")

        // Inject app name for debug
        resValue("string", "app_name", ProjectSetting.nameAppDebug)

        // Inject admob id for debug
        resValue("string", "admob_publisher_id", AdmobID.debugAdmobPublisherId)
        resValue("string", "admob_banner", AdmobID.debugAdmobBanner)
        resValue("string", "admob_interstitial", AdmobID.debugAdmobInterstitial)
        resValue("string", "admob_interstitial_video", AdmobID.debugAdmobInterstitialVideo)
        resValue("string", "admob_rewarded", AdmobID.debugAdmobRewarded)
        resValue("string", "admob_rewarded_interstitial", AdmobID.debugAdmobRewardedInterstitial)
        resValue("string", "admob_native_advanced", AdmobID.debugAdmobNativeAdvanced)
        resValue("string", "admob_native_advanced_video", AdmobID.debugAdmobNativeAdvancedVideo)

    }


    signingConfigs {
        create("release") {
            // You need to specify either an absolute path or include the
            // keystore file in the same directory as the build.gradle file.
            // [PROJECT FOLDER NAME/app/[COPY YOUT KEY STORE] .jks in here
            storeFile = file(ProjectSetting.PLAYSTORE_STORE_FILE)
            storePassword = ProjectSetting.PLAYSTORE_STORE_PASSWORD
            keyAlias = ProjectSetting.PLAYSTORE_KEY_ALIAS
            keyPassword = ProjectSetting.PLAYSTORE_KEY_PASSWORD
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            // Generated Signed APK / AAB
            signingConfig = signingConfigs.getByName("release")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // Inject app name for release
            resValue("string", "app_name", ProjectSetting.NAME_APP)

            // Inject admob id for release
            resValue("string", "admob_publisher_id", AdmobID.releaseAdmobPublisherId)
            resValue("string", "admob_banner", AdmobID.releaseAdmobBanner)
            resValue("string", "admob_interstitial", AdmobID.releaseAdmobInterstitial)
            resValue("string", "admob_interstitial_video", AdmobID.releaseAdmobInterstitialVideo)
            resValue("string", "admob_rewarded", AdmobID.releaseAdmobRewarded)
            resValue("string", "admob_rewarded_interstitial", AdmobID.releaseAdmobRewardedInterstitial)
            resValue("string", "admob_native_advanced", AdmobID.releaseAdmobNativeAdvanced)
            resValue("string", "admob_native_advanced_video", AdmobID.releaseAdmobNativeAdvancedVideo)

        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependency.COMPOSE_VERSION
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

}

dependencies {
    
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.preference:preference-ktx:1.2.0")

    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.google.android.material:material:1.7.0-alpha02")
    implementation("com.google.android.gms:play-services-ads:21.0.0")

    implementation("com.github.amirisback:frogo-admob:4.4.0")
    implementation("com.github.amirisback:frogo-log:2.0.6")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")

}
