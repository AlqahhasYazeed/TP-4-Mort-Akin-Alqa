import java.util.HashMap;
import java.util.Map;

public class Manager extends Worker
{
	
	
	public Manager(String manager_ID) 
	{
		this.isManager = true;
	}
	
//	public void set_All_Patron_Hold()
//	{
//		//This should get logged in Events. Should events output to a file???
//		
//		//retrieve data from database - THIS SHOULD PROBOBLY BE A FUNCTION IN DB
//		FakeDB db = new FakeDB();
//		Map<String,Patron> patronTempStore;
//		patronTempStore = new HashMap<String,Patron>();	
//		patronTempStore = db.getPatronStore();
//		
//		//loop through each patron and set hold
//		
//		//return to DB
//		
//	}

}
