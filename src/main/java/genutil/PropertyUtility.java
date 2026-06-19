package genutil;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility {

	public String toReadDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\SauceComm.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
}
