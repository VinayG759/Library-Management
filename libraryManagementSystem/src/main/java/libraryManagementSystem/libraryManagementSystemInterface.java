package libraryManagementSystem;

interface AdminLoginInterface  {
	public int login();
}
interface StudentVerificationInterface {
	
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
