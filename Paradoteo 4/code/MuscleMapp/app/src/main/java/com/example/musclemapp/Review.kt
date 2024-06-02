package com.example.musclemapp

class Review(
    private val review_client_id: Int,
    private var review_content: String,
    private var review_rating: Int
) {
    fun get_review_client_id(): Int {
        return review_client_id
    }

    fun get_review_content(): String {
        return review_content
    }

    fun get_review_rating(): Int {
        return review_rating
    }

    fun set_review_content(new_review_content: String) {
        review_content = new_review_content
    }

    fun set_review_rating(new_review_rating: Int) {
        review_rating = new_review_rating
    }
}