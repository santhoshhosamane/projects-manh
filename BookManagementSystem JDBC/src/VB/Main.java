package VB;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner s = new Scanner(System.in);
		int a = 1;
		while(a == 1) {
		System.out.println("JDBC BOOK MANAGEMENT SYSTEM \n");
		System.out.println("1 - Add book ");
        System.out.println("2 - View books ");
        System.out.println("3 - Remove book ");
        System.out.println("4 - Update book ");
        System.out.println("5 - Search book ");
        System.out.println("6 - Exit ");
        int f=s.nextInt();
        if (f==6) {
        	a=0;
        }
        else if( f== 1) {
        	//Add book method
        	// declared as static method
        	AddBook.ShowBooks();
        }
        else if (f== 2) {
        	//view book method 
        	// declared as static method
        	ViewBooks.ShowBooks();
        	
        }
        else if (f==3) {
        	//remove book method
        	// declared as static method
        	RemoveBook.ShowBooks();
        }
        else if (f==4) {
        	//update book method
        	// declared as static method
        	UpdateBook.ShowBooks();
        }
        else if (f==5) {
        	//Search book method
        	// declared as static method
        	System.out.println("1 - Search by ID");
        	System.out.println("2 - Search by BookName");
        	int a1=s.nextInt();
        	if (a1==1) {
        	SearchBook.ShowBooks();
        	}
        	else if(a1==2){
        	SearchBook.ShowBooksByName();
        	}
        	else {
        		System.out.println("Enter the correct number.");
        	}
        }
       
        
        else {
        	System.out.println("Enter the correct no.");
        }
        
		}
		
//		ViewBooks.ShowBooks();// declaring as static method		
//		AddBook.ShowBooks();
//		UpdateBook.ShowBooks();
//		SearchBook.ShowBooks();
//		RemoveBook.ShowBooks();
//		SearchBook.ShowBooksByName();
		
	}
	

}
