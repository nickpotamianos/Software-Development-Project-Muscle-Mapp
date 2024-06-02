package com.example.musclemapp

class Cart(
    private val cart_items: ArrayList<Product>,
    private var cart_total_cost: Float
) {
    fun add_to_cart(product: Product) {
        cart_items.add(product)
    }

    fun remove_from_cart(product_id: Int): Boolean {
        val iterator = cart_items.iterator()
        while (iterator.hasNext()) {
            val product = iterator.next()
            if (product.get_product_id() == product_id) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    fun calculate_total_cost(): Float {
        var total_cost: Float = 0F
        for (product in cart_items) {
            total_cost += product.get_product_price()
        }
        cart_total_cost = total_cost
        return cart_total_cost
    }

    fun get_cart_items(): ArrayList<Product> {
        return cart_items
    }

    fun get_cart_total_cost(): Float {
        return cart_total_cost
    }
}