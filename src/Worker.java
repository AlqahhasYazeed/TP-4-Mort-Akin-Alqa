import java.util.Map;

public class Worker 
{
	String worker_ID;
	Boolean isManager = false;

//	public Worker()
//	{
//		
//	}

	public Worker(String worker_ID)
	{
		this.worker_ID = worker_ID;
	}
	
	public String getUsersWorker_ID() 
	{
		Gui g = new Gui();
		String id = g.getUsersWorker_ID();
		
		
		if(id.equals("M1"))
		{
			this.isManager = true;
		}
		
		else
			this.isManager = false;
		
		return id;
	}
	


	public String getWorker_ID() 
	{
		return this.worker_ID;
	}

	public void setWorker_ID(String worker_ID) 
	{
		this.worker_ID = worker_ID;
	}

	public Worker() 
	{
		worker_ID = "";
	}
	public Boolean isManager()
	{
		return this.isManager;
	}


	

}
