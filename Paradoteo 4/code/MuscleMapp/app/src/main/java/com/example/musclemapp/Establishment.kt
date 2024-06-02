package com.example.musclemapp

class Establishment(
    private val establishment_id: Int,
    private val establishment_name: String,
    private val establishment_description: String,
    private val establishment_address: Address,
    private val establishment_activities: ArrayList<Activity>,
    private val establishment_products: ArrayList<Product>,
    private val establishment_membership_plans: ArrayList<Membership_Plan>,
    private val establishment_reviews: ArrayList<Review>
) {
    fun get_establishment_id(): Int {
        return establishment_id
    }

    fun get_establishment_name(): String {
        return establishment_name
    }

    fun get_establishment_description(): String {
        return establishment_description
    }

    fun get_establishment_address(): Address {
        return establishment_address
    }

    fun get_establishment_activities(): ArrayList<Activity> {
        return establishment_activities
    }

    fun get_establishment_products(): ArrayList<Product> {
        return establishment_products
    }

    fun get_establishment_membership_plans(): ArrayList<Membership_Plan> {
        return establishment_membership_plans
    }

    fun get_establishment_reviews(): ArrayList<Review> {
        return establishment_reviews
    }
}