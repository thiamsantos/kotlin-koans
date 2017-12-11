package ii_collections

val Customer.orderedProducts: Set<Product>
    get() = this.orders.flatMap { it.products }.toSet()
val Shop.allOrderedProducts: Set<Product>
    get() = this.customers.flatMap { it.orderedProducts }.toSet()
