package com.bridgeit.objectoriented;

import java.util.Random;

public class DeckofCard {

	String[] Ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	String[] suits = { "Club", "Diamond", "Heart", "Spade" };

	public String cards[] = new String[52];

	public String[] getCards() {
		int i = 0;
		for (String suit : suits) {
			for (String rank : Ranks) {
				cards[i] = suit + ":" + rank;
				i++;
			}
		}
		return cards;
	}

	public void shuffle() {

		Random rand = new Random();
		for (int i = 0; i < cards.length; i++) {
			int index = rand.nextInt(52);
			String temp = cards[index];
			cards[index] = cards[i];
			cards[i] = temp;
		}

	}

	public String[][] distribute(int numOfPlayers, int numOfCards) {
		String player[][] = new String[numOfPlayers][numOfCards];
		int k = 0;
		for (int i = 0; i < numOfPlayers; i++) {
			for (int j = 0; j < numOfCards; j++) {
				player[i][j] = cards[k];
				k++;
			}
		}
		return player;
	}

	public void display(String[][] player) {
		int i = 1;
		for (String[] card : player) {

			System.out.print("player_" + (i++) + " cards - ");
			for (String str : card) {
				System.out.print(str + " ");
			}
			System.out.println();
			System.out.println();
		}
	}

	public static void main(String[] args) {
		DeckofCard deck = new DeckofCard();
		deck.getCards();
		deck.shuffle();
		String player[][] = deck.distribute(4, 9);
		deck.display(player);
	}
}
