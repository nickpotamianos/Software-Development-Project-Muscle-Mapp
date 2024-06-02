package com.example.musclemapp

class Product(
    private val product_id: Int,
    private val product_name: String,
    private val product_description: String,
    private val product_price: Float,
    private val product_stock_quantity: Int,
    private val product_reviews: ArrayList<Review>
) {
    fun create_review(review_client_id: Int, review_content: String, review_rating: Int) {
        val new_review = Review(review_client_id, review_content, review_rating)
        product_reviews.add(new_review)
    }

    fun modify_review(review_client_id: Int, new_content: String, new_rating: Int): Boolean {
        for (review in product_reviews) {
            if (review.get_review_client_id() == review_client_id) {
                review.set_review_content(new_content)
                review.set_review_rating(new_rating)
                return true
            }
        }
        return false
    }

    fun delete_review(review_client_id: Int): Boolean {
        val iterator = product_reviews.iterator()
        while (iterator.hasNext()) {
            val review = iterator.next()
            if (review.get_review_client_id() == review_client_id) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    fun get_product_id(): Int {
        return product_id
    }

    fun get_product_name(): String {
        return product_name
    }

    fun get_product_description(): String {
        return product_description
    }

    fun get_product_price(): Float {
        return product_price
    }

    fun get_product_stock_quantity(): Int {
        return product_stock_quantity
    }

    fun get_product_reviews(): ArrayList<Review> {
        return product_reviews
    }
}