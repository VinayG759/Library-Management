package libraryManagementSystem;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentImplementation implements StudentInterface{
	Scanner scanner=new Scanner(System.in);
	public void availableBooks() {
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
	public void searchBook() {
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
	public void borrowBook() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Library_DataBase";
			String user="root";
			String password="vinayg1752004@gmail.com";
			connection=DriverManager.getConnection(url, user, password);
			String query="DELETE FROM library WHERE bookname=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter book name : ");
			
			String name =scanner.nextLine();
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			System.out.println("Note : Borrowed book should be retuned within 20 days\n");
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
	public void returnBook() {
		System.out.println("Enter Book Name : ");
		String name=scanner.nextLine();
		System.out.println("Thank you\n\n");
		System.out.println("Admin PLease Re-add the returned book");
		System.out.println("Book name : "+name);
		AdminImplementation adminimp=new AdminImplementation();
		adminimp.addBook();
		
		
	}
}
