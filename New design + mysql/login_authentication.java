package application;

import java.util.*;
import java.sql.*;

public class login_authentication {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("username:");
		String user = s.nextLine();
		System.out.print("Password:");
		String pass = s.nextLine();
		boolean flag = false;
		
		try {
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/javafx-project","root","root");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user_info");  
			while(rs.next()) {
				if(rs.getString(2).equals(user)) {
					if(rs.getString(3).equals(pass)) {
						flag = true;
					}
				}
			}
			con.close();  
		}
		catch(Exception e){
			System.out.println(e);
		}
		if(flag) {
			System.out.println("Correct password!!!");
		}
		else {
			System.out.println("Incorrect password???");
		}
	}
}
