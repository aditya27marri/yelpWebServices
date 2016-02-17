package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Category {
	Connection con = null;
	static ResultSet rows;
	int timeupdate =0;
    Statement stmt = null;
   int 			rowcount=0;
   int row = 0;
   String query="";
   Category(){
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
public int countCategory(){
	   
	   try {
    		  query = "select count(*) as count from Category";
   		System.out.println(query);
   		rows =stmt.executeQuery(query);
			 while(rows.next()){
          	row = rows.getInt("count");
           	System.out.println("category table row"+row);	
			 }
	   }
       catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
     } return row;
   }
   public String[] displayCategory(){
	   rowcount = countCategory();
	   rowcount = 2 * rowcount;
		System.out.println("category table row"+rowcount);
    	 String[] result= new String[rowcount];
          	try {
			 query = "select * from Category";
			System.out.println(query);
			rows =stmt.executeQuery(query);
			int i=0;
			 while(rows.next()){
				 System.out.println("printing variables:");
	            	result[i] = rows.getString("Category");
	            	i++;
	            	result[i] = rows.getString("CategoryId");
	            	i++;
	            }
           	} catch (SQLException e) {
			e.printStackTrace();
          }
		return result;	    
   }

}
