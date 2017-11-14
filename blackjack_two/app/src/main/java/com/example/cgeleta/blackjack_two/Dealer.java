package com.example.cgeleta.blackjack_two;

/**
 * This class is the dealer and gets it's functionality from the Cardholder class using inheritance
 */
public class Dealer extends CardHolder {

    public Dealer(Card c1, Card c2, Deck deck) {
        super(c1,c2,deck);
    } // uses super to make object

}
