package com.bridgeit.objectoriented;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgeit.utility.Utility;

public class Inventory_Manager {

	static int count = 0;
	static int amount = 0;

	public static void main(String[] args) {
		int ch;
		do {
			System.out.println("=================Inventary==================");
			System.out.println("1.Rice\n2.Pulses\n3.Wheat\n4.checkout");
			System.out.println("Enter the choice:");
			ch = Utility.getInteger();
			switch (ch) {
			case 1:
				calculate("Rice");
				break;
			case 2:
				calculate("Pulses");
				break;
			case 3:
				calculate("Wheat");
				break;
			case 4:
				System.out.println("Bill amount:" + amount);
				System.out.println("you like our service do come again!!! ");
				System.exit(0);
			}
		} while (ch < 5);

	}

	public static void calculate(String Stock) {

		String Path = "/home/user/inventory.json";
		File file = new File(Path);
		ObjectMapper mapper = new ObjectMapper();
		try {

			JsonNode rootNode = mapper.readTree(file);
			JsonNode inventory = rootNode.get(Stock);
			System.out.println("============ALL TYPES Inventary============");

			for (JsonNode node : inventory) {

				String Name = node.path("name").asText();
				int Price = node.path("price").asInt();

				System.out.println(++count + ")" + " Name:" + Name + "\nPrice: " + Price);
				System.out.println("Enter the Quantity");
				int quantity = Utility.getInteger();
				int rate = Price * quantity;
				System.out.println("total: " + rate + " Rs" + "\n");
				amount = amount + rate;
				System.out.println("ammount:" + amount);
				System.out.println("============================================");
			}

		} catch (IOException e) {
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}
	}

}
