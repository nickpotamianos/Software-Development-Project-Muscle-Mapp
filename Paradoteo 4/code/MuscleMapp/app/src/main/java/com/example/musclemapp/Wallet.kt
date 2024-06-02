package com.example.musclemapp

import java.util.Date

class Wallet(
    private val wallet_cards: ArrayList<Payment_Card>
) {
    fun add_payment_card(card_number: Int, card_holder_name: String, cvv: Int, expiration_date: Date) {
        val new_card = Payment_Card(card_number, card_holder_name, cvv, expiration_date)
        wallet_cards.add(new_card)
    }

    fun delete_payment_card(card_number: Int): Boolean {
        for (card in wallet_cards) {
            if (card.get_payment_card_number() == card_number) {
                wallet_cards.remove(card)
                return true
            }
        }
        return false
    }

    fun get_wallet_cards(): ArrayList<Payment_Card> {
        return wallet_cards
    }
}