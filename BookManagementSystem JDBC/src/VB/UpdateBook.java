package VB;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateBook {

	public static void ShowBooks() throws SQLException{

        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS", "root", "1234");

        PreparedStatement preparedStatement2 =null;

        String UpdateSQL= "Update BOOKS set price = ? where ID = ?";

        try{
            preparedStatement2 =conn.prepareStatement(UpdateSQL);

            Scanner scan =new Scanner(System.in);

           

            System.out.println("Enter Id: ");
            int A1=scan.nextInt();

            System.out.println("Enter price: ");
            String A2=scan.next();

            preparedStatement2.setInt(2, A1);
            preparedStatement2.setString(1, A2);

            preparedStatement2.executeUpdate();
            System.out.println("ID BName AName Price\n");
            ResultSet myRs2= preparedStatement2.executeQuery("Select * from BOOKS");

            while(myRs2.next() ){

            	System.out.println(myRs2.getString(1)+"  "+myRs2.getString(2) +"  "+myRs2.getString(3)+"    "+myRs2.getString(4));

            }
            System.out.println("\n");
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
