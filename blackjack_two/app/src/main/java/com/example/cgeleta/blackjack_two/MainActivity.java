package com.example.cgeleta.blackjack_two;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This is the main activity, this class represents the main screen of the app, all the buttons/textviews and acts
 * as the main method for performing the blackjack game play
 *
 * @author Chris Geleta
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    private int MAX_CARD_COUNT= 5; // max number of cards a user can have

    private static Deck checkDeck = new Deck(); // replica deck to get card values from

    private Deck deck; // deck of 52 cards that players get cards from
    private Player player;// YOU
    private Dealer dealer;// Opponent

    private Button hit; // draw a card button
    private Button stop; // let the opponent go button
    private Button reset; // start over button

    private TextView player_total; // displays hand value
    private TextView dealer_total; // displays hand value

    private TextView player_suit; // diplays hand i.e. what cards you have
    private TextView dealer_suit;// same as above

    /**
     * This method is created when the activity is made, handles all the actions for the buttons (hit, stop, rest)
     * This method also sets up the Deck, and draws two cards for each player and check for blackjack
     *
     * @param savedInstanceState - Bundle
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deck = new Deck(); // the main deck used

        int r = (int) (Math.random() * deck.getDeckSize()); // gets a card between 0-deck_count
        Card c1 = deck.getCard(r); // gets card
        int r2 = (int) (Math.random() * deck.getDeckSize()); //
        Card c2 = deck.getCard(r2);// gets second card

        player = new Player(c1, c2, checkDeck); // creates YOU!

        int r3 = (int) (Math.random() * deck.getDeckSize());
        Card c3 = deck.getCard(r3);
        int r4 = (int) (Math.random() * deck.getDeckSize());
        Card c4 = deck.getCard(r4);

        dealer = new Dealer(c3, c4, checkDeck); // created Dealer

        player_total = (TextView) findViewById(R.id.player_total); // sets up textview for player hand value

        player_total.setText(new StringBuffer().append("Hand value: " + player.handTotal).toString()); // sets text
        dealer_total = (TextView) findViewById(R.id.dealer_total);// dealer's hand textview
        dealer_total.setText(new StringBuffer().append("Hand value: " + dealer.handTotal).toString());// sets text

        player_suit = (TextView) findViewById(R.id.player_suit);// the hand of the player
        player_suit.setText(player.hand.toString());// set the text of the hand

        dealer_suit = (TextView) findViewById(R.id.dealer_suit); // dealers hand
        dealer_suit.setText(dealer.hand.toString()); // dealer's cards

        if (player.blackjack) { // check if you have blackjack
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create(); // creates box
            alertDialog.setTitle("Blackjack, congrats");
            alertDialog.setMessage("You win with blackjack");
            stop.setEnabled(false);// turn off buttons
            hit.setEnabled(false);
            alertDialog.show(); // shows alert

        } else if (dealer.blackjack) { // checks dealer blackjack
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create(); // creates box
            alertDialog.setTitle("That's unlucky");
            alertDialog.setMessage("Dealer wins with blackjack");
            stop.setEnabled(false);// turns off buttons
            hit.setEnabled(false);
            alertDialog.show();// shows alert

        }

        hit = (Button) findViewById(R.id.hit);// hit button
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // when clicked you get a card

                int r5 = (int) (Math.random() * deck.getDeckSize());
                Card card = deck.getCard(r5);// get another card
                player.addToHand(card);// adds to hand
                player_total.setText(new StringBuffer().append("Hand value: " + player.handTotal).toString());// updates value
                player_suit.setText(player.hand.toString());// displays value


                if (player.handTotal > 21) { // if you lost

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Where did you learn how to play?");
                    alertDialog.setMessage("Bust: You went over 21");
                    stop.setEnabled(false);
                    hit.setEnabled(false);
                    alertDialog.show();

                } else if (player.handTotal == 21) {// if you won
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("This must not be your first time!");
                    alertDialog.setMessage("You won");
                    stop.setEnabled(false);
                    hit.setEnabled(false);
                    alertDialog.show();// show you won

                } else if (player.cardCount >= MAX_CARD_COUNT) { // if you went past max card count (5)
                    stop.setEnabled(false);
                    hit.setEnabled(false);// turn off buttons

                    if (player.handTotal < dealer.handTotal) {// if you lost based off value

                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Bad news champ!");
                        alertDialog.setMessage("You Lost, dealer has higher total");
                        alertDialog.show();// show you lost

                    }

                    opponentPlay(); // the dealer plays because you're finished playing

                }
            }
        });

        reset = (Button) findViewById(R.id.reset);// reset button set up
        reset.setOnClickListener(new View.OnClickListener() { // when you click reset button
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();// get intent
                finish();
                startActivity(intent);// restarts activity
            }
        });

        stop = (Button) findViewById(R.id.stop); // sets up stop button
        stop.setOnClickListener(new View.OnClickListener() {// when stop button is clicked
            @Override
            public void onClick(View v) {

                opponentPlay(); // dealer plays

            }
        });

    }// end onCreate()

    /**
     * This method is the dealer playing the game against you. Dealer will draw a card if it's hand value is less than 21 and less than 18
     * as well as losing and finally it has hte option to (i.e. doesn't exceed past max_card_count.)
     */

    public void opponentPlay() {

        while (dealer.handTotal < 21 && player.handTotal > dealer.handTotal && dealer.cardCount <= MAX_CARD_COUNT && dealer.handTotal < 18) {

            int r6 = (int) (Math.random() * deck.getDeckSize()); // random number between (0 - max from List)
            Card card = deck.getCard(r6);// gets a card
            dealer.addToHand(card);
            dealer_total.setText(new StringBuffer().append("Hand value: " + dealer.handTotal).toString());// update value
            dealer_suit.setText(dealer.hand.toString());// update cards

            if (dealer.handTotal > 21) { // when dealer lost

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Got lucky this time");
                alertDialog.setMessage("You won, dealer busted");
                stop.setEnabled(false);// turn off buttons
                hit.setEnabled(false);
                alertDialog.show(); // shows dealer lost due to bust

            } else if (dealer.handTotal == player.handTotal) { // when there is a tie the house always wins
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Better luck next time");
                alertDialog.setMessage("You Lost, House always wins");
                stop.setEnabled(false);// turn off buttons
                hit.setEnabled(false);
                alertDialog.show();// shows dealer won

            }// end else if

        }//end while

    }// end dealer play

}// end mainactiviy
