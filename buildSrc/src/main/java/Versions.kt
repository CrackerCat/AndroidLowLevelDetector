object Versions {
    object AndroidBuild {
        const val androidGradlePlugin = "7.1.0-beta05"

        // https://developer.android.com/studio/releases/build-tools.html#notes
        const val buildToolsVersion = "32.0.0"

        const val minSdkVersion = 21
        const val compileSdkVersion = 32
        const val targetSdkVersion = 32

        const val ndkVersion = "24.0.7956693 rc2"
        const val cmake = "3.22.1"

        const val versionCode = 59
        const val versionName = "1.15.7_unpublished"
    }

    // https://developer.android.com/studio/write/java8-support#library-desugaring
    // https://maven.google.com/web/index.html?q=desugar_jdk_libs
    // https://github.com/google/desugar_jdk_libs/blob/master/CHANGELOG.md
    const val desugarJdkLibs = "1.1.5"

    // region [AndroidX]
    // https://maven.google.com
    // https://androidstudio.googleblog.com/
    // https://developer.android.com/jetpack/androidx/versions
    object AndroidX {
        // https://github.com/material-components/material-components-android/releases
        const val material = "1.5.0-rc01"

        const val activity = "1.4.0"

        const val annotation = "1.3.0"
        const val annotationExperimental = "1.2.0"

        const val appcompat = "1.4.0"

        const val archCore = "2.1.0"

        const val cardview = "1.0.0"

        const val coordinatorLayout = "1.2.0-rc01"

        const val constraintLayout = "2.1.2"

        const val core = "1.7.0"

        const val fragment = "1.4.0"

        const val lifecycle = "2.4.0"

        const val preference = "1.2.0-rc01"

        const val recyclerView = "1.2.1"

        const val savedstate = "1.1.0"

        const val swipeRefreshLayout = "1.1.0"

        const val webkit = "1.4.0"

        // https://developer.android.com/jetpack/androidx/releases/test
        object Test {
            const val junit = "4.13.2"
            const val extJunit = "1.1.3"
            const val espressoCore = "3.4.0"
        }
    }

    object Kotlin {
        // https://github.com/JetBrains/kotlin/releases
        // https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.jetbrains.kotlin%22
        const val kotlin = "1.6.10"

        // https://github.com/Kotlin/kotlinx.coroutines/releases
        const val coroutines = "1.6.0-RC3"

        // https://github.com/Kotlin/kotlinx.serialization/releases
        const val serialization = "1.3.1"
    }

    // https://firebase.google.com/support/release-notes/android
    // https://firebase.google.com/docs/android/setup#available-libraries
    object Firebase {
        const val googleServices = "4.3.10"

        // https://firebase.google.com/docs/android/learn-more#bom
        const val billOfMaterials = "29.0.3"

        // https://firebase.google.com/docs/crashlytics/get-started?platform=android
        // https://firebase.google.com/docs/crashlytics/ndk-reports
        const val firebaseCrashlyticsGradlePlugin = "2.8.1"
    }

    object ThirdParties {
        // https://github.com/topjohnwu/libsu/releases
        const val libsu = "3.2.1"

        // https://github.com/square/leakcanary/releases
        const val leakCanary = "2.7"

        // https://github.com/kittinunf/fuel/releases
        const val fuel = "2.3.1"

        // https://github.com/G00fY2/version-compare/releases
        const val versionCompare = "1.4.1"
    }
}