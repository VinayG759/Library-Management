package libraryManagementSystem;

import java.util.Scanner;

public class Driver {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String [] args) {
		
		System.out.println("Welcome Presidency University Library");
		System.out.println("1. Admin\n2. Student");
		int choice=scanner.nextInt();
		if(choice==1) {
			AdminLogin adminlogin=new AdminLogin();
			int password=adminlogin.login();
			if(password==adminlogin.setAdminPassword) {
				AdminImplementation adminimp=new AdminImplementation();
				while(true) {
					System.out.println("\nWelcome Admin");
					System.out.println("1. Create Book Table\n2. Add Book\n3. Remove Book\n4. Update Book\n5. List All Books\n6. Search Book\n7. Logout ");
					int adminchoice=scanner.nextInt();
					switch(adminchoice) {
					case 1:
						adminimp.createTable();
						break;
					case 2:
						adminimp.addBook();
						break;
					case 3:
						adminimp.removeBook();
						break;
					case 4:
						System.out.println("Update : \na. Book name\nb. Authur name");
						char choice1=scanner.next().charAt(0);
						switch(choice1) {
						case 'a':
							adminimp.updateBookName();
							break;
						case 'b':
							adminimp.updateAuthurName();
							break;
						}
						break;
					case 5:
						adminimp.fetchList();
						break;
					case 6:
						adminimp.fetchSingleBook();
						break;
					case 7:
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
			StudentImplementation studentimp=new StudentImplementation();
			StudentVerification studentverify=new StudentVerification();
			while(true){
				System.out.println("Hello, How may i help you?");
				System.out.println("1. View Available Books\n2. Search Book\n3. Borrow Book\n4. Return Book\n5. Logout");
				int studentchoice=scanner.nextInt();
				switch(studentchoice) {
				case 1:
					studentimp.availableBooks();
					break;
				case 2:
					studentimp.searchBook();
					break;
				case 3:
					long password=studentverify.verification();
					if(password==studentverify.setCollegePassword) {
						System.out.println("Password verified");
						studentimp.borrowBook();
					}else {
						System.out.println("Incorrect Password");
					}
					break;
				case 4:
					studentimp.returnBook();
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
