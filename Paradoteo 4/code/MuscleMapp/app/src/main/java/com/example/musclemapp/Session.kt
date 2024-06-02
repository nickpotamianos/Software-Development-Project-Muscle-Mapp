package com.example.musclemapp

import java.util.Date

class Session(
    private val session_activity_id: Int,
    private val session_activity_capacity: Int,
    private val session_date: Date,
    private var session_trainer: Trainer,
    private val session_client: ArrayList<Client>,
    private val session_minute_duration: Int
) {
    fun add_client(client: Client): Boolean {
        if (session_client.size < session_activity_capacity) {
            session_client.add(client)
            return true
        }
        return false
    }

    fun remove_client(client_id: Int): Boolean {
        val iterator = session_client.iterator()
        while (iterator.hasNext()) {
            val client = iterator.next()
            if (client.get_user_id() == client_id) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    fun change_trainer(new_trainer: Trainer) {
        session_trainer = new_trainer
    }
    fun get_session_activity_id(): Int {
        return session_activity_id
    }

    fun get_session_activity_capacity(): Int {
        return session_activity_capacity
    }

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