package com.bridgeit.objectoriented;

import com.bridgeit.datastructure.Queue;

public class DeckofCards_LinkedList extends DeckofCard {
	public static void main(String[] args) {
		DeckofCard deck = new DeckofCards_LinkedList();

		deck.getCards();
		deck.shuffle();
		String player[][] = deck.distribute(4, 9);
		int i = 1;
		for (String[] card : player) {

			System.out.println("player_" + (i++) + " cards : ");
			System.out.println();
			for (String str : card) {
				Queue<String> queue = new Queue<>();
				queue.enqueue(str);
				queue.print();
			}
			System.out.println();
			System.out.println();
		}
	}
}
