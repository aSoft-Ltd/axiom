import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    jvm()
    js(IR) { browser() }
//    wasm { browser() }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.ui)
                api(compose.foundation)
                api(compose.material)
                api(projects.aestheticsCompose)
            }
        }

        val canvasMain by creating {
            dependsOn(commonMain)
        }

        val commonTest by getting {
            dependencies {
                api(projects.expectCore)
            }
        }

        val androidMain by getting {
            dependsOn(canvasMain)
            dependencies {
                api(compose.foundation)
                api(compose.uiTooling)
                api(compose.preview)
                api("androidx.appcompat:appcompat:1.4.1")
                api("androidx.activity:activity-compose:1.4.0")
            }
        }

        val jvmMain by getting {
            dependsOn(canvasMain)
            dependencies {
                api(compose.uiTooling)
                api(compose.preview)
                api(compose.desktop.currentOs)
            }
        }

//        val wasmMain by getting {
//            dependsOn(canvasMain)
//            dependencies {
//                api(compose.web.core)
//            }
//        }

        val jsMain by getting {
            dependencies {
                api(compose.web.core)
            }
        }
    }
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "11"
//}

android {
    compileSdk = 32

    namespace = "tz.co.asoft.axiom"

    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        buildConfig = false
        compose = true
    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.3.2"
//    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
//            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
//        }
        }
    }
}

compose {
//    kotlinCompilerPlugin.set(dependencies.compiler.forKotlin("1.8.0"))
    kotlinCompilerPlugin.set(kotlinz.versions.compose.compiler)
    kotlinCompilerPluginArgs.add(kotlinz.versions.compose.compiler.map {
        "suppressKotlinVersionCompatibilityCheck=$it"
    })
}

tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinCompile::class).configureEach {
    kotlinOptions {
        val v = kotlinz.versions.kotlin.get()
        freeCompilerArgs += listOf(
            "-P", "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=$v"
        )
    }
}