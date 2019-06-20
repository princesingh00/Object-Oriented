package com.bridgeit.objectoriented.Commercialdata;

import java.io.File;

import java.io.IOException;
import java.util.LinkedList;
import java.util.StringJoiner;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgeit.datastructure.Stack;

public class StoreSymbolPurchasedInStack {
	public static void main(String args[]) throws JsonMappingException, IOException {
		String companyName;
		String symbol;
		String value;
		ObjectMapper mapper = new ObjectMapper();
		Stack<String> stack = new Stack<>();

		LinkedList<CommercialPOJO> data1 = mapper.readValue(new File(
				"/home/user/commercial.json"),
				new TypeReference<LinkedList<CommercialPOJO>>() {
				});
		int i = 0;
		int size = data1.size();
		if (size == 0)
			System.out.println("\nno data found");

		else {

			for (i = 0; i < data1.size(); i++) {
				companyName = (String) data1.get(i).getCompanyName().trim();
				symbol = data1.get(i).getSymbol().trim();
				value = data1.get(i).getShareValue();
				StringJoiner joiner = new StringJoiner(" ");
				joiner.add(companyName + "    ");
				joiner.add(symbol + "    ");
				joiner.add(value + "    ");

				stack.push(joiner.toString());
			}
		}
		System.out.println("company\t symbol\tSharelvalue\n");
		stack.show();
	}
}
