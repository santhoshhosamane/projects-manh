package VB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ViewBooks {
	static public String L1,L2,L3,L4;
	
	public ViewBooks() {}
	
	static public void ShowBooks() throws SQLException {
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","1234");
	Statement s = c.createStatement();
	try {
	ResultSet l =  s.executeQuery("SELECT * FROM BOOKS");
   
    System.out.println("ID BName AName Price\n");
    
  
    while(l.next()) {
		 System.out.println(l.getString(1)+"  "+l.getString(2) +"  "+ l.getString(3)+"    "+l.getString(4));
    	}
    System.out.println("\n");
	}
	catch(Exception exc){
        exc.printStackTrace();
    }

}
}
