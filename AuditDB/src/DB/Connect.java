package DB;

/**
 * Created by Kaligoer on 19/01/2018.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Connect {

	private String DbUser;
	private String DbPassword;

	static Properties prop = new Properties();
	static InputStream input = null;

	public Connect() {
		DbUser = "root";
		DbPassword = "1234";
	}
	public static String getUser(String filename) {

		String user = null;
		try {

			input = Connect.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return null;
			}

			//load a properties file from class path, inside static method
			prop.load(input);

			//get the property value
			user = (prop.getProperty("dbuser"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return user;
	}

	public static String getPwd(String filename) {

		String pwd = null;
		try {

			filename = "config.properties";
			input = Connect.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return null;
			}

			//load a properties file from class path, inside static method
			prop.load(input);

			//get the property value
			pwd = (prop.getProperty("dbpassword"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return pwd;
	}

	public static String getURL(String filename) {

		String url = null;
		try {

			filename = "config.properties";
			input = Connect.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return null;
			}

			//load a properties file from class path, inside static method
			prop.load(input);

			//get the property value
			url = (prop.getProperty("urlpath"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return url;
	}

	public static String getReq(String filename) {

		String req = null;
		try {

			filename = "config.properties";
			input = Connect.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return null;
			}

			//load a properties file from class path, inside static method
			prop.load(input);

			//get the property value
			req = (prop.getProperty("reqpath"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return req;
	}

	public static String getResult(String filename) {

		String res = null;
		try {

			filename = "config.properties";
			input = Connect.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return null;
			}

			//load a properties file from class path, inside static method
			prop.load(input);

			//get the property value
			res = (prop.getProperty("respath"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return res;
	}
}



