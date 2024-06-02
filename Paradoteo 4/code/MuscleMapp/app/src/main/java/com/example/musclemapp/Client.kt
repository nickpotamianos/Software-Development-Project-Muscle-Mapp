package com.example.musclemapp

import java.util.Date

class Client(
    user_id: Int,
    user_username: String,
    user_email: String,
    user_password: String,
    private var client_wallet: Wallet,
    private var client_appointments: ArrayList<Appointment>,
    private var client_orders: ArrayList<Order>,
    private var client_membership_plans: ArrayList<Membership_Plan>
) : User(user_id, user_username, user_email, user_password) {

    fun create_order(
        order_id: Int,
        order_establishment_id: Int,
        order_client_id: Int,
        order_date: Date,
        order_status: String,
        order_estimated_delivery_date: Date,
        order_payment_card_id: Int,
        order_contents: ArrayList<Product>
    ) {
        val new_order = Order(order_id, order_establishment_id, order_client_id, order_date, order_status, order_estimated_delivery_date, order_payment_card_id, order_contents)
        client_orders.add(new_order)
    }

    fun cancel_order(order_id: Int): Boolean {
        val iterator = client_orders.iterator()
        while (iterator.hasNext()) {
            val order = iterator.next()
            if (order.get_order_id() == order_id) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    fun create_appointment(
        appointment_id: Int,
        appointment_client_id: Int,
        appointment_session: Session,
        appointment_date_time: Date
    ) {
        val new_appointment = Appointment(appointment_client_id, appointment_session)
        client_appointments.add(new_appointment)
    }

    fun add_membership_plan(membership_plan: Membership_Plan) {
        client_membership_plans.add(membership_plan)
    }

    fun change_membership_plan(current_plan: Membership_Plan, new_plan: Membership_Plan): Boolean {
        val index = client_membership_plans.indexOf(current_plan)
        return if (index != -1) {
            client_membership_plans[index] = new_plan
            true
        } else {
            false
        }
    }

    fun cancel_membership_plan(membership_plan: Membership_Plan): Boolean {
        return client_membership_plans.remove(membership_plan)
    }

    fun cancel_appointment(appointment: Appointment): Boolean {
        return client_appointments.remove(appointment)
    }

    fun get_client_wallet(): Wallet {
        return client_wallet
    }

    fun get_client_appointments(): ArrayList<Appointment> {
        return client_appointments
    }

    fun get_client_orders(): ArrayList<Order> {
        return client_orders
    }

    fun get_client_membership_plans(): ArrayList<Membership_Plan> {
        return client_membership_plans
    }
}