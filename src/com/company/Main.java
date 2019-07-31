package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();

        Player player = new Player();

        Dealer dealer = new Dealer(player, deck);

        dealer.dealCards();

        System.out.println("Player has:");
        player.showPlayerCards();
        System.out.print("\n" + player.getScore() + "\n\n");

        System.out.println("Dealer has:");
        dealer.showDealerCards();
        System.out.println("\n" + dealer.getScore() + "\n");

        Scanner input = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("no")) {
            System.out.println("Want another card?");
            answer = input.nextLine();
            if (answer.equals("yes")) {
                dealer.giveCardToPlayer();
                player.showPlayerCards();
                System.out.println("\n" + player.getScore());
                if (player.getScore() > 21) {
                    System.out.println("BUST");
                    break;
                }
            }
        }
        while (dealer.getScore() < 17) {
            dealer.drawCard();
            dealer.showDealerCards();
            System.out.println("\n" + dealer.getScore());
        }

        if (dealer.getScore() > 21) {
            System.out.println("Dealer BUSTED!");
        } else if (dealer.getScore() > player.getScore()) {
            System.out.println("Dealer WINS!");
        } else if (player.getScore() > dealer.getScore()) {
            System.out.println("Player WINS!");
        } else {
            System.out.println("Dealer PUSHED!");
        }

    }
}
