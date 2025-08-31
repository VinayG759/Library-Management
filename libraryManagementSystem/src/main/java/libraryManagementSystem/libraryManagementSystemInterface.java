package libraryManagementSystem;

interface AdminLoginInterface  {
	public int login();
}
interface StudentVerificationInterface {
	public void availableBooks();
	public void searchBook();
	public void borrowBook();
	public void returnBook();
}

interface AdminInterface{
	public void createTable();
	public void addBook();
	public void removeBook();
	public void updateBookName();
	public void updateAuthurName();
	public void fetchList();
	public void fetchSingleBook();
}

interface StudentInterface{
	public void availableBooks();
	public void searchBook();
}
