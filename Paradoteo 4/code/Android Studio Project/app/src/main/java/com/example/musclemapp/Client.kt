package com.example.musclemapp

class Client(
    user_id: Int,
    user_first_name: String,
    user_last_name: String,
    user_email: String,
    user_password: String,
    var client_wallet: Wallet,
    var client_appointments: ArrayList<Appointment>,
    var client_orders: ArrayList<Order>,
    var client_membership_plans: ArrayList<Membership_Plan>
) : User(user_id, user_first_name, user_last_name, user_email, user_password) {
    override fun user_type(): String {
        return "Client"
    }
}