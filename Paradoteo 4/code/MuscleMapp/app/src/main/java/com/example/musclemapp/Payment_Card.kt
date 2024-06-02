package com.example.musclemapp

import java.util.Date

class Payment_Card(
    private val payment_card_number: Int,
    private val payment_card_holder_name: String,
    private val payment_card_cvv: Int,
    private val payment_card_expiration_date: Date
) {
    fun get_payment_card_number(): Int {
        return payment_card_number
    }

    fun get_payment_card_holder_name(): String {
        return payment_card_holder_name
    }

    fun get_payment_card_cvv(): Int {
        return payment_card_cvv
    }

    fun get_payment_card_expiration_date(): Date {
        return payment_card_expiration_date
    }
}