package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Util {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if (conn != null){
			return conn;
		}
		else {
			try{
				System.out.println("LOADING mysql class");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("LOADED");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhi", "root", "abhi5555");
				System.out.println("DRIVER TOO LOADED");
				return conn;
			}catch(SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}

		
//               Properties prop = new Properties();
//               InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
//               prop.load(inputStream);
//               String driver = prop.getProperty("driver");
//               String url = prop.getProperty("url");
//               String user = prop.getProperty("user");
//               String password = prop.getProperty("password");
//               Class.forName(driver);
//               connection = DriverManager.getConnection(url, user, password);
/*			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
*/

