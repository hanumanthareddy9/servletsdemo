package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTEST {
public static void main(String[] args) {
		readFromDB();
	
	// insertIntoDB();
}

public static void insertIntoDB() {
	try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root", "1729" );
			Statement statement = connection.createStatement();) {
		int rowsinserted= statement.executeUpdate("insert into account values(2,'mahesh','gattamaneni',15000)");
		
		System.out.println("numbr of rows inserted" + rowsinserted);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
	
	
	public static void readFromDB() {
	try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root", "1729" );
			Statement statement = connection.createStatement();) {
		
		ResultSet resultSet = statement.executeQuery("select * from account");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "," + resultSet.getString(2) + "," + resultSet.getString(3) + "," + resultSet.getInt(4));
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
}

}
