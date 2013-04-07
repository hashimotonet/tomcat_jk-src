package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesTest {

	private Properties prop;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertiesTest propTest = new PropertiesTest();
		try {
			propTest.save();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void save() 
		throws IOException {
		
		OutputStream text = new FileOutputStream("test.txt");
		OutputStream xml = new FileOutputStream("test1.xml");
		
		prop = new Properties();

		
		prop.setProperty("name1", "osamu");
		prop.setProperty("name2", "ayako");
		prop.setProperty("name3", "susumu");
		prop.setProperty("name4", "akio");
		
		prop.list(System.out);
		
		prop.save(text, "hashimoto family.");
		prop.storeToXML(xml, "xml version.");
	}

}
