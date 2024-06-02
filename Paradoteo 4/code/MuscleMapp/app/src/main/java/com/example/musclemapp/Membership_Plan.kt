package com.example.musclemapp

class Membership_Plan(
    private val membership_plan_id: Int,
    private val membership_plan_name: String,
    private val membership_plan_description: String,
    private val membership_plan_price: Float,
    private val membership_plan_day_duration: Int
) {
    fun get_membership_plan_id(): Int {
        return membership_plan_id
    }

    fun get_membership_plan_name(): String {
        return membership_plan_name
    }

    fun get_membership_plan_description(): String {
        return membership_plan_description
    }

    fun get_membership_plan_price(): Float {
        return membership_plan_price
    }

    fun get_membership_plan_day_duration(): Int {
        return membership_plan_day_duration
    }
}