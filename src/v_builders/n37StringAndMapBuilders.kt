package v_builders

fun buildMap(build: MutableMap<Int, String>.() -> Unit): Map<Int, String> {
    val map = mutableMapOf<Int, String>()
    map.build()
    return map
}

fun task37(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
