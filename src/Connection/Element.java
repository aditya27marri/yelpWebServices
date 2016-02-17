package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Element {
	Connection con = null;
	static ResultSet rows;
	int timeupdate =0;
    Statement stmt = null;
   int 			rowcount=0;
   int row = 0;
   String query="";
   Element(){
	   try {			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yelp","root","");
			stmt = con.createStatement();
			if(!con.isClosed())
				System.out.println("Successfully Connected!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
public int countElement(String Category){
	   
	   try {
    		  query = "select count(*) as count from Element where Category ='"+Category+"'";
   		System.out.println(query);
   		rows =stmt.executeQuery(query);
			 while(rows.next()){
          	row = rows.getInt("count");
           	System.out.println("element table row"+row);	
			 }
	   }
       catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
     } return row;
   }
   public String[] displayElement(String Category){
	   rowcount = countElement(Category);
	   rowcount = 3 * rowcount;
		System.out.println("category table row " + rowcount);
    	 String[] result= new String[rowcount];
          	try {
			 query = "select * from Element where Category ='"+Category+"'";
			System.out.println(query);
			rows =stmt.executeQuery(query);
			int i=0;
			 while(rows.next()){
				 System.out.println("printing variables:"+i);
	            	result[i] = rows.getString("Element");
	            	i++;
	            	result[i] = rows.getString("ElementId");
	            	i++;
	            	result[i] = rows.getString("Category");
	            	i++;
	            }
           	} catch (SQLException e) {
			e.printStackTrace();
          }
		return result;	    
   }


}
