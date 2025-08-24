package libraryManagementSystem;

import java.util.Scanner;

public class Driver {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String [] args) {
		
		System.out.println("Welcome Presidency University Library");
		System.out.println("1. Admin\n2. Student");
		int choice=scanner.nextInt();
		if(choice==1) {
			Login login=new Login();
			int password=login.login();
			if(password==login.setpassword) {
				System.out.println("Welcome Admin");
				while(true) {
					System.out.println("1. Add Book\n2. Remove Book\n3. Update Book\n4. List All Books\n5. Search Book\n6. Logout ");
					int adminchoice=scanner.nextInt();
					switch(adminchoice) {
					case 1:
						//Addbook
						break;
					case 2:
						//removebook
						break;
					case 3:
						//updatebook
						break;
					case 4:
						//List
						break;
					case 5:
						//search
						break;
					case 6:
						System.out.println("Thank You");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				
			}else {
				System.out.println("Incorrect Password");
			}
			
		}
		else if(choice==2) {
			System.out.println("Hello, How may i help you?");
			while(true){
				System.out.println("1.View Available Books\n2. Search Book\n3. Borrow Book\n4. Return Book\n5. Logout");
				int studentchoice=scanner.nextInt();
				switch(studentchoice) {
				case 1:
					//View Available Books
					break;
				case 2:
					//Search Book
					break;
				case 3:
					//Borrow Book
					break;
				case 4:
					//Return Book
					break;
				case 5:
					System.out.println("Thank You");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
				}
			}
		}
		else {
			System.out.println("Invalid Choice");
		}
		
	}
}
