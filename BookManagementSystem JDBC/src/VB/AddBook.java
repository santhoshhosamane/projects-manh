package VB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddBook {
	static public void ShowBooks() throws SQLException {
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","1234");
//		Statement s = c.createStatement();
//		//ResultSet l =  s.executeQuery("SELECT * FROM BOOKS");
//		String sql = "insert into BOOKS values(?,?,?,?)";
//		
//		PreparedStatement P = c.prepareStatement(sql);
//		 String A1 = "YSBI";
//		 String A2 ="DD";
//		 int A3 = 123;
//		 int A4 = 9;
//
//		 P.setString(2, A1);//BookName
//		 P.setString(3,A2 );//AuthName
//		 P.setInt(4,A3 );//price
//		 P.setInt(1, A4);//ID
//		 int r = P.executeUpdate();
//	    
//		 System.out.println("ID BName AName Price\n");
//		 if (r==1) {
//			 System.out.println("updated");
//	 }
//	  
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS", "root", "1234");

        PreparedStatement preparedStatement2 =null;

        String UpdateSQL= "insert into BOOKS values(?,?,?,?)";
        
        try{
            preparedStatement2 =conn.prepareStatement(UpdateSQL);

            Scanner scan =new Scanner(System.in);
//            System.out.println("Enter Id: ");
//            int A1=scan.nextInt();
//            System.out.println("Enter BookName: ");
//            String A2=scan.nextLine();
//            
//            System.out.println("Enter AuthName: ");
//            String A3=scan.nextLine();
//            System.out.println("Enter Price: ");
//            int A4=scan.nextInt(); 
            // ERROR ITS NOT TAKING INPUT FOR BOOK NAME AND SKIPPING TO AUTHNAME
            System.out.println("Enter BookName: ");
            String A2=scan.nextLine();
            
            System.out.println("Enter AuthName: ");
            String A3=scan.nextLine();
            
            System.out.println("Enter Id: ");
            int A1=scan.nextInt();
           
            System.out.println("Enter Price: ");
            int A4=scan.nextInt();
         

            preparedStatement2.setInt(1, A1);
            preparedStatement2.setString(2, A2);
            preparedStatement2.setString(3, A3);
            preparedStatement2.setInt(4,A4);

           int a= preparedStatement2.executeUpdate();
           if (a==1) {
        	   System.out.println("BOOK ADDED ");
           }
           System.out.println("\n");
//            System.out.println("ID BName AName Price\n");
//            ResultSet myRs2= preparedStatement2.executeQuery("Select * from BOOKS");
//
//            while(myRs2.next() ){
//                   
//            	System.out.println(myRs2.getString(1)+"  "+myRs2.getString(2) +"  "+myRs2.getString(3)+"    "+myRs2.getString(4));
//
//            }
//            System.out.println("\n");
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
	
	}
