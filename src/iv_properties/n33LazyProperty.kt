package iv_properties

class LazyProperty(val initializer: () -> Int) {
    private var lazyValue: Int? = null
    val lazy: Int
        get() {
            if (lazyValue == null) {
                lazyValue = initializer()
            }

            return lazyValue!!
        }
}
