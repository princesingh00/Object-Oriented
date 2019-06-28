package com.bridgeit.objectoriented.addressBook;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class FileSystem {
	public static List<Person> personList = null;	
	public static ObjectMapper objM = new ObjectMapper();	
	
	public static void setList(List<Person> personList) 
	{
		FileSystem.personList = personList;
	}
	
	public static List<Person> getList()
	{
		return personList;
	}
	
	
	public static File createNewFile(String fileName, String fileExtension)
	{
		File file = AddressInterface.getPathOfFile(fileName, fileExtension);
		try {
			@SuppressWarnings({ "unused", "resource" })
			FileWriter newFileWritten = new FileWriter(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return file;
}
}

