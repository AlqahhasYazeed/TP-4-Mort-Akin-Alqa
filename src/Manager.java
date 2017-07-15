import java.util.HashMap;
import java.util.Map;

public class Manager extends Worker
{
	
	
	public Manager(String manager_ID) 
	{
		this.isManager = true;
		this.setWorker_ID(manager_ID);
	}
	
	public void set_All_Patron_Hold()
	{
		//This should get logged in Events. Should events output to a file???
		
		//retrieve data from database - THIS SHOULD PROBOBLY BE A FUNCTION IN DB
		FakeDB db = new FakeDB();
		
		
		//db.setAllPatronStoreHolds();
		db.set_All_Patron_Hold();
		
		//loop through each patron and set hold
//		for(int i=0; i < patronTempStore.size(); i++)
//		{
//			Patron p = patronTempStore.get(i);
//			//String id = p.getPatron_ID();
//			String id = patronTempStore.get(i).getPatron_ID();
//			
//			p = p.setHold();
//			patronTempStore.put(id, p);
	}


//	}

}
