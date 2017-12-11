package ii_collections

fun Shop.getCitiesCustomersAreFrom(): Set<City> = this.customers.map { it.city }.toSet()

fun Shop.getCustomersFrom(city: City): List<Customer> = this.customers.filter { it.city.equals(city) }
