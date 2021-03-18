import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.maven
import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import java.io.File

val Project.composeWebRoot: String get() = property("compose-web-root").toString()

fun RepositoryHandler.libsRepository(project: Project) {
    maven(url = File(project.composeWebRoot, "libs").toURI())
}

fun DependencyHandlerScope.composeRuntimeJs(): Dependency = create("androidx.compose.runtime:runtime-js:1.0.0-beta02")

fun Project.configureComposeCompiler() {
    dependencies {
        "kotlinCompilerPluginClasspath"(files("$composeWebRoot/libs/embedded.jar"))
    }

    extensions.getByType<KotlinJsProjectExtension>().apply {
        js(IR) {
            compilations.configureEach {
                kotlinOptions.freeCompilerArgs += listOf(
                    "-Xopt-in=kotlin.RequiresOptIn",
                    "-P", "plugin:androidx.compose.compiler.plugins.kotlin:generateDecoys=true"
                )
            }
        }
    }
}

