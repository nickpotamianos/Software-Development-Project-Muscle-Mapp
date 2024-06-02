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
    fun create_activity(activity_id: Int, activity_name: String, activity_description: String, activity_capacity: Int) {
        val new_activity = Activity(activity_id, activity_name, activity_description, activity_capacity, ArrayList())
        establishment_activities.add(new_activity)
    }

    fun delete_activity(activity_id: Int): Boolean {
        val iterator = establishment_activities.iterator()
        while (iterator.hasNext()) {
            val activity = iterator.next()
            if (activity.get_activity_id() == activity_id) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    fun create_product(product_id: Int, product_name: String, product_description: String, product_price: Float, product_stock_quantity: Int) {
        val new_product = Product(product_id, product_name, product_description, product_price, product_stock_quantity, ArrayList())
        establishment_products.add(new_product)
    }

    fun delete_product(product_id: Int): Boolean {
        val iterator = establishment_products.iterator()
        while (iterator.hasNext()) {
            val product = iterator.next()
            if (product.get_product_id() == product_id) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    fun create_membership_plan(membership_plan_id: Int, membership_plan_name: String, membership_plan_description: String, membership_plan_price: Float, membership_plan_day_duration: Int) {
        val new_membership_plan = Membership_Plan(membership_plan_id, membership_plan_name, membership_plan_description, membership_plan_price, membership_plan_day_duration)
        establishment_membership_plans.add(new_membership_plan)
    }

    fun delete_membership_plan(membership_plan_id: Int): Boolean {
        val iterator = establishment_membership_plans.iterator()
        while (iterator.hasNext()) {
            val membership_plan = iterator.next()
            if (membership_plan.get_membership_plan_id() == membership_plan_id) {
                iterator.remove()
                return true
            }
        }
        return false
    }

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