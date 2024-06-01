package com.example.musclemapp

abstract class User(
    var user_id: Int,
    var user_first_name: String,
    var user_last_name: String,
    var user_email: String,
    var user_password: String
) {
    fun get_user_id(): Int {
        return user_id
    }

    fun get_user_first_name(): String {
        return user_first_name
    }

    fun get_user_last_name(): String {
        return user_last_name
    }

    fun get_user_email(): String {
        return user_email
    }

    fun get_user_password(): String {
        return user_password
    }

    abstract fun user_type(): String
}