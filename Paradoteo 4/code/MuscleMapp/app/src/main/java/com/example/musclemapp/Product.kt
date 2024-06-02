package com.example.musclemapp

class Product(
    private val product_id: Int,
    private val product_name: String,
    private val product_description: String,
    private val product_price: Float,
    private val product_stock_quantity: Int,
    private val product_reviews: ArrayList<Review>
) {
    fun get_product_id(): Int {
        return product_id
    }

    fun get_product_name(): String {
        return product_name
    }

    fun get_product_description(): String {
        return product_description
    }

    fun get_product_price(): Float {
        return product_price
    }

    fun get_product_stock_quantity(): Int {
        return product_stock_quantity
    }

    fun get_product_reviews(): ArrayList<Review> {
        return product_reviews
    }
}