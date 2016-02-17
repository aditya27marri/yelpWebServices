package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class User_info {
	Connection con = null;
	static ResultSet rows;
	int timeupdate =0;
    Statement stmt = null;
   int 			rowcount=0;
   User_info(){
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
   public String[] displayUserRows(String userName){
		System.out.println("user info table");
     	String[] result= new String[5];
		try {
			String query = "select loginId,firstname,lastname,emailid,logintime from yelp.user_info where loginId= '" + userName + "'";
			System.out.println(query);
			rows =stmt.executeQuery(query);
			int i=0;
			 while(rows.next()){
	            	result[i] = rows.getString("loginId");
	            	i++;
	            	result[i] = rows.getString("firstname");
	            	i++;
	            	result[i] = rows.getString("lastname");
	            	i++;
	            	result[i] = rows.getString("emailid");
	            	i++;
	            	result[i] = rows.getTime("logintime").toString();
	            	i++;           	
		          }
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
          }
		
		return result;	
   }
   public String getTime(String userName){
		System.out.println("user info table");
    	String result= new String();
		try {
			String query = "select logintime from yelp.user_info where loginId= '" + userName + "'";
			System.out.println(query);
			rows =stmt.executeQuery(query);
			 while(rows.next()){
	              	result = rows.getTime("logintime").toString();
		          }
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
         }
		
		return result;	
  }
   
}
