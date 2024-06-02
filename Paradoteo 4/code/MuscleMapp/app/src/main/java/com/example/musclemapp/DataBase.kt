package com.example.musclemapp

object Database {
    val database_users: ArrayList<User> = ArrayList()
    var database_user_count: Int = 0
    var database_active_user: User? = null

    val database_establishments: ArrayList<Establishment> = ArrayList()

    init {
        database_users.add(Client(1, "john_doe", "john.doe@example.com", "password123", Wallet(ArrayList()), ArrayList(), ArrayList(), ArrayList()))
        database_users.add(Client(2, "jane_smith", "jane.smith@example.com", "password456", Wallet(ArrayList()), ArrayList(), ArrayList(), ArrayList()))
        database_users.add(Client(3, "alice_johnson", "alice.johnson@example.com", "password789", Wallet(ArrayList()), ArrayList(), ArrayList(), ArrayList()))
        database_users.add(Client(4, "bob_brown", "bob.brown@example.com", "password101", Wallet(ArrayList()), ArrayList(), ArrayList(), ArrayList()))
        database_users.add(Client(5, "eve_white", "eve.white@example.com", "password202", Wallet(ArrayList()), ArrayList(), ArrayList(), ArrayList()))

        database_user_count = 5;
    }

    fun print_all_users() {
        for (user in Database.database_users) {
            println("User ID: ${user.user_id}, Username: ${user.user_username}")
        }
    }

    fun register_user(new_username: String, new_email: String, new_password: String): Boolean {
        for (user in Database.database_users) {
            if (user.user_username == new_username || user.user_email == new_email) {
                return false
            }
        }

        Database.database_user_count += 1

        val new_user = Client(Database.database_user_count, new_username, new_email, new_password, Wallet(ArrayList()), ArrayList(), ArrayList(), ArrayList())
        database_users.add(new_user)
        database_active_user = new_user

        return true
    }

    fun login_user(email: String, password: String): Boolean {
        for (user in Database.database_users) {
            if (user.user_email == email) {
                if (user.user_password == password) {
                    Database.database_active_user = user
                    return true
                } else {
                    return false
                }
            }
        }

        return false
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