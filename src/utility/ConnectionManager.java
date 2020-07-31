package utility;
 
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

 public class ConnectionManager{
	 public static Properties loadPropertiesFile() throws Exception {

		 Properties prop = new Properties();
		 InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		 prop.load(in);
		 in.close();
		 return prop;
	 }
	 public static Connection getConnection()throws Exception{
		 Connection con;
		 Properties prop=null;
		 prop=loadPropertiesFile();
		 final String username=prop.getProperty("username");
		 final String password=prop.getProperty("password");
		 final String driver=prop.getProperty("driver");
		 final String url=prop.getProperty("url");
		 Class.forName(driver);
		 con=DriverManager.getConnection(url,username,password);
		 
		 return con;
	 }
	
}


