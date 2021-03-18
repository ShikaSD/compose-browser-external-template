plugins {
    kotlin("jvm") version "1.4.31"
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin"))
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
}
