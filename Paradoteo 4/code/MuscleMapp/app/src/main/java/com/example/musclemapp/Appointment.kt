package com.example.musclemapp

class Appointment(
    private val appointment_client_id: Int,
    private val appointment_session: Session
) {
    fun get_appointment_client_id(): Int {
        return appointment_client_id
    }

    fun get_appointment_session(): Session {
        return appointment_session
    }
}