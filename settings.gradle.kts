import java.util.Properties

val properties = File(rootDir, "gradle.properties").inputStream().use {
    Properties().apply { load(it) }
}
val composeWebRoot = properties.getProperty("compose-web-root")

includeBuild(composeWebRoot) {
    dependencySubstitution {
        substitute(module("compose.web:prelude")).with(project(":prelude"))
    }
}
