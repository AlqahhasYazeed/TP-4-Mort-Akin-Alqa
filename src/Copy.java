import java.time.LocalDate;
import java.util.Date;

///////////////////////////////////////////////////////////////////////////////
//File: Copy.java
//
// This file represents books. 
// These books are contained in the arrayList object in file Patron.java.
// The arrayList holds all the books that each person has checked out.
//
/////////////////////////////////////////////////////////////////////////////

public class Copy extends Textbook
{
	private String copyID;
	//title is inherited from TExtbook
	private Patron outTo;
	
	private boolean checked_out = false;
	private boolean overdue = false;
	private boolean hold = false;
	
	//Due date is set to August 1st for all instances of Textbook and Copy 
	//(because it inherits from Textbook)
	//private LocalDate due_date = LocalDate.of(2017,8,30);
	private LocalDate date_Of_CheckOut;
	LocalDate today = LocalDate.now();
	
	//All Textbooks and Copys will be Not Overdue, unless we change the due_date
	public Copy()
	{
		this.copyID = "P0";
	}
	
	public Copy(Textbook t,String copyID)
	{
		this.copyID = copyID;		
		this.checked_out = false;
		this.overdue = false;
		this.hold = false;
		
		//inherited from textbook
		this.text_title = t.getText_title();
		this.publisher_name = t.getPublisher_name();
		this.class_ID = t.getClass_ID();   //For sies 635, section 7 --> class_ID = 63507
		this.price_if_lost = t.getPrice_if_lost();
		//All Textbooks are currently set to have a due_date = August 30th, 2017
		this.due_date = t.getDue_date();
		//this.overDue = false;
		
		
	}
	public Copy(String copyID,Textbook t, Patron outTo, boolean checked_out, boolean overdue, boolean hold, LocalDate check_out_date)
	{
		this.copyID = copyID;
		this.setText_title(t.getText_title());
		this.outTo = outTo;
		
		this.checked_out = checked_out;
		this.overdue = overdue;
		this.hold = hold;
		
		//Will this produce a null pointer exception????????????
		this.date_Of_CheckOut = check_out_date;
		
		//inherited from textbook
		this.text_title = t.getText_title();
		this.publisher_name = t.getPublisher_name();
		this.class_ID = t.getClass_ID();   //For sies 635, section 7 --> class_ID = 63507
		this.price_if_lost = t.getPrice_if_lost();
		//All Textbooks are currently set to have a due_date = August 30th, 2017
		this.due_date = t.getDue_date();
		//this.overDue = false;
	}

// Generate getters and setters using Eclipse Source menu.
	//Heather generated getter and setters by clicking Source -> Generate Getters and Setters.
	
	public void resetDue_date(LocalDate newDueDate)
	{
		this.due_date = newDueDate;
		//recalculate this.overdue
		if (checkIfOverdue())
			this.overdue = true;
		else
			this.overdue = false;
	}
	
	public LocalDate get_Due_date()
	{
		return this.due_date ;
		
	}
	
	@SuppressWarnings("static-access")
	public boolean checkIfOverdue() 
	{
		boolean overdue = false;
		
		LocalDate checkedOut = this.date_Of_CheckOut;
		
		if (checkedOut==null)
			overdue = false;
		else if (this.today.isAfter(checkedOut))
		{
			
			//This is where we set a hold.
			this.overdue = true;
			this.hold = true;
			this.outTo.addHold();
		}
		
	return overdue;
	}
	

	
	public boolean isChecked_out() {
		return checked_out;
	}

	///////////////////////////////////////////////////////////////////////
	public void setChecked_out(boolean checked_out) {
		this.checked_out = checked_out;
	}

	public boolean isOverdue() {
		return overdue;
	}

	public void setOverdue(boolean overdue) 
	{
		//if (today > due_date) --> the book is overdue/late.
		//if (today < due_date) --> the book is NOT overdue/late.
		if (this.today.isAfter(this.due_date))
			this.overdue = true;
		
		//Note: This will never return that a book is over, unless 
		//      the due date is reset.
	}

	public boolean hasHold() {
		return hold;
	}

	public void setHold(boolean hold) {
		this.hold = hold;
	}

	public LocalDate getCheck_out_date() 
	{
		return this.date_Of_CheckOut;
	}

	public void setCheck_out_date(LocalDate check_out_date) 
	{
		this.date_Of_CheckOut = check_out_date;
	}

	public String getCopyID() 
	{
		return copyID;
	}

	public void setCopyID(String copyID) 
	{
		this.copyID = copyID;
	}

	public String getTitle() 
	{
		return this.getText_title();
	}

//	public void setTitle(String title) 
//	{
//		this.t = title;
//	}

	public Patron getOutTo() 
	{
		if (this.outTo.equals(null))
		{
			return null;
		}
		
		return outTo;
	}

	public String getOutToID() 
	{
		String id = outTo.getPatron_ID();
		
		return id;
	}

	public void setOutTo(Patron outTo) 
	{
		this.outTo = outTo;
	}

	// Heather wrote this.
	public String toString()
	{
		
		String book = "";
		
		book = book.concat("\nCOPY TITLE: " + this.getTitle() + "\n" + "COPY ID: " + getCopyID());
		
//		if (!(getOutToID().equals(null)))
//		{
//			book = book.concat("COPY CHECKED OUT TO: " + getOutToID());
//		}
		
		return book; 
	}

	//Heather wrote this.
	@Override
	public boolean equals(Object o)
	{
		// finish this: two are equals iff same copy ID
		
		Copy c = (Copy) o;
		
		if (this.copyID.equals(c.getCopyID()))
		{
			return true;
		}

		return false;
	}

	//NOTE: HE WANTS OUTPUTS LIKE: StdOut.println("c1" );
//	public static void main(String[] args)
//	{
//		Copy c1 = new Copy("C1", "Fun with Objects");
//		Patron p1 = new Patron("Eric", "P47");
//
//		//This line print the first output.
//		StdOut.println("c1" + "\n" + "---");
//		System.out.println(c1);
//		
//		StdOut.println("");
//		
//		//This line print the second output.
//		StdOut.println("p1" + "\n" + "---");
//		System.out.println(p1);
//		
//		Copy c2 = FakeDB.getCopy("C2");
//		
//		//Heather wrote this.
//		//This line print the second output. We can see that they are almost identical.
//		StdOut.println("c1" + "\n" + "---" + "\n" + c1.toString() + "\n");
//		
//		
//		
//		
//	}
}
