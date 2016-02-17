package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class User_entry {
	Connection con = null;
	static ResultSet rows;
    Statement stmt = null;
   int 	rowcount	=0;
   int row = 0;
   String query="";
   User_entry(){
	   try {			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yelp","root","");
			stmt = con.createStatement();
			if(!con.isClosed())
				System.out.println("Successfully Connected!!!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
   }public int countEntryRows(String userName){
	   
	   try {
    		  query = "select count(*) as count from yelp.user_entry where loginId= '" + userName +  "'";
   		System.out.println(query);
   		rows =stmt.executeQuery(query);
			 while(rows.next()){
          	row = rows.getInt("count");
           	System.out.println("user entry table row"+rowcount);	
			 }
	   }
       catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
     } return row;
   }
   public String[] displayEntryRows(String userName){ 
	   rowcount = countEntryRows(userName);
	   rowcount = 7 * rowcount;
		System.out.println("user entry table row"+rowcount);
    	 String[] result= new String[rowcount];
          	try {
			 query = "select * from yelp.user_entry where loginId= '" + userName + "'";
			System.out.println(query);
			rows =stmt.executeQuery(query);
			int i=0;
			 while(rows.next()){
				 System.out.println("printing variables:");
	            	result[i] = rows.getString("loginId");
	            	i++;
	            	result[i] = rows.getString("category");
	            	i++;
	            	result[i] = rows.getString("element");
	            	i++;
	            	result[i] = rows.getString("description");
	            	i++;
	            	result[i] = rows.getString("rating");
	            	i++;
	            	result[i] = rows.getString("review");
	            	i++; 
	            	result[i] = rows.getString("reviewId");
	            	i++; 
	            }
           	} catch (SQLException e) {
			e.printStackTrace();
          }
		return result;	    
     }
   public String[] displayReviewRows(int reviewId){ 
	  
    	 String[] result= new String[7];
          	try {
			 query = "select * from yelp.user_entry where reviewId= '" + reviewId + "'";
			System.out.println(query);
			rows =stmt.executeQuery(query);
			int i=0;
			 while(rows.next()){
				 System.out.println("printing variables:");
	            	result[i] = rows.getString("loginId");
	            	i++;
	            	result[i] = rows.getString("category");
	            	i++;
	            	result[i] = rows.getString("element");
	            	i++;
	            	result[i] = rows.getString("description");
	            	i++;
	            	result[i] = rows.getString("rating");
	            	i++;
	            	result[i] = rows.getString("review");
	            	i++; 
	            	result[i] = rows.getString("reviewId");
	            	i++; 
	            }
           	} catch (SQLException e) {
			e.printStackTrace();
          }
		return result;	
     
     }
}


