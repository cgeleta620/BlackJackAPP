package com.example.cgeleta.blackjack_two;

/**
 * This class represents a Card in a deck of cards for a blackjack game
 * A card has a name, type, and value
 * @author  Chris Geleta
 * @version 1.0
 */
public class Card {

    private String type; // type of card
    private int value; // 1-11
    private String name; //name of the card

    /**
     * This is the constructor of the Card class, sets up a Card
     * @param type
     * @param name
     * @param value
     */

    public Card(String type, String name, int value) {

        this.type = type;
        this.name = name;
        this.value = value;

    }

    /**
     * Gets type of Card
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Gets value of card
     * @return int
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets name of Card
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * The Card is String form
     * @return String
     */
    public String toString() {
        return this.getName() + " of " + getType();
    }

}
