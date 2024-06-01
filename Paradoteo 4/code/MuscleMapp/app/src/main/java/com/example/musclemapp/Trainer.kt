package com.example.musclemapp

class Trainer(
    user_id: Int,
    user_first_name: String,
    user_last_name: String,
    user_email: String,
    user_password: String
) : User(user_id, user_first_name, user_last_name, user_email, user_password) {
    override fun user_type(): String {
        return "Trainer"
    }
}