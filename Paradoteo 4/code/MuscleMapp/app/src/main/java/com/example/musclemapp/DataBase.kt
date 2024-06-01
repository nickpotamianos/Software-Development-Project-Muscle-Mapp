package com.example.musclemapp

object Database {
    val database_users: ArrayList<User> = ArrayList()
    val database_establishments: ArrayList<Establishment> = ArrayList()

    fun add_user(user: User) {
        database_users.add(user)
    }

    fun get_user_by_id(user_id: Int): User? {
        return database_users.find { it.user_id == user_id }
    }

    fun get_all_users(): List<User> {
        return database_users
    }

    fun add_establishment(establishment: Establishment) {
        database_establishments.add(establishment)
    }

    fun get_establishment_by_id(establishment_id: Int): Establishment? {
        return database_establishments.find { it.establishment_id == establishment_id }
    }

    fun get_all_establishments(): List<Establishment> {
        return database_establishments
    }

    // Add more methods as needed to manage the data
}