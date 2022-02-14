import org.jetbrains.compose.compose

plugins {
    id("com.android.library")
    id("kotlin-multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm("desktop")
    android()

    // Uncomment this when compose dev preview with ios/android/desktop will be ready
//    macosX64 {
//        binaries {
//            executable {
//                entryPoint = "main"
//                freeCompilerArgs += listOf(
//                    "-linker-option", "-framework", "-linker-option", "Metal"
//                )
//            }
//        }
//    }
//    macosArm64 {
//        binaries {
//            executable {
//                entryPoint = "main"
//                freeCompilerArgs += listOf(
//                    "-linker-option", "-framework", "-linker-option", "Metal"
//                )
//            }
//        }
//    }
//    iosX64("uikitX64") {
//        binaries {
//            executable() {
//                entryPoint = "main"
//                freeCompilerArgs += listOf(
//                    "-linker-option", "-framework", "-linker-option", "Metal",
//                    "-linker-option", "-framework", "-linker-option", "CoreText",
//                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
//                )
//                // TODO: the current compose binary surprises LLVM, so disable checks for now.
//                freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
//            }
//        }
//    }
//    iosArm64("uikitArm64") {
//        binaries {
//            executable() {
//                entryPoint = "main"
//                freeCompilerArgs += listOf(
//                    "-linker-option", "-framework", "-linker-option", "Metal",
//                    "-linker-option", "-framework", "-linker-option", "CoreText",
//                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
//                )
//                // TODO: the current compose binary surprises LLVM, so disable checks for now.
//                freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
//            }
//        }
//    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
            }
        }

        named("androidMain") {
            dependencies {
                implementation("androidx.appcompat:appcompat:1.4.0-alpha03")
                implementation("androidx.core:core-ktx:1.6.0")
            }
        }

        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.common)
            }
        }

        // Uncomment this when compose dev preview with ios/android/desktop will be ready
//        val nativeMain by creating {
//            dependsOn(commonMain)
//        }
//        val macosMain by creating {
//            dependsOn(nativeMain)
//        }
//        val macosX64Main by getting {
//            dependsOn(macosMain)
//        }
//        val macosArm64Main by getting {
//            dependsOn(macosMain)
//        }
//        val uikitMain by creating {
//            dependsOn(nativeMain)
//        }
//        val uikitX64Main by getting {
//            dependsOn(uikitMain)
//        }
//        val uikitArm64Main by getting {
//            dependsOn(uikitMain)
//        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}