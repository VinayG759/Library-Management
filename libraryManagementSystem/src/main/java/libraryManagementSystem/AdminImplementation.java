package libraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminImplementation implements AdminInterface {
	Scanner scanner=new Scanner(System.in);
	public void createTable() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Library_DataBase";
			String user="root";
			String password="vinayg1752004@gmail.com";
			connection=DriverManager.getConnection(url, user, password);
			Statement statement=connection.createStatement();
			String query="CREATE TABLE library (bookid INT PRIMARY KEY,bookname VARCHAR(50) UNIQUE,authurname VARCHAR(50)NOT NULL)";
			statement.execute(query);
			System.out.println("Table Created Successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public  void addBook() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Library_DataBase";
			String user="root";
			String password="vinayg1752004@gmail.com";
			connection=DriverManager.getConnection(url, user, password);
			String query="INSERT INTO library VALUES (?,?,?);";
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			System.out.println("Enter Book ID : ");
			int id=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter Book Name : ");
			String name=scanner.nextLine();
			System.out.println("Enter Authur Name : ");
			String aName=scanner.nextLine();
			preparedstatement.setInt(1, id);
			preparedstatement.setString(2, name);
			preparedstatement.setString(3, aName);
			
			preparedstatement.executeUpdate();
			System.out.println("Book Added Successfully");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
