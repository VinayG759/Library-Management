package libraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public void removeBook() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Library_DataBase";
			String user="root";
			String password="vinayg1752004@gmail.com";
			connection=DriverManager.getConnection(url, user, password);
			String query="DELETE FROM library WHERE bookid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter book id to delete : ");
			int id =scanner.nextInt();
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Book removed successfully");
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
	public void updateBookName() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Library_DataBase";
			String user="root";
			String password="vinayg1752004@gmail.com";
			connection=DriverManager.getConnection(url, user, password);
			String query="UPDATE library SET bookname=? WHERE bookid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter book ID to update book name : ");
			int id=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter new book name : ");
			String newName=scanner.nextLine();
			
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, newName);
			
			preparedStatement.executeUpdate();
			
			System.out.println("Book name updated successfully");
			
			
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
	public void updateAuthurName() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Library_DataBase";
			String user="root";
			String password="vinayg1752004@gmail.com";
			connection=DriverManager.getConnection(url, user, password);
			String query="UPDATE library SET authurname=? WHERE bookid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter book ID to update authur name : ");
			int id=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter new authur name : ");
			String newName=scanner.nextLine();
			
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, newName);
			
			preparedStatement.executeUpdate();
			
			System.out.println("Authur name updated successfully");
			
			
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
	public void fetchList() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_DataBase?user=root&password=vinayg1752004@gmail.com");
			Statement statement=connection.createStatement();
			String query="SELECT * FROM library";
			statement.execute(query);
			ResultSet resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println("\t"+resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3));
			}
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
	public void fetchSingleBook() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_DataBase?user=root&password=vinayg1752004@gmail.com");
			String query="SELECT * FROM library WHERE bookname=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter book name : ");
			String name=scanner.nextLine();
			preparedStatement.setString(1, name);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			System.out.println("\t"+resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3));
			
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
