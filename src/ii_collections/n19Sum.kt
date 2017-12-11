package ii_collections

fun Customer.getTotalOrderPrice(): Double = this.orders.flatMap { it.products }.sumByDouble { it.price }
