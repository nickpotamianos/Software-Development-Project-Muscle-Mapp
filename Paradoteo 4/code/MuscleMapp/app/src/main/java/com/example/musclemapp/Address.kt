package com.example.musclemapp

class Address(
    private val address_street: String,
    private val address_number: Int,
    private val address_postal_code: Int,
    private val address_city: String,
    private val address_country: String
) {
    fun get_address_street(): String {
        return address_street
    }

    fun get_address_number(): Int {
        return address_number
    }

    fun get_address_postal_code(): Int {
        return address_postal_code
    }

    fun get_address_city(): String {
        return address_city
    }

    fun get_address_country(): String {
        return address_country
    }
}