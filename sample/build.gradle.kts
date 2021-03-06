import java.io.FileInputStream
import java.util.Properties

plugins {
    id(Plugins.android_application)
    kotlin(Plugins.kotlin_android)
    kotlin(Plugins.kotlin_android_extensions)
    kotlin(Plugins.kapt)
}

android {
    compileSdkVersion(AndroidSdk.sdk_compile)

    defaultConfig {
        applicationId = "net.furkanakdemir.noticeboardsample"
        minSdkVersion(AndroidSdk.sdk_minimum)
        targetSdkVersion(AndroidSdk.sdk_target)
        versionCode = AndroidSdk.version_code
        versionName = AndroidSdk.version_name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    val properties = Properties()
    val fis = FileInputStream(rootProject.file("local.properties"))
    properties.load(fis)

    signingConfigs {
        getByName("debug") {
            storeFile = rootProject.file("debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
        create("release") {
            storeFile = rootProject.file("release.keystore")
            storePassword = properties.getProperty("sampleStorePassword")
            keyAlias = properties.getProperty("sampleKeyAlias")
            keyPassword = properties.getProperty("sampleKeyPassword")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro"
            )

            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":noticeboard"))

    implementation(Deps.kotlin)
    implementation(Deps.appcompat)
    implementation(Deps.constraintlayout)
    implementation(Deps.recyclerview)
    implementation(Deps.material)

    debugImplementation(Deps.leak_canary)

    // JUnit
    testImplementation(TestDeps.junit)
}
