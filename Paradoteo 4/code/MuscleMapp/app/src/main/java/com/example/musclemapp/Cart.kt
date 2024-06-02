package com.example.musclemapp

class Cart(
    private val cart_items: ArrayList<Product>,
    private val cart_total_cost: Float
) {
    fun get_cart_items(): ArrayList<Product> {
        return cart_items
    }

    fun get_cart_total_cost(): Float {
        return cart_total_cost
    }
}