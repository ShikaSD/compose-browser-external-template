plugins {
    id("org.jetbrains.kotlin.js")
}

repositories {
    mavenCentral()
    jcenter()
    libsRepository(project)
}

configureComposeCompiler()

kotlin {
    js(IR) {
        browser {
            binaries.executable()
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    implementation("compose.web:prelude")
}
