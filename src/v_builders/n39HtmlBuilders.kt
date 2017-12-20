package v_builders

import v_builders.data.getProducts
import v_builders.htmlLibrary.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) % 2 == 0) "#dce4ff" else "#eff2ff"

fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts().map { listOf(it.description, it.price, it.popularity) }
            for ((row, product) in products.withIndex()) {
                tr {
                    for ((column, cell) in product.withIndex()) {
                        td(getCellColor(row, column)) {
                            text(cell)
                        }
                    }
                }
            }
        }
    }.toString()
}
