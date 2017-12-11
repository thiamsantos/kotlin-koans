package i_introduction._10_Object_Expressions

import java.util.*

fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object : Comparator<Int> {
        override fun compare(a: Int, b: Int): Int = if (a < b) 1 else -1
    })
    return arrayList
}
