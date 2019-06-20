package com.bridgeit.objectoriented.Commercialdata;

import java.io.File;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgeit.utility.Utility;

public class CommercialProcessing {

	static ObjectMapper mapper = new ObjectMapper();

	public static LinkedList<CommercialPOJO> data = new LinkedList<>();
	static CommercialPOJO com = new CommercialPOJO();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	static LocalDateTime now = LocalDateTime.now();
	static String date = (dtf.format(now));

	public static void main(String args[]) throws Exception {
		int choice = 0;
		do {
			System.out.println("=======Stock Management==========");
			System.out.println("1. Add data to the stock        |");
			System.out.println("2. Remove data from the stock   |");
			System.out.println("3. display list of stock        |");
			System.out.println("4. buy Share from stock         |");
			System.out.println("5. For Exit the stock management|");
			System.out.println("________________________________|");

			choice = Utility.getInteger();
			switch (choice) {
			case 1:

				System.out.println("--->Insert Stock Details:<---");
				System.out.println("Enter company Name:");
				String name = Utility.getString();

				System.out.println("Enter symbol:");
				String number = Utility.getString();

				System.out.println("Enter Price");
				String price = Utility.getString();

				System.out.println("Enter number of Shares");
				int numofShares = Utility.getInteger();
				int totalPrice = Integer.parseInt(price) * numofShares;

				com.setCompanyName(name);
				com.setSymbol(number);
				com.setShareValue(price);
				com.setTotalShares(numofShares);
				com.setTotalPrice(totalPrice);			
				com.setDate(date);
				
				System.out.println("Total Shares Price: "+ totalPrice);
				saveFile(com);			
				System.out.println("data added successfully ");
				System.out.println();
				break;

			case 2:

				removeData();
				System.out.println("data removed successfully");
				break;

			case 3:

				displayInformation();
				break;

			case 4:
				buyShare();

				break;

			case 5:

				removeData();
				break;

			case 6:
				System.out.println("Exiting");
				break;
			default:
				System.out.println("Invalid Entry Retype");
			}

		} while (choice <= 6 && choice > 0);

	}

	private static void removeData() throws JsonMappingException, IOException, JsonGenerationException {
		try {

			data = mapper.readValue(new File("/home/user/commercial.json"),
					new TypeReference<LinkedList<CommercialPOJO>>() {
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		System.out.println("Enter Symbol");
		String symbol = Utility.getString();
		int i = 0;
		for (i = 0; i < data.size(); i++) {
			if (i == data.size()) {
				System.out.println("Invalid ");
			} else if (data.get(i).getSymbol().equals(symbol)) {
				data.remove(i);
			}
		}
		System.out.println();
		try {
			mapper.writeValue(new File("/home/user/commercial.json"), data);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static void displayInformation() throws JsonMappingException, IOException {
		// TODO Auto-generated method stub
		LinkedList<CommercialPOJO> data1 = mapper.readValue(new File("/home/user/commercial.json"),
				new TypeReference<LinkedList<CommercialPOJO>>() {
				});

		int i = 0;
		int size = data1.size();
		if (size == 0)
			System.out.println("\nno data found");
		else {
			System.out.println("Name\t\tsymbol\t\tvalue\t\tTotalShares\t\tTotalPrice");
			for (i = 0; i < data1.size(); i++) {
				System.out.println(data1.get(i).getCompanyName() + "\t\t " + data1.get(i).getSymbol() + "\t\t"
						+ data1.get(i).getShareValue() + "\t\t " + data1.get(i).getTotalShares()+ "\t\t\t " + data1.get(i).getTotalPrice());
			}
		}
		System.out.println();
	}

	public static void saveFile(CommercialPOJO com) throws JsonGenerationException, IOException, JsonParseException {

		try {
			data = mapper.readValue(new File("/home/user/commercial.json"),
					new TypeReference<LinkedList<CommercialPOJO>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		data.add(com);

		try {
			mapper.writeValue(new File("/home/user/commercial.json"), data);

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}

	public static void buyShare() throws JsonGenerationException, JsonParseException, IOException {
		try {
			data = mapper.readValue(new File("/home/user/commercial.json"),
					new TypeReference<LinkedList<CommercialPOJO>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("Which symbol you want to buy:");
		String symbol = Utility.getString();
		System.out.println("Enter share price:");
		String price1 = Utility.getString();
		System.out.println("Number of share to buy:");
		int noofShares = Utility.getInteger();
		
		int totalPrice1 = Integer.parseInt(price1) * noofShares;
		
		for(int i =0; i<data.size();i++) {
			if(i==data.size()) {
				System.out.println("No Symbol found ");
			}else if (data.get(i).getSymbol().equals(symbol)) {
				int num1 = data.get(i).getTotalShares() - noofShares;
				 data.get(i).setTotalShares(num1);
				int num2 = data.get(i).getTotalPrice() - totalPrice1;
				data.get(i).setTotalPrice(num2);
			}
		}		
		
		date = (dtf.format(now));
		com.setDate(date);

		try {
			mapper.writeValue(new File("/home/user/commercial.json"), data);

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("transaction successful...buyed");
		System.out.println();
	}

}
