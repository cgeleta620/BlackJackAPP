package com.example.cgeleta.blackjack_two;

/**
 * Created by cgeleta on 11/2/17.
 */
public class Card {

    private String type;
    private int value;
    private String name;

    public Card(String type, String name, int value) {

        this.type = type;
        this.name = name;
        this.value = value;

    }

    public String getType() {
        return type;
    }


    public int getValue() {
        return value;
    }


    public String getName() {
        return name;
    }

    public String toString() {
        return this.getName() + " of " + getType();
    }

}
