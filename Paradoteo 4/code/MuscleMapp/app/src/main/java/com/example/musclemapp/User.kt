package com.example.musclemapp

abstract class User(
    private var user_id: Int,
    private var user_username: String,
    private var user_email: String,
    private var user_password: String
) {
    fun give_feedback(feedback_message: String) {
        Database.database_feedback.add(feedback_message)
    }

    fun get_user_id(): Int {
        return user_id
    }

    fun get_user_username(): String {
        return user_username
    }

    fun get_user_email(): String {
        return user_email
    }

    fun get_user_password(): String {
        return user_password
    }
}