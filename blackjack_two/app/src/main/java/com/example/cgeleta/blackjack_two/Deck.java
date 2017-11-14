package com.example.cgeleta.blackjack_two;

import java.util.LinkedList;

/**
 * This class represents a Deck fo 52 cards for a blackjack game
 * @author cgeleta
 */
public class Deck {

    LinkedList<Card> deckList = new LinkedList<>(); // the list of cards

    protected int deckSize; // size of deck

    /**
     * This is the constructor of the Deck, creates the deck and populates 52 cards in the decklist
     */
    public Deck() {

        Card hTwo = new Card("Hearts", "Two", 2);
        deckList.add(hTwo);
        Card sTwo = new Card("Spades", "Two", 2);
        deckList.add(sTwo);
        Card dtwo = new Card("Diamonds", "Two", 2);
        deckList.add(dtwo);
        Card jtwo = new Card("Jacks", "Two", 2);
        deckList.add(jtwo);


        Card hThree = new Card("Hearts", "Three", 3);
        deckList.add(hThree);
        Card sThree = new Card("Spades", "Three", 3);
        deckList.add(sThree);
        Card dThree = new Card("Diamonds", "Three", 3);
        deckList.add(dThree);
        Card jThree = new Card("Jacks", "Three", 3);
        deckList.add(jThree);


        Card hFour = new Card("Hearts", "Four", 4);
        deckList.add(hFour);
        Card sFour = new Card("Spades", "Four", 4);
        deckList.add(sFour);
        Card dFour = new Card("Diamonds", "Four", 4);
        deckList.add(dFour);
        Card jFour = new Card("Jacks", "Four", 4);
        deckList.add(jFour);

        Card hFive = new Card("Hearts", "Five", 5);
        deckList.add(hFive);
        Card sFive = new Card("Spades", "Five", 5);
        deckList.add(sFive);
        Card dFive = new Card("Diamonds", "Five", 5);
        deckList.add(dFive);
        Card jFive = new Card("Jacks", "Five", 5);
        deckList.add(jFive);

        Card hSix = new Card("Hearts", "Six", 6);
        deckList.add(hSix);
        Card sSix = new Card("Spades", "Six", 6);
        deckList.add(sSix);
        Card dSix = new Card("Diamonds", "Six", 6);
        deckList.add(dSix);
        Card jSix = new Card("Jacks", "Six", 6);
        deckList.add(jSix);


        Card hSev = new Card("Hearts", "Seven", 7);
        deckList.add(hSev);
        Card sSev = new Card("Spades", "Seven", 7);
        deckList.add(sSev);
        Card dSev = new Card("Diamonds", "Seven", 7);
        deckList.add(dSev);
        Card jSev = new Card("Jacks", "Seven", 7);
        deckList.add(jSev);


        Card hEight = new Card("Hearts", "Eight", 8);
        deckList.add(hEight);
        Card sEight = new Card("Spades", "Eight", 8);
        deckList.add(sEight);
        Card dEight = new Card("Diamonds", "Eight", 8);
        deckList.add(dEight);
        Card jEight = new Card("Jacks", "Eight", 8);
        deckList.add(jEight);

        Card hNine = new Card("Hearts", "Nine", 9);
        deckList.add(hNine);
        Card sNine = new Card("Spades", "Nine", 9);
        deckList.add(sNine);
        Card dNine = new Card("Diamonds", "Nine", 9);
        deckList.add(dNine);
        Card jNine = new Card("Jacks", "Nine", 9);
        deckList.add(jNine);

        Card hTen = new Card("Hearts", "Ten", 10);
        deckList.add(hTen);
        Card sTen = new Card("Spades", "Ten", 10);
        deckList.add(sTen);
        Card dTen = new Card("Diamonds", "Ten", 10);
        deckList.add(dTen);
        Card jTen = new Card("Jacks", "Ten", 10);
        deckList.add(jTen);

        Card hJack = new Card("Hearts", "Jack", 10);
        deckList.add(hJack);
        Card sJack = new Card("Spades", "Jack", 10);
        deckList.add(sJack);
        Card dJack = new Card("Diamonds", "Jack", 10);
        deckList.add(dJack);
        Card jJack = new Card("Jacks", "Jack", 10);
        deckList.add(jJack);

        Card hQueen = new Card("Hearts", "Queen", 10);
        deckList.add(hQueen);
        Card sQueen = new Card("Spades", "Queen", 10);
        deckList.add(sQueen);
        Card dQueen = new Card("Diamonds", "Queen", 10);
        deckList.add(dQueen);
        Card jQueen = new Card("Jacks", "Queen", 10);
        deckList.add(jQueen);

        Card hKing = new Card("Hearts", "King", 10);
        deckList.add(hKing);
        Card sKing = new Card("Spades", "King", 10);
        deckList.add(sKing);
        Card dKing = new Card("Diamonds", "King", 10);
        deckList.add(dKing);
        Card jKing = new Card("Jacks", "King", 10);
        deckList.add(jKing);


        Card hAce = new Card("Hearts", "Ace", 1);
        deckList.add(hAce);
        Card sAce = new Card("Spades", "Ace", 1);
        deckList.add(sAce);
        Card dAce = new Card("Diamonds", "Ace", 1);
        deckList.add(dAce);
        Card jAce = new Card("Jacks", "Ace", 1);
        deckList.add(jAce);

        this.deckSize = deckList.size();


    }

    /**
     * Displays the deck as a String
     * @return
     */
    public String toString() {

        String deck = "";

        for (int q = 0; q < deckList.size(); q++) {
            deck += deckList.get(q) + "\n";
          //  System.out.println(deck);
        }

        return deck;
    }

    /**
     * This is used to take a card from the deck and update the size of the deck.
     * @param card
     */
    public void remove(Card card) {

        for (int q = 0; q < deckList.size(); q++) {

            if(card.getType().compareTo(deckList.get(q).getType()) == 0 &&
                    card.getName().compareTo(deckList.get(q).getName()) == 0) {

                this.deckList.remove(q);

            }
        }

    }

    /**
     * Gets a random card from the deck
     * @param seed
     * @return
     */
    public Card getCard(int seed) {

        Card c = deckList.get(seed);
        deckList.remove(seed);
        this.deckSize = deckList.size();
        return c;


    }


    /**
     * The size of the deck
     * @return
     */
    public int getDeckSize() {
        return deckList.size();
    }


    /**
     * Gets the value of the card from the value set
     * @param card
     * @return
     */
    public int getCardValue(Card card) {
        int cardVal = -1000; // random value for holding int.

        for (int q = 0; q < deckList.size(); q++) { // scans through deck list

            if(card.getType().compareTo(deckList.get(q).getType()) == 0 &&
                    card.getName().compareTo(deckList.get(q).getName()) == 0) { // finds card

                cardVal = card.getValue(); // gets value

            }
        }
        return cardVal; // returns value

    }


}// end class