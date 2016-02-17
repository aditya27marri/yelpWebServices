package Connection;

import javax.jws.WebService;

import Connection.DatabaseConnection;
import Connection.User_info;
@WebService
public class Home {
	
DatabaseConnection db=new DatabaseConnection();
User_info ui=new User_info();
User_entry ue=new User_entry();
Category ca=new Category();
Element El=new Element();
	public int countCategory()
	{
		System.out.println("category count");
		int result;
		
		
		result = ca.countCategory();
		
		return result;
}public String[] displayCategory()
{
	System.out.println("displaycategory");
	String [] result;
	
	
	result = ca.displayCategory();
	
	return result;
}
public int countElement(String Category){
	System.out.println("displaycategory");
	int result;
	
	
	result = El.countElement(Category);
	
	return result;
}public String[] displayElement(String Category)
{
System.out.println("displayElement");
String [] result;


result = El.displayElement(Category);

return result;
}
	public String login(String username, String pwd)
	{
		System.out.println("Inside login");
		String result;
		
		
		result = db.login(username,pwd);
		
		return result;
}
	public String user(String username)
	{
		System.out.println("Inside user");
		String result;
		
		
		result = db.user(username);
		
		return result;
}public String updateTime(String username)
{
	System.out.println("to update time");
	String result;
	
	
	result = db.updateTime(username);
	
	return result;
}
	public String  signUp(String userName, String firstname, String lastname,String emailid,String password)
	{
		System.out.println("Inside login");
		String result;
		
	
		result = db.signUp(userName,firstname,lastname,emailid,password);

		
		return result;
}
	public String[]  displayUserRows(String userName)
	{
		System.out.println("fetching rows");
		String[] result;
		
	
		result = ui.displayUserRows(userName);

		
		return result;
}
	public String[]  displayEntryRows(String userName)
	{
		System.out.println("fetching rows");
		String[] result;
		
	
		result = ue.displayEntryRows(userName);
		return result;
}
	public int  countEntryRows(String userName)
	{
		System.out.println("fetching rows");
		int result;
		
	
		result = ue.countEntryRows(userName);
		return result;
}
		public String  writeReview(String loginId,String category, String element, String description,String rating,String review)
	{
		System.out.println("fetching rows");
		String result;
		
	
		result = db.writeReview(loginId,category,element,description,rating,review);
		return result;
}
		public String  deleteReview(int reviewId)
		{
			System.out.println("fetching rows");
			String result;
			
		
			result = db.deleteReview(reviewId);
			return result;
	}public String  deleteCategory(int CategoryId)
	{
		System.out.println("fetching rows");
		String result;
		
	
		result = db.deleteCategory(CategoryId);
		return result;
}
	public String  deleteElement(int ElementId)
	{
		System.out.println("fetching rows");
		String result;
		
	
		result = db.deleteElement(ElementId);
		return result;
}
		public String[]  displayReviewRows(int reviewId)
		{
			System.out.println("fetching rows");
			String[] result;
			
		
			result = ue.displayReviewRows(reviewId);
			return result;
	}
		public String  addCategory(String Category)
		{
			System.out.println("fetching rows");
			String result;
			
		
			result = db.addCategory(Category);
			return result;
	}
		public String  addElement(String Category,String Element)
		{
			System.out.println("fetching rows");
			String result;
			
		
			result = db.addElement(Category,Element);
			return result;
	}
		public String updateReview(String category,String element,String description,String rating,String review,int reviewId)
		{System.out.println("fetching rows");
		String result;
		result = db.updateReview(category,element, description,rating, review,reviewId);
		return result;
		}
		public String getTime(String userName)
		{System.out.println("geting time");
		String result;
		result = ui.getTime(userName);
		return result;
		}
}
