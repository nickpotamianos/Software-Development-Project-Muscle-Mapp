package com.example.musclemapp

class Trainer(
    user_id: Int,
    user_username: String,
    user_email: String,
    user_password: String,
    private var trainer_sessions: ArrayList<Session>
) : User(user_id, user_username, user_email, user_password) {

    fun get_trainer_sessions(): ArrayList<Session> {
        return trainer_sessions
    }
}