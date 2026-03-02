// Root build.gradle.kts for KMP project

plugins {
    kotlin("multiplatform") version "1.5.30"
}

repositories {
    mavenCentral()
}

kotlin {
    jvm() // Android target
    ios() // iOS target

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
            }
        }
        val iosMain by getting
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["kotlin"])
            groupId = "com.example"
            artifactId = "shared"
            version = "0.0.1"
        }
    }
}