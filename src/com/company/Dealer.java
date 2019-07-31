package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Dealer {
    private ArrayList<Card> cards;
    private int score;
    private Player player;
    private Deck deck;
    private ArrayList<Card> dealerCards;

    public Dealer(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
        cards = new ArrayList<>(Arrays.asList(deck.getDeck()));
        dealerCards = new ArrayList<>();
    }

    public void dealCards() {
        player.giveCard(cards.get(0));
        cards.remove(0);
        dealerCards.add(cards.get(0));
        score += cards.get(0).getRank().getCardValue(cards.get(0).getRank());
        cards.remove(0);
        player.giveCard(cards.get(0));
        cards.remove(0);
    }

    public void giveCardToPlayer() {
        player.giveCard(cards.get(0));
        cards.remove(0);
    }

    public void drawCard() {
        dealerCards.add(cards.get(0));
        score += cards.get(0).getRank().getCardValue(cards.get(0).getRank());
        cards.remove(0);
    }

    public void showDealerCards() {
        System.out.print(dealerCards);
    }

    public int getScore() {
        return score;
    }
}
