package com.example.musclemapp

class Owner(
    user_id: Int,
    user_username: String,
    user_email: String,
    user_password: String,
    private var owner_establishment: Establishment
) : User(user_id, user_username, user_email, user_password) {

    fun get_owner_establishment(): Establishment {
        return owner_establishment
    }
}