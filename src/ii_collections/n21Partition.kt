package ii_collections

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    return this.customers.filter {
        val (delivered, undelivered) = it.orders.partition { it.isDelivered }
        undelivered.count() > delivered.count()
    }.toSet()
}
