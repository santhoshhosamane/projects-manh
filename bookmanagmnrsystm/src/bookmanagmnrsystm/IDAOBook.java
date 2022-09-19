package bookmanagmnrsystm;

import java.util.List;



public interface IDAOBook {
	public List<Book> displayAll();
	public void insertBook(Book b);
    public void deleteBook(int id);
    public void exit();
    public void findById(int id);
    public void updateBook(int id, int price);

}
