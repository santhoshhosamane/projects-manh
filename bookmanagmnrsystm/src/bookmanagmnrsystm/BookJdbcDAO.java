package bookmanagmnrsystm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookJdbcDAO implements IDAOBook {

	@Override
	public List<Book> displayAll() {
		// TODO Auto-generated method stub
		List<Book> books=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","Bunty1999$12");
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select * from book");
			while(r.next()) {
				books.add(new Book(r.getInt(1),r.getString(2),r.getString(3),r.getInt(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void insertBook(Book b) {
		// TODO Auto-generated method stub
		try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","Bunty1999$12");
		PreparedStatement st=con.prepareStatement("insert into book values(?,?,?,?)");
		int id=b.getId();
		String title=b.getTitle();
		String author=b.getAuthor();
		int price=b.getPrice();
		st.setInt(1,id);
		st.setString(2,title);
		st.setString(3, author);
		st.setInt(4, price);
		int row=st.executeUpdate();
		if(row==1)
			System.out.println("row added");
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","Bunty1999$12");
			PreparedStatement st=con.prepareStatement("delete from book where id=?");
			st.setInt(1,id);
			int row=st.executeUpdate();
			if(row==1)
				System.out.println("row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","Bunty1999$12");
			PreparedStatement st=con.prepareStatement("select * from book where id=?");
			st.setInt(1,id);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				System.out.println("id= "+ rs.getInt(1)+" "+"title: "+rs.getString(2)+" "+"author: "+rs.getString(3)+" "+"price: "+rs.getInt(4));
			}
			
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}

	@Override
	public void updateBook(int id, int price) {
		// TODO Auto-generated method stub
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","Bunty1999$12");
			PreparedStatement st=con.prepareStatement("update book set price=? where id=?");
			st.setInt(1,price);
			st.setInt(2, id);
			int row=st.executeUpdate();
			if(row==1)
				System.out.println("price updated");
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
}
		

