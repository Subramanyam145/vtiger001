package CHAPTER_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
import com.mysql.jdbc.Driver;

public class ModifiedDatabase {

	public static void main(String[] args) throws SQLException {
		//Step 1: Create an instance of JDBC Driver
		Driver dbDriver = new Driver();
		
		//Step 2: Register Driver
		DriverManager.registerDriver(dbDriver);
		
		//Step 3: Establish database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
		
		//Step 4: Create Statement 
		java.sql.Statement statement = connection.createStatement();
		
		//Step 5: Execute query to update database
		int result = statement.executeUpdate("insert into employees(id, name, salary, phone)"+ "values(105, 'EPG', 50000, '9182884797');");
		
		if(result == 1)
			System.out.println("Database is updated successfully");
		else
			System.out.println("Database modification is failed");
			
		//Step 6: close da
		connection.close();
			
		}

	}


