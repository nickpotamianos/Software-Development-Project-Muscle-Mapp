package com.example.musclemapp

class Wallet(
    private val wallet_cards: ArrayList<Payment_Card>
) {
    fun get_wallet_cards(): ArrayList<Payment_Card> {
        return wallet_cards
    }
}