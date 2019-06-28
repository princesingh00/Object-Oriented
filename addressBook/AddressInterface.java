package com.bridgeit.objectoriented.addressBook;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public interface AddressInterface {
public static ObjectMapper objM = new ObjectMapper();
	
	public static File getPathOfFile(String fileName, String fileExtension)	
	{
		fileName = "/home/user/AddressBook/"
				+ fileName + fileExtension;
		
		File file = new File(fileName);
		
		return file;
	}
	
	
	public static void saveFile(File file)
	{
		List<Person> updatedList =FileSystem.getList();
		try {
			objM.writerWithDefaultPrettyPrinter().writeValue(file, updatedList);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readFile(File file)			// 
	{
		try 
		{
			FileSystem.setList(objM.readValue(file, new TypeReference<List<Person>>() {}));
		} 
		catch (IOException e) 
		{
			System.out.println("\nFile Not Found!\n");
		}
	}
}
