package DB; /**
 * Created by Kaligoer on 29/09/2017.
 */
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.Date;


import static DB.FileRead.getFileRead;

public class Request {
	// JDBC driver and DB url
	static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	static final String DB_URL= Connect.getURL("config.properties");

	// Host log
	static final String HostUser="username";
	static final String HostPass="password";

	// Database log

	static final String DbUser= Connect.getUser("config.properties");
	static final String DbPass= Connect.getPwd("config.properties");
	static final String ReqPath= Connect.getReq("config.properties");

	//Result File
	static final String Result= Connect.getResult("config.properties");


	public static void main(String[] args) throws ClassNotFoundException, SQLException,FileNotFoundException{
		Connection conn=null;
		Statement stmt=null;
		File f = new File(ReqPath);

        try{

			File[] files = f.getAbsoluteFile().listFiles();
			for (int j=0; j<files.length;j++) {

				File tmp = files[j];
				System.out.println("File path: " + tmp.toString());

				// Register DB
				Class.forName("com.mysql.jdbc.Driver");

				// Open a connection
				System.out.println("Connecting to DB");
				conn = DriverManager.getConnection(DB_URL, DbUser, DbPass);

				// Execute a query
				System.out.println("Creating Statement");
				stmt = conn.createStatement();

				//Read File
				System.out.println("SQL Reading");

				String sql = getFileRead(tmp);
				System.out.println("SQL Request");
				System.out.println(sql);

				// Extract data from result set

				ResultSet rs = stmt.executeQuery(sql);
				ResultSetMetaData meta = rs.getMetaData();

				String fileName = new SimpleDateFormat("yyyy_MM_dd'.csv'").format(new Date());
				PrintWriter csvWriter = new PrintWriter(new File(Result + j + "_" + fileName));

				int numberOfColumns = meta.getColumnCount();
				String dataHeaders = "\"" + meta.getColumnName(1) + "\"";
				for (int i = 2; i < numberOfColumns + 1; i++) {
					dataHeaders += ",\"" + meta.getColumnName(i).replaceAll("\"", "\\\"") + "\"";
				}
				csvWriter.println(fileName);
				csvWriter.println(dataHeaders);

				while (rs.next()) {
					String row = "\"" + rs.getString(1).replaceAll("\"", "\\\"") + "\"";
					for (int i = 2; i < numberOfColumns + 1; i++) {
						row += ",\"" + rs.getString(i).replaceAll("\"", "\\\"") + "\"";
					}
					csvWriter.println(row);
				}
				csvWriter.close();

				rs.close();
				System.out.println("Fermeture ResultSet OK");
				stmt.close();
				System.out.println("Fermeture Statement OK");
				conn.close();
				System.out.println("Fermeture Connection OK");


			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
