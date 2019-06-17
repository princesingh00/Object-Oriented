package com.bridgeit.objectoriented;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgeit.utility.Utility;

public class Regular_Expression {

	public static void main(String[] args) {
		String Path = "/home/user/regex.json";
		File file = new File(Path);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(file);
//			System.out.println(""+node);
			String values = "Expression";

			JsonNode json = node.path(values);
			String strng = json.asText();
			System.out.println("" + strng);
			System.out.println("Enter the name");
			String name = Utility.getString();
			if (Pattern.matches("[a-zA-Z]+", name)) {
				strng = strng.replaceAll("<<name>>", name);
			}
			System.out.println("Enter the full name");
			String fullname = Utility.getString();
			if (Pattern.matches("[a-zA-Z]+", fullname)) {
				strng = strng.replaceAll("<<full name>>",fullname);
			} else {
				System.out.println("enter valid data");
			}
			System.out.println("Enter the phone number");
			String num = Utility.getString();
			if (Pattern.matches("[6789][0-9]{9}", num)) {
				strng = strng.replaceAll("x{10}", num);
			}
			Date current = new Date();
			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
			String date = simple.format(current);
			strng = strng.replaceAll("dd/MM/yyyy", date);
			System.out.println("" + strng);

		} catch (IOException e) {
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}
	}
}
