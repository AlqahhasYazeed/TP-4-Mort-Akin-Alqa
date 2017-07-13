
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
		String id = "";
		
		StdOut.print( "Hello, TRL system Worker.\n"+"Please enter 'M1' (Manager_ID) or 'W1' (Worker_ID)\n" + "\n" + "Please enter your Worker ID# >> "  );
		StdOut.println("");
		id = StdIn.readLine();
		
		StdOut.print("Worker " + id + " is logged in.\n");
		StdOut.print("\n");
		
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
