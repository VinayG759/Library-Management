package libraryManagementSystem;
import java.util.Scanner;
class AdminLogin implements AdminLoginInterface {
	int setAdminPassword=1234567890;
	public int login() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Password : ");
		int password=scanner.nextInt();
		return password;
	}
	
}
class StudentVerification implements StudentVerificationInterface{
	long setCollegePassword=8904127547L;
	public long verification() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter College Password : ");
		long password=scanner.nextLong();
		return password;
	}
}
