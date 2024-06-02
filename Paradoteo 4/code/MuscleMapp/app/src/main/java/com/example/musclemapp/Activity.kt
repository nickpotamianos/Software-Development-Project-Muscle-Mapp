package com.example.musclemapp

import java.util.Date

class Activity(
    private val activity_id: Int,
    private val activity_name: String,
    private val activity_description: String,
    private val activity_capacity: Int,
    private val activity_sessions: ArrayList<Session>
) {
    fun create_session(session_activity_id: Int, session_activity_capacity: Int, session_date: Date, session_trainer: Trainer, session_client: ArrayList<Client>, session_minute_duration: Int) {
        val new_session = Session(session_activity_id, session_activity_capacity, session_date, session_trainer, session_client, session_minute_duration)
        activity_sessions.add(new_session)
    }

    fun delete_session(activity_id: Int, session_date: Date, session_trainer: Trainer): Boolean {
        val iterator = activity_sessions.iterator()
        while (iterator.hasNext()) {
            val session = iterator.next()
            if (session.get_session_date() == session_date && session.get_session_trainer() == session_trainer) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    fun get_activity_id(): Int {
        return activity_id
    }

    fun get_activity_name(): String {
        return activity_name
    }

    fun get_activity_description(): String {
        return activity_description
    }

    fun get_activity_capacity(): Int {
        return activity_capacity
    }

    fun get_activity_sessions(): ArrayList<Session> {
        return activity_sessions
    }
}