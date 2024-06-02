package com.example.musclemapp

class Activity(
    private val activity_id: Int,
    private val activity_name: String,
    private val activity_description: String,
    private val activity_capacity: Int,
    private val activity_sessions: ArrayList<Session>
) {
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