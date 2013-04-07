package tomcat_jk.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class PropertyReader {
	private static Properties prop;
	private static PropertyReader propReader;
	
	public PropertyReader () {
		prop = new Properties();
	}
	
	public void loadFromXML(String filename) 
		throws FileNotFoundException, 
			   InvalidPropertiesFormatException, 
			   IOException {
		System.out.println("filename = " + filename);
		InputStream in = new FileInputStream(filename);
		prop.loadFromXML(in);
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	public String toString() {
		return prop.toString();
	}
	
}
