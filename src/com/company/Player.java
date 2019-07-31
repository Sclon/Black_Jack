package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> playerCards;
    private int score;

    public Player() {
        playerCards = new ArrayList<>();
    }

    public void giveCard(Card card) {
        playerCards.add(new Card(card.getSuit(), card.getRank()));
        score += card.getRank().getCardValue(card.getRank());
    }

    public int getScore() {
        return score;
    }

    public void showPlayerCards() {
        System.out.print(playerCards);
    }
}
