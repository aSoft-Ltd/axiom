pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
}

rootProject.name = "axiom"
include(":axiom-core")
include(":sample:solar-system")
project(":sample:solar-system").projectDir = File("samples/solar-system")
