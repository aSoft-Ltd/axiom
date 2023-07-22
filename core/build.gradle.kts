import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm { targetJava() }
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
                api(projects.kommanderCore)
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

compose {
    kotlinCompilerPlugin.set(kotlinz.versions.compose.compiler)
//    kotlinCompilerPluginArgs.add(kotlinz.versions.kotlin.map {
//        "suppressKotlinVersionCompatibilityCheck=$it"
//    })
}

tasks.withType(KotlinCompile::class).configureEach {
    kotlinOptions {
        val v = kotlinz.versions.kotlin.get()
        freeCompilerArgs += listOf(
            "-P", "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=$v"
        )
    }
}