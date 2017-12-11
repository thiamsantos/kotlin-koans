package ii_collections

fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = this.customers.groupBy { it.city }
