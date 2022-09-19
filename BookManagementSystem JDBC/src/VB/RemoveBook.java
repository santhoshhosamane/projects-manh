package VB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveBook {
	public static void ShowBooks() throws SQLException{

        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS", "root", "1234");

        PreparedStatement preparedStatement2 =null;

        String UpdateSQL= "delete from books where id=?";

        try{
            preparedStatement2 =conn.prepareStatement(UpdateSQL);

            Scanner scan =new Scanner(System.in);

            System.out.println("Enter Id: ");
            int A1=scan.nextInt();

            
            preparedStatement2.setInt(1, A1);
           
            preparedStatement2.executeUpdate();

            ResultSet myRs2= preparedStatement2.executeQuery("Select * from BOOKS");
            System.out.println("ID BName AName Price\n");

            while(myRs2.next() ){
                     
            System.out.println(myRs2.getString(1)+"  "+myRs2.getString(2) +"  "+myRs2.getString(3)+"    "+myRs2.getString(4));

            }
            System.out.println("\n");

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
