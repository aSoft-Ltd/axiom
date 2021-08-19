import org.jetbrains.compose.compose

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 26
        targetSdk = 30
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
        }
    }
}

kotlin {
    android()
    jvm()
    js(IR) {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.web.widgets)
                api(compose.runtime)
            }
        }

        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:${vers.androidX.appCompat}")
                api("androidx.core:core-ktx:${vers.androidX.core}")
            }
        }

        val jvmMain by getting {
            dependencies {
                api(compose.desktop.currentOs)
            }
        }

        val jsMain by getting {
            dependencies {

            }
        }
    }
}