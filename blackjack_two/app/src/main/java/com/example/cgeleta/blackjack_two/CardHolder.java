package com.example.cgeleta.blackjack_two;

import java.util.LinkedList;

/**
 * Created by cgeleta on 11/2/17.
 */
public class CardHolder {


    protected int handTotal;
    protected int cardCount;

    protected Deck deck;

    LinkedList<Card> hand = new LinkedList<>();

    boolean blackjack = false;

    public CardHolder(Card c1, Card c2, Deck deck) {

        hand.add(c1);
        hand.add(c2);
        this.cardCount = this.hand.size();
        this.deck = deck;
        this.handTotal = this.getCardValue(c1) + this.getCardValue(c2);

    }

    public void checkBlackJack() {

        for (int q = 0; q < this.hand.size(); q++ ) {

            if(this.hand.get(q).getType().equals("Ace")) {

                if (this.hand.get(q).getType().equals("King") || this.hand.get(q).getType().equals("Ace")
                        || this.hand.get(q).getType().equals("Queen")
                        || this.hand.get(q).getType().equals("Jack")) {
                    this.blackjack = true;

                }
            }
        }

    }

    public void addToHand(Card card) {

        this.hand.add(card);

        int val = getCardValue(card);
        int prev = this.handTotal;
        this.handTotal = this.handTotal + val;
        this.cardCount = this.hand.size();

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

    public int getCardValue(Card card) {


        int val = 0;

        val = deck.getCardValue(card);

        return val;

    }


}
