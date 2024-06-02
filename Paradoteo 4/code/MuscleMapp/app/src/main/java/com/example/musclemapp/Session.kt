package com.example.musclemapp

import java.util.Date

class Session(
    private val session_date: Date,
    private val session_trainer: Trainer,
    private val session_client: ArrayList<Client>,
    private val session_minute_duration: Int
) {
    fun get_session_date(): Date {
        return session_date
    }

    fun get_session_trainer(): Trainer {
        return session_trainer
    }

    fun get_session_client(): ArrayList<Client> {
        return session_client
    }

    fun get_session_minute_duration(): Int {
        return session_minute_duration
    }
}