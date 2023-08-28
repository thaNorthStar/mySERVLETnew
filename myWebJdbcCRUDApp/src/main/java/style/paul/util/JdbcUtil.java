package style.paul.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	private JdbcUtil() {
		
	}
	static {
		//load & register driver - 1
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
	}
	public static Connection getJdbcConnection()throws SQLException, IOException{
		String fileLoc="src\\style\\paul\\properties\\application.properties";
		HikariConfig config=new HikariConfig(fileLoc);
		HikariDataSource dataSource=new HikariDataSource(config);
		return dataSource.getConnection();
	}
	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException{
		String fileLoc="src\\style\\paul\\\\properties\\application.properties";
		FileInputStream fis=new FileInputStream(fileLoc);
		Properties properties=new Properties();
		properties.load(fis);;
		String url=properties.getProperty("jdbcUrl");
		String username=properties.getProperty("user");
		String password=properties.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
	
//	public static Connection getJdbcConnection() throws SQLException, IOException{
//		// take data from properties file
//		FileInputStream fis=new FileInputStream("src\\style\\paul\\properties\\application.properties");
//		Properties properties=new Properties();
//		properties.load(fis);
//		// establish connection - 2
//		Connection connection=DriverManager.getConnection(properties.getProperty("url"),
//				properties.getProperty("username"), properties.getProperty("password"));
//		return connection;
//	}
//	public static void cleanUp(Connection con, Statement statement, ResultSet resultSet) throws SQLException{
//		// close resource - 6
//		if(con!=null) {
//			con.close();
//		}
//		if(statement!=null) {
//			statement.close();
//		}
//		if(resultSet!=null) {
//			resultSet.close();
//		}
//	}
}
