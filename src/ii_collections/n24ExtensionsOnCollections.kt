package ii_collections

fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { it.length }

    return groupsByLength.values.maxBy { it.count() }
}
