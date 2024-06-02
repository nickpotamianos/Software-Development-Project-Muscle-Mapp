package com.example.musclemapp

class Review(
    private val review_client_id: Int,
    private val review_content: String
) {
    fun get_review_client_id(): Int {
        return review_client_id
    }

    fun get_review_content(): String {
        return review_content
    }
}