package ii_collections

fun Customer.isFrom(city: City): Boolean = this.city.equals(city)

fun Shop.checkAllCustomersAreFrom(city: City): Boolean = this.customers.all { it.isFrom(city) }

fun Shop.hasCustomerFrom(city: City): Boolean = this.customers.any { it.isFrom(city) }

fun Shop.countCustomersFrom(city: City): Int = this.customers.count { it.isFrom(city) }

fun Shop.findFirstCustomerFrom(city: City): Customer? = this.customers.firstOrNull { it.isFrom(city) }
