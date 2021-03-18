import compose.web.renderComposable
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    window.onload = {
        renderComposable(document.body!!) {
        }
    }
}
