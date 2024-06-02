package com.example.musclemapp

import java.util.Date
class Order(
    private val order_id: Int,
    private val order_establishment_id: Int,
    private val order_client_id: Int,
    private val order_date: Date,
    private val order_status: String,
    private val order_estimated_delivery_date: Date,
    private val order_payment_card_id: Int,
    private val order_contents: ArrayList<Product>
) {
    fun get_order_id(): Int {
        return order_id
    }

    fun get_order_establishment_id(): Int {
        return order_establishment_id
    }

    fun get_order_client_id(): Int {
        return order_client_id
    }

    fun get_order_date(): Date {
        return order_date
    }

    fun get_order_status(): String {
        return order_status
    }

    fun get_order_estimated_delivery_date(): Date {
        return order_estimated_delivery_date
    }

    fun get_order_payment_card_id(): Int {
        return order_payment_card_id
    }

    fun get_order_contents(): ArrayList<Product> {
        return order_contents
    }
}