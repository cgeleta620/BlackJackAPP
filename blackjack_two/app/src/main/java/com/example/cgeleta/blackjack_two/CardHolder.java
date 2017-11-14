package com.example.cgeleta.blackjack_two;

import java.util.LinkedList;

/**
 * This class represents everything a Player will have in the blackjack game, actions and data.
 * @author Chris Geleta
 */
public class CardHolder {


    protected int handTotal; // the value of the hand
    protected int cardCount; // the count of how many cards, max 5

    protected Deck deck; // the deck

    LinkedList<Card> hand = new LinkedList<>(); // the hand of cards

    boolean blackjack = false; // blackjack?

    /**
     * This is th constructor of the Cardholder class, creates a player
     * @param c1
     * @param c2
     * @param deck
     */
    public CardHolder(Card c1, Card c2, Deck deck) {

        hand.add(c1); // adds cards to hand
        hand.add(c2);
        this.cardCount = this.hand.size(); // card count
        this.deck = deck; // the deck
        this.handTotal = this.getCardValue(c1) + this.getCardValue(c2); // value fo hand

    }

    /**
     * This method scans the players hand to see if they have a black jack, i.e. one ace and a Q,K,J
     */
    public void checkBlackJack() {

        for (int q = 0; q < this.hand.size(); q++ ) { // scans list

            if(this.hand.get(q).getType().equals("Ace")) { // finds ACE

                if (this.hand.get(q).getType().equals("King") || this.hand.get(q).getType().equals("Ace")
                        || this.hand.get(q).getType().equals("Queen")
                        || this.hand.get(q).getType().equals("Jack")) { // find other values
                    this.blackjack = true;

                }// end inner if
            }// end outer if
        }// end for

    }// end

    /**
     * This method adds the card draw to the players hand
     * @param card
     */
    public void addToHand(Card card) {

        this.hand.add(card);

        int val = getCardValue(card);
        int prev = this.handTotal;
        this.handTotal = this.handTotal + val;
        this.cardCount = this.hand.size();

        // if the player can benefit from a ACE with value of 11 the game will make it worth 11
        for (int q = 0;q < this.hand.size(); q++) {
            if(this.hand.get(q).getName().equals("Ace") && (this.handTotal - 1) + 11 <=21 ){
                this.handTotal = prev + 11;

            }
        }

    }

    public int getHandTotal() {
        return handTotal;
    }

    public void setHandTotal(int handTotal) {
        this.handTotal = handTotal;
    }

    public int getCardCount() {
        return cardCount;
    }

    public void setCardCount(int cardCount) {
        this.cardCount = cardCount;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Get the card value using the Deck and getting the values assigned
     * @param card
     * @return
     */
    public int getCardValue(Card card) {


        int val = 0;

        val = deck.getCardValue(card);

        return val;// return value

    }


}// end class
