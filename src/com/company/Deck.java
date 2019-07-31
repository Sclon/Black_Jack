package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private Card[] deck;

    public Deck() {
        deck = new Card[52];
    }

    public void createDeck() {
        int counter = 0;
        for (Suits s : Suits.values()) {
            for (Rank r : Rank.values()) {
                deck[counter] = new Card(s, r);
                counter++;
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> d = new ArrayList<>(Arrays.asList(deck));
        Collections.shuffle(d);
        for (int i = 0; i < d.size(); i++) {
            deck[i] = d.get(i);
        }
    }

    public Card[] getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < deck.length; i++) {
            result += deck[i];
        }
        return result;
    }
}
