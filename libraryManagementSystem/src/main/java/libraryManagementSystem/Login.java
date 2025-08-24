package libraryManagementSystem;
import java.util.Scanner;
public class Login implements LoginInterface {
	int setpassword=1234567890;
	public int login() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter password : ");
		int password=scanner.nextInt();
		return password;
	}
}
