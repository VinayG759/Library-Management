package libraryManagementSystem;

interface LoginInterface  {
	public int login();
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
	
}
