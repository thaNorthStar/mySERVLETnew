package style.paul.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
		HikariConfig config=new HikariConfig("src\\style\\paul\\properties\\application.properties");
		HikariDataSource dataSource=new HikariDataSource(config);
		return dataSource.getConnection();
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
