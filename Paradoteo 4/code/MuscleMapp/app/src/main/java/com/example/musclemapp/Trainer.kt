package com.example.musclemapp

class Trainer(
    user_id: Int,
    user_username: String,
    user_email: String,
    user_password: String
) : User(user_id, user_username, user_email, user_password) {
    override fun user_type(): String {
        return "Trainer"
    }
}