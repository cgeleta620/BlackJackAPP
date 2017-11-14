package com.example.cgeleta.blackjack_two;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int MAX_CARD_COUNT = 5;

    private static Deck checkDeck = new Deck();

    private Deck deck;
    private Player player;
    private Dealer dealer;

    private Button hit;
    private Button stop;
    private Button reset;

    private TextView player_total;
    private TextView dealer_total;

    private TextView player_suit;
    private TextView dealer_suit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deck = new Deck();

        int r = (int) (Math.random() * deck.getDeckSize());
        Card c1 = deck.getCard(r);
        int r2 = (int) (Math.random() * deck.getDeckSize());
        Card c2 = deck.getCard(r2);

        player = new Player(c1, c2, checkDeck);

        int r3 = (int) (Math.random() * deck.getDeckSize());
        Card c3 = deck.getCard(r3);
        int r4 = (int) (Math.random() * deck.getDeckSize());
        Card c4 = deck.getCard(r4);

        dealer = new Dealer(c3, c4, checkDeck);

        player_total = (TextView) findViewById(R.id.player_total);

        player_total.setText(new StringBuffer().append("Hand value: " + player.handTotal).toString());
        dealer_total = (TextView) findViewById(R.id.dealer_total);
        dealer_total.setText(new StringBuffer().append("Hand value: " + dealer.handTotal).toString());

        player_suit = (TextView) findViewById(R.id.player_suit);
        player_suit.setText(player.hand.toString());

        dealer_suit = (TextView) findViewById(R.id.dealer_suit);
        dealer_suit.setText(dealer.hand.toString());

        if (player.blackjack) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Blackjack, congrats");
            alertDialog.setMessage("You win with blackjack");
            stop.setEnabled(false);
            hit.setEnabled(false);
            alertDialog.show();

        } else if (dealer.blackjack) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("That's unlucky");
            alertDialog.setMessage("Dealer wins with blackjack");
            stop.setEnabled(false);
            hit.setEnabled(false);
            alertDialog.show();

        }

        hit = (Button) findViewById(R.id.hit);
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int r5 = (int) (Math.random() * deck.getDeckSize());
                Card card = deck.getCard(r5);
                player.addToHand(card);
                player_total.setText(new StringBuffer().append("Hand value: " + player.handTotal).toString());
                player_suit.setText(player.hand.toString());


                if (player.handTotal > 21) {

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Where did you learn how to play?");
                    alertDialog.setMessage("Bust: You went over 21");
                    stop.setEnabled(false);
                    hit.setEnabled(false);
                    alertDialog.show();

                } else if (player.handTotal == 21) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("This must not be your first time!");
                    alertDialog.setMessage("You won");
                    stop.setEnabled(false);
                    hit.setEnabled(false);
                    alertDialog.show();

                } else if (player.cardCount >= MAX_CARD_COUNT) {
                    stop.setEnabled(false);
                    hit.setEnabled(false);

                    if (player.handTotal < dealer.handTotal) {

                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Bad news champ!");
                        alertDialog.setMessage("You Lost, dealer has higher total");
                        alertDialog.show();

                    }

                    opponentPlay();

                }
            }
        });

        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                opponentPlay();

            }
        });

    }

    public void opponentPlay() {

        while (dealer.handTotal < 21 && player.handTotal > dealer.handTotal && dealer.cardCount <= MAX_CARD_COUNT && dealer.handTotal < 18) {

            int r6 = (int) (Math.random() * deck.getDeckSize());
            Card card = deck.getCard(r6);
            dealer.addToHand(card);
            dealer_total.setText(new StringBuffer().append("Hand value: " + dealer.handTotal).toString());
            dealer_suit.setText(dealer.hand.toString());

            if (dealer.handTotal > 21) {

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Got lucky this time");
                alertDialog.setMessage("You won, dealer busted");
                stop.setEnabled(false);
                hit.setEnabled(false);
                alertDialog.show();

            } else if (dealer.handTotal == player.handTotal) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Better luck next time");
                alertDialog.setMessage("You Lost, House always wins");
                stop.setEnabled(false);
                hit.setEnabled(false);
                alertDialog.show();

            }

        }

    }

}
