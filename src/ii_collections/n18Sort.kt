package ii_collections

fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> = this.customers.sortedBy { it.orders.count() }
