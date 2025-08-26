package tax.bilibili.nineblog

import kotlinx.browser.document
import react.create
import react.dom.client.createRoot
import web.html.HTMLDivElement

fun main() {
    val container = document.getElementById("root") as HTMLDivElement
    createRoot(container).render(App.create())
}