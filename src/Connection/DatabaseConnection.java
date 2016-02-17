package Connection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class DatabaseConnection {


	Connection con = null;
	static ResultSet rs;
	static ResultSet rows;
    Statement stmt = null;
   int rowcount=0;
    
	DatabaseConnection(){		
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

	public String login(String userName, String pwd){
		System.out.println("Inside db login");
		String result = "";
		
		try {
			String query = "select count(*) as count from yelp.user_info where loginId= '" + userName + "' and password= '" + pwd + "'";
			System.out.println(query);
			rows =stmt.executeQuery(query);
			
			 while(rows.next()){
	            	int cou = rows.getInt("count");
	            	if(cou == 1){
	    				result="true";
	    				System.out.println("login Successful");
	    			}
	    			else{
	    				result="false: The value didnt match values in the database.";
	    			}
	            	
	            }		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
}
	public String user(String userName){
		System.out.println("Inside db user");
		String userId = "";
		
		try {
			String query = "select loginId from yelp.user_info where loginId= '" + userName + "'";
			System.out.println(query);
			rows =stmt.executeQuery(query);
			
			 while(rows.next()){
	            	 userId = rows.getString("loginId");
	     }      		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
}
	public String signUp(String userName,String password, String firstname, String lastname,String emailid)
	{
		System.out.println("Inside db login");
		String result = "";
		String logintime ="current_time";
		try {
			String query = "insert into yelp.user_info values('" + userName + "','" + password + "','"+ firstname + "','"+lastname+ "','"+ emailid + "',"+logintime + ")";
			System.out.println(query);
			rowcount =stmt.executeUpdate(query);
			if(rowcount > 0){
				result="true";
				System.out.println("sign up Successful");
			}
			else{
				result="false: The value didnt match values in the database.";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		}
	public String addCategory(String Category)
	{
		System.out.println("Inside db login");
		String result = "";
		try {
			String query = "insert into yelp.Category (Category) values('" +Category+ "')";
			System.out.println(query);
			rowcount =stmt.executeUpdate(query);
			if(rowcount > 0){
				result="true";
				System.out.println("entry into category Successful");
			}
			else{
				result="false: The value didnt match values in the database.";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		}
	public String addElement(String Category,String Element)
	{
		System.out.println("Inside db login");
		String result = "";
		try {
			String query = "insert into yelp.Element (Category,Element) values('" +Category+ "'"+Element+"')";
			System.out.println(query);
			rowcount =stmt.executeUpdate(query);
			if(rowcount > 0){
				result="true";
				System.out.println("entry into category Successful");
			}
			else{
				result="false: The value didnt match values in the database.";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		}
	public String writeReview(String loginId,String category, String element, String description,String rating,String review)
	{
		System.out.println("review query");
		String result = "";
		try {
			String query = "insert into yelp.user_entry(`loginId`,`category`,`element`,`description`,`rating`,`review`) values ('" + loginId + "','"
					+ category + "','" +element + "','" + description + "','" 
					+ rating + "','" + review + "')";
			System.out.println(query);
			rowcount =stmt.executeUpdate(query);
			if(rowcount > 0){
				result="true";
				System.out.println("review inserted Successful");
			}
			else{
				result="false: The value didnt match values in the database.";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return result;
	}

public String deleteReview(int reviewId)
{
	System.out.println("review delete");
	String result = "";
	try {
		String query = "delete from yelp.user_entry where reviewId='"+reviewId+"'";

		System.out.println(query);
		rowcount =stmt.executeUpdate(query);
		if(rowcount > 0){
			result="true";
			System.out.println("review inserted Successful");
		}
		else{
			result="false: The value didnt match values in the database.";
		}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}return result;
}
public String deleteCategory(int CategoryId)
{
	System.out.println("review delete");
	String result = "";
	try {
		String query = "delete from yelp.Category where CategoryId='"+CategoryId+"'";

		System.out.println(query);
		rowcount =stmt.executeUpdate(query);
		if(rowcount > 0){
			result="true";
			System.out.println("Category deleted Successful");
		}
		else{
			result="false: The value didnt match values in the database.";
		}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}return result;
}
public String deleteElement(int ElementId)
{
	System.out.println("review delete");
	String result = "";
	try {
		String query = "delete from yelp.Element where CategoryId='"+ElementId+"'";

		System.out.println(query);
		rowcount =stmt.executeUpdate(query);
		if(rowcount > 0){
			result="true";
			System.out.println("Category deleted Successful");
		}
		else{
			result="false: The value didnt match values in the database.";
		}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}return result;
}
public String updateReview(String category,String element,String description,String rating,String review,int reviewId)
{
	System.out.println("review delete");
	String result = "";
	try {
		String query = "update yelp.user_entry set category='"+category+"', element='"+element+"'"
				+ ",description='"+description+"', rating='"+rating+"', review='"+review +"'where reviewId ='"+reviewId+"'";

		System.out.println(query);
		rowcount =stmt.executeUpdate(query);
		if(rowcount > 0){
			result="true";
			System.out.println("review updated Successful");
		}
		else{
			result="false: The value didnt match values in the database.";
		}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}return result;
}
public String updateTime(String userName){
	String result="";
		try{
	            	String query = "update yelp.user_info set logintime = current_time  where loginId= '" + userName + "'";
					
					rowcount = stmt.executeUpdate(query);
					if(rowcount > 0){
						result="true";
						System.out.println("review inserted Successful");
					}
					else{
						result="false: The value didnt match values in the database.";
						System.out.println("update not  success");
					}    	
	            
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
       }
		
		return result;	
}
}