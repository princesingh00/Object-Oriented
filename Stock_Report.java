package com.bridgeit.objectoriented;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.bridgeit.utility.Utility;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Stock_Report {

	private List<Stock_Program> stock;
	private List<TotalStock> stock1;

	public List<TotalStock> getStock1() {
		return stock1;
	}

	public void setStock1(List<TotalStock> stock1) {
		this.stock1 = stock1;
	}

	public List<Stock_Program> getStocks() {
		return stock;
	}

	public void setStocks(List<Stock_Program> stock) {
		this.stock = stock;
	}

	public static void main(String[] args) {

		System.out.print("Enter number of Users to Store : ");
		int num = Utility.getInteger();
		int totalStock = 0;
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		try {

			List<Stock_Program> stocks = new ArrayList<>();

			for (int i = 0; i < num; i++) {

				System.out.print("Enter the name of user : ");
				String name = Utility.getString();
				System.out.print("Enter the name of Company : ");
				String company = Utility.getString();
				System.out.print("Enter the symbol of Company : ");
				String symbol = Utility.getString();
				System.out.print("Enter the number of shares : ");
				int shares = Utility.getInteger();
				System.out.print("Enter the price of share : ");
				int price = Utility.getInteger();
				int total = shares * price;
				totalStock = totalStock + total;
				System.out.print("total price of share : " + total);
				System.out.println();
				System.out.println("Done");
				System.out.println();

				Stock_Program stock = new Stock_Program();
				stock.setName(name);
				stock.setCompany(company);
				stock.setSymbol(symbol);
				stock.setShares(shares);
				stock.setPrice(price);
				stock.setTotal(total);
				stocks.add(stock);
			}
			List<TotalStock> stock1 = new ArrayList<>();
			TotalStock stock11 = new TotalStock();
			stock11.setTotalStock(totalStock);
			stock1.add(stock11);

			writer.writeValue(new File("/home/user/stock.json"), stocks);
			Stock_Report report = new Stock_Report();
			report.setStocks(stocks);
			for (Stock_Program st : report.getStocks()) {
				System.out.println("User Name:" + st.getName() + "\ncompany Name:" + st.getCompany()
				+ "\nCompany Symbol:" + st.getSymbol() + "\nShares:" + st.getShares() + "\nPrice:"
				+ st.getPrice() + "\nTotal:" + st.getTotal() + "\n");
			}
			System.out.println("TotalStock : " + totalStock);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}
	}

}
