import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Workstation 
{
	
	//This is our controller class
	LocalDateTime checkoutDate ;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	String patron_ID_entered;
	String worker_ID;
	
	//formatDateOutput();
	
	public Workstation() 
	{
		
		
	}
	//changed to worer ID
	public Workstation(String workerID) 
	{
		
		//this.patron_ID_entered = patronID;
		this.worker_ID = workerID;
		
	}

	
	public Patron startCheckout(String worker_ID)
	{
		Gui g = new Gui();
		
		//Print out the Worker_ID
		//Goofy output is coming from the toString() method from Textbook class.
		//I think it might be originating from the FakeDB class.
		g.outputWorkerID(worker_ID);
			
		//Worker enters Patron id
		String patronID = workerEntersPatronID(g);
				
		FakeDB db = new FakeDB();
		
		//get patron from database		
		Patron p = db.getPatron(patronID);
		
		//check for holds		
		Boolean has_holds = p.checkHasHolds();
		StdOut.println( "" );
		
		//output any holds to Worker that originate from late copies
		g.outputPatronHoldsToWorkerFromLateCopies(p, has_holds);

		 //output patron schedule to the worker
		g.outputPatronSchedule(p);
		
		
		p = payFinesForCopiesCheckedOut(g, db, p);
	
		//Loop logic starts here.

	return p;	
	}
	
	private Patron payFinesForCopiesCheckedOut(Gui g, FakeDB db, Patron p) 
	{
		//this gets total fines from all late copies
		double fines = p.getFinesFromCopysOut(0); //returns $55.00
		
		g.printFinesFromCopysOut(p); //prints $55.00
		
		Copy c = new Copy();
		
		//this gets the first copy with fines
		c = p.getCopyWithFines();
		
		if (fines != 0.0)
		{
			
			 p = pay(fines, p, c);
			
		}
	return p;
	}
	

	private void formatDateOutput() 
	{
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		String formattedDate = formatter.format(LocalDate.now());
	}

	private String workerEntersPatronID(Gui g) 
	{
		
		String patronID = "";
		
		patronID = g.enterPatronID();
		
		this.patron_ID_entered = patronID;
		
		return patronID;	
	}
	
	public Patron pay(double fines, Patron p, Copy copyInput) //fines = $55.00
	{
		//char c.equals("");
		Gui g = new Gui();
		
		String pay = g.payOutput();
		 
		//Patron want to pay fines....
		if (pay.equals("y")||pay.equals("Y")||pay.equals("yes")||pay.equals("Yes"))
		{
			double payment = g.payAmountOutput();
			
			//The payment value is larger than the fine value -> give change
			if (payment > fines || payment == fines)
			{
				double change = g.calculate_change(payment,fines);
		
				//remove hold from patron account here.....
				p.removeHold();
			
				//set fines to 0 in the patron class
				p.setFines(0);
				//p.getCopiesOut().remove(copyInput.getCopyID());
			
				//remove fine from p.copiesOut  HERE.....
				 p.removeFromListOfCopiesOut(copyInput);
				
				 
				//Remove the hold from the specific copy
				//Note: I couldn't resent the checkout date to a null value
				// because that isn't allowed, so this will introduce bugs.
				//setCopyStateToCheckedIn(p, copyInput);
			
				
			}
			
			//fine was not paid in full
			else  //$55.00 - 40 = $15.00
			{
				
				double remaining_fines = fines - payment;
				
				p.setFines(remaining_fines);
	
				
				//Pay fines again.....
		
				
				g.outputFinesAgain(remaining_fines);
				
				pay(remaining_fines, p, copyInput);
			}
		}
		else
		{
			g.outputMustPay();
		}
		
	return p;
	}
	
	private Patron setCopyStateToCheckedIn(Patron p, Copy copyInput) 
	{
		FakeDB db = new FakeDB();
		
		//Copy copy = db.getCopy(""+copyInput.getText_title());
		
		//set the copies outTo to a null Patron.
		
		Patron nullPatron = db.getPatron("P0");
		copyInput.setOutTo(nullPatron);
		
		//remove copy's overdue state and holds.
		
		copyInput.setHold(false);
		copyInput.setOverdue(false);
		copyInput.setChecked_out(false);
		
		//remove copyInput from the Patrons arrayList of copiesOut.

		
		 p.removeFromListOfCopiesOut(copyInput);
		
		//put the copy back into inventory
		
		//((ArrayList<Copy>) db.getInventory()).add(copyInput);
		
	return p;
	}
	
	public Patron checkOutLoop(Patron p)
	{
		Gui g = new Gui();
		
		String anotherBook = "Y";
		
		
		while(anotherBook.equals("Y")||anotherBook.equals("y")|| anotherBook.equals("Yes")|| anotherBook.equals("yes"))
		{
			String copy_id = g.checkout();
		
		
			FakeDB db = new FakeDB();
			Copy c = (db.getCopy(copy_id));

	
			p = checkedout(c, p, g);
			
			anotherBook = g.enterAnotherBook();
		}
		
	return p;
	}
	
	public Patron checkedout(Copy c, Patron p, Gui g)
	{
		//Copy cant be checkedout
		
		if (c.isChecked_out())
		{
			g.output_if_checkedOut(c);
		
		}
		
		//Copy is checkedout
		
		else
		{
			LocalDate today = LocalDate.now();
			
			c.setCheck_out_date(today);
			
			c.setChecked_out(true);
			
			c.setHold(false);
			
			c.setOutTo(p);
			
			//patron data is not set. Error here!!!!!!!
			//p.checkCopyOut(c);
			
			//Both of these two methods do the same thing....
			p.getCopiesOut().add(c);
			//p.setCopyOut(c);
			
			FakeDB db = new FakeDB();
			
			db.getInventory().get(c.getCopyID()).setChecked_out(true);
			db.getInventory().get(c.getCopyID()).setCheck_out_date(today);
			db.getInventory().get(c.getCopyID()).setHold(false);
			db.getInventory().get(c.getCopyID()).setOutTo(p);
			//Due date should be set inside the Textbook constructor
			//db.getInventory().get(c.getCopyID()).setDue_date(due_date);
			
		}
		return p;
	}
	
	public void endCheckout(Patron p)
	{
		//report back which books were checked out.
		
		
		Gui g = new Gui();
		
		g.outputPatronSchedule(p);

		g.outputPatronsCheckedOutBooks(p);
		
		//This method doesn't run
		//output = g.report_CheckOut_States(p);
		
		//output due_date
		LocalDate date = p.getCopiesOut().get(0).get_Due_date();
		g.output_due_date(date);
		
		
	}

	
	
	public Patron menuProcess(int selection, Patron p, String workerID)
	{
		Gui g  = new Gui();
		
//  1 - Start patron checkout ----
		
		
		if (selection == 1)
		{
			
			p = checkOutLoop(p);
			endCheckout(p);
		}
		
//	2 -  Start patron checkin ----
		
		else if (selection == 2)
		{
			//output the patrons currently checkedOut books.
			checkIn(p, g);
			
		}
		
//  3 - Place a hold on all patrons ----
		
		else if (selection == 3)
		{
		
		}
		
//  4 - quit ----
		
		else if (selection == 4)
		{
			g.quit(workerID);
			System.exit(0);
		}
		
		return p;
	}
	
	private void checkIn(Patron p, Gui g) 
	{
		endCheckout(p);
		
		//Worker enters the copy_id for check in.
		String id = g.checkin();
		
		//get the Copy object from the arraylist using the id
		
		//c will equal a copy or null
		
		Copy c = p.getCopyFromCopiesOut(id);
		
		if (c == null)
		{
			//copy was not found in arraylist
			
			g.copyNotFound();
		}
		else
		{
			//copy found

			setCopyStateToCheckedIn(p, c);
	
			p.removeFromListOfCopiesOut(c);
		}

		//output patrons copies that are checkedout
		g.outputPatronsCheckedOutBooks(p);

		String anotherBook = g.enterAnotherBook();
		
		while(anotherBook.equals("Y") || anotherBook.equals("y"))
		{
			
			checkIn(p,g);
		}
	}
	
	public static void main(String[] args)
	{
		//Associate the Worker (either "M1" for manager or "W1" for Worker)
		//with the workstation. Only M1 can place holds.
		
		Workstation myWorkStation = new Workstation();
		
		Worker myWorker = new Worker();
		
		String myWorkerID = myWorker.getUsersWorker_ID();
		
		//System.out.println("*****");
		//Strange output "Designing SQL" originates here....
		
		myWorker.setWorker_ID(myWorkerID);
		
		//Are they a manager??? check DB. Only managers can place a hold.
		
		FakeDB db = new FakeDB();
		
		Worker w = db.getWorker(myWorkerID);
	
		Boolean isManager = w.isManager();
		
		//start the checkout process for a patron

		String patron_id = myWorkStation.patron_ID_entered;	
		
		//This should be moved into the menu option = 1

		//Note: this is where we check for holds - should this be in the menu option
		Patron p = myWorkStation.startCheckout(myWorkerID);
		
		Gui g = new Gui();
		
		//display menu 
		int menuOption  = g.firstMenuOutput();

		//get menu selection from user.
		if ((menuOption == 1) || (menuOption == 4))
		{

			p = myWorkStation.menuProcess(menuOption,p,myWorkerID);
			
		}
		else
		{
			while(menuOption != 1 && menuOption != 4)
			{
				g.enterOption();
			}
		}
	
		while (menuOption != 4)
		{
			//Output the menu again since checkout is complete.
			
			menuOption = g.menuOutput();
		
			//get menu selection from user.
		
			p = myWorkStation.menuProcess(menuOption,p,myWorkerID);
			
		}
		
	}

}
