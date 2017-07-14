// ArrayList data type comes from this library.
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/////////////////////////////////////////////////////////////////////////
//File: Patron.java
//
// This file is for a Patron (person) who checks out books from the rental
// library. Each person (Patron) has an ArrayList associated with him. The
// arrayList, called copiesOut, contains a list of books that they have 
// checked out. They should be able to check out more than one (two? 
// See requirements).
//
////////////////////////////////////////////////////////////////////////

public class Patron
{
	private String patron_ID;
	private String patron_name;
	private Boolean patron_hold = false;
	private double fines = 0;
	
	//This ArrayList holds a bunch of CHECKED OUT Copy objects.
	private ArrayList<Copy> copiesOut;
	private ArrayList<Cla_ss> classes;	
	private ArrayList<Textbook> books_required;
	

	private String phone;
	
	private String local_address;
	private String perm_address;
	private String email;
	private String term;
	
	
	//In Windows, generate getter and setters with: Alt + Shift + S
	public Patron()
	{
		this.patron_ID = "";
		this.patron_name = "";
		
		//Allocate some memory Copy objects. This has default capacity 10. It will resize when it reaches capacity.
		this.copiesOut = new ArrayList<Copy>();	
		this.classes = new ArrayList<Cla_ss>();
		this.books_required = new  ArrayList<Textbook>();
		//classes = new int[10];
		//num_of_classes = this.classes.size();
		
		local_address = "";
		perm_address = "";
		email = "";
		term = "";	
		
	}
	//This is used for testing data and methods in the Patron class.
	public Patron(String patron_id, String patron_name, String phoneNumber, String local_address, String perm_address, String email, String term, Textbook t)
	{
		//See FakeDB.java to see where data comes from.
		
		this.patron_ID = patron_ID; 
		this.patron_name = patron_name; 
		
	
		this.copiesOut = new ArrayList<Copy>();	
		this.classes = new ArrayList<Cla_ss>();
		this.books_required = new  ArrayList<Textbook>();
		
		
	//Add a class to Temi's schedule (simulate an external event)....
		//Get a couple Copies from the database
		FakeDB db = new FakeDB();
		
		//Get a class from the database and add it to Temi's class list.
		Cla_ss s1 = db.getClass("63002");	
		db.getClass("63002").getBooks();
		this.classes = new ArrayList<Cla_ss>();	
		this.classes.add(s1);
		
		//Fetch requred texts 
		this.books_required.add(t);
		
		this.setPhone(phoneNumber); 
		
		this.setLocal_address(local_address); 
		this.perm_address = perm_address;
		this.email  = email;
		this.term = term;

	
	}
	
	
	public Patron(String id, String name)
	{

		this.patron_name = name;
		this.patron_ID = id;
		this.patron_hold = false;
		
		
		//ArrayList help
		//See ArrayList Vs. array: https://www.youtube.com/watch?v=ZVJ7kpEMc7U
		//See https://www.youtube.com/watch?v=L1a8R9nkJ4w
		
		//These has default capacity 10. It will resize when it reaches capacity.
		this.copiesOut = new ArrayList<Copy>();	
		this.classes = new ArrayList<Cla_ss>();	
	
		
		phone = "" + 0;
		
		local_address = "";
		perm_address = "";
		email = "";
		term = "";	
		
	}
	
	
	public boolean payFines(Patron p)
	{
		boolean payFines = false;
	
		
		return payFines;
	}
	
	public void setFines(double d)
	{
		if (d<0)
		{
			d = -d;
		}
		
		this.fines = d;

	}
	
	public double getFinesFromCopysOut(double payment)
	{
		
		double value = 0;
		
		for (int i = 0; i < this.getCopiesOut().size(); i++) 
		{
		
			Copy c = this.getCopiesOut().get(i);
		
			if (c.hasHold())
			{
				value = value + c.getPrice_if_lost();
	
			}
		}
		
		return (value - payment);
	}
	
	public Copy getCopyFromCopiesOut(String id)
	{
		for (int i = 0; i < this.getCopiesOut().size(); i++) 
		{
		
			Copy c = this.getCopiesOut().get(i);
		
			if (id.equals(c.getCopyID()))
			{
				return c;
	
			}
		}
		return null;
	}
	
	public Copy getCopyWithFines()
	{
		for (int i = 0; i < this.getCopiesOut().size(); i++) 
		{
		
			Copy c = this.getCopiesOut().get(i);
		
			if (c.hasHold())
			{
				return c;
	
			}
	
		}
		
		Copy c = new Copy();
		c.setText_title("");
		return c;
	}
	
	public Copy getCopyFromCopiesOut(int index)
	{
		
			Copy c = this.copiesOut.get(index);

		return c;
	}
	
	public int getCopyIndexFromCopiesOut(Copy c)
	{
		String id = c.getCopyID();
		int index = this.copiesOut.indexOf(c);
		
		Copy d = this.copiesOut.get(index);
		
		System.out.println("" + d );
		System.out.println("index = " + index );
		
		return index;
	}
	
	public void removeHold()
	{
		this.patron_hold = false;
		
		
	}
	public void addHold()
	{
		this.patron_hold = true;
		
		
	}
	
	
	public void removeFromListOfCopiesOut(Copy c)
	{

			this.getCopiesOut().remove(c);

	}

	
	public String classStrings()
	{
		String classes = "";
		
		for (int i = 0; i < this.classes.size(); i++) {
			classes.equals(classes.concat(""+this.classes.get(i)));
		}
		
		return classes;
	}
	
	public void setRequiredTextbook(Textbook e)
	{
		this.books_required.add(e);
	}
	
	public void setclass(Cla_ss e)
	{
		this.setclass(e);
	}

	
	public void setclass(int class_ID) 
	{
		
		
	}
	
	public ArrayList<Textbook> getRequiredTextbooks() 
	{
		return this.books_required;
	}
	
	public ArrayList<Cla_ss> getClasses() 
	{
		return this.classes;
	}
	
	public String getPatron_name() {
		return patron_name;
	}

	public void setPatron_name(String patron_name) {
		this.patron_name = patron_name;
	}

	public String getPatron_ID() {
		return patron_ID;
	}

	public void setPatron_ID(String patron_ID) {
		this.patron_ID = patron_ID;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phoneNumber) {
		this.phone = phoneNumber;
	}

	public String getLocal_address() {
		return local_address;
	}

	public void setLocal_address(String local_address) {
		this.local_address = local_address;
	}

	public String getPerm_address() {
		return perm_address;
	}

	public void setPerm_address(String perm_address) {
		this.perm_address = perm_address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}


	public ArrayList<Copy> getCopiesOut() 
	{
		return copiesOut;
	}

//works
	public void setCopyOut(Copy copyOut) 
	{
		this.copiesOut.add(copyOut);
	}
	
	public int countClasses()
	{
		int count = 0;
		
		count = this.classes.size();
		
		StdOut.println( "--- Patron.countclasses() = " + count);
		
	return count;	
	}
	public void addClasstoSchedule(Cla_ss c)
	{
		this.classes.add(c);
	}
	
	///////////////////////////////////////////////////////
	//	USECASE #1 PATRON CHECKSOUT N BOOKS
	///////////////////////////////////////////////////////
	
//	DONE 1.A Patron brings some number, N, of Textbook Copies. 
//	DONE 2.Worker enters the Patron's patron_ID and initiates the checkout process. 

//	DONE 3.The System checks for Holds on the Patron account. (method checkHasHolds())

//	4. The System retrieves the list of classes that the Patron is taking/teaching, and associates those classes with a list of required Textbooks (book_record). 
//	5. The Worker enters a number, N, that represents the number of Textbook Copies that a Patron has brought to the WorkerStation for checkout. 
//	6. The Worker scans the barcode of a Textbook Copy. 
//	7. The System verifies that the Textbook Copy title is on the Patron's list of required Textbooks (book_record). 
//	8. The Worker enters the book's Copy_ID, a unique identifier for each Copy of the Textbook. 

	
//	9. The System initiates a CheckOut event. It changes the state of this Copy to 'Checked out,' by associating this Copy_ID with the patron_ID and todays_date.  
//     The System makes a Record of this System Event called 'Checkout.' The System concludes this Checkout event by returning a message to the Worker. 
//	     Repeat steps 6, 7, 8, and 9 for each of the N Textbook Copies. 

//	10. The System tells the Worker the due_date for the Checkedout Textbook Copies. The Worker verbally informs the Patron of the due date. 
//	11. The Patron leaves the store with their rented Textbook Copies.
//	
//	
	
	
///////////////////////////////////////////////////////////
//	This is step 3 of UseCase #1. PATRON CHECKSOUT N BOOKS
///////////////////////////////////////////////////////////
	
	
	public boolean checkHasHolds()
	{
		boolean has_holds = false;
		
		//search this.copiesOut ArrayList for holds. It is size 10.
		
		if (this.copiesOut.isEmpty())
		{
			has_holds = false;
			
			//This is what makes every patron have a hold
		//	if(this.patron_hold = true)
			//{
			//	has_holds = true;
			//}
		}
		else
		{
			for (Copy c : this.copiesOut) 
			{
				if (c.checkIfOverdue())
				{
					this.patron_hold = true; 
					c.setHold(true);
					 has_holds = true;
				}
				  if (c.hasHold() == true)
				  {
					  has_holds = true;
					  this.patron_hold = true; 
					  
				  }
			}
		}
		return has_holds;
	}
	
///////////////////////////////////////////////////////////
//UC #1, Steps 3 and 4 are in the controller class, Rental Library.
///////////////////////////////////////////////////////////

	
	public boolean checkCopyOut(Copy c)
	{

		// finish this
		boolean bookCheckedOut = false;
		
		//check holds
		
		
		
		//Put book back into inventory at the Rental office
		this.getCopiesOut().add(c);
		
		//set the value of Copy.outTo to the patron variable
		c.setOutTo(this);
		
		//if the book is NOT in Erics arrayList, then return false. Else, 
		//   the test succeeds and returns true, indicating that Eric
		//   got the book from the rental office. It is now stored in his
		//   arrayList of books.

		bookCheckedOut = this.CopyisInArrayList(c);	
		
		return bookCheckedOut;
	}

	public boolean CopyisInArrayList(Copy c)
	{
		boolean result = false;
		
		if (this.getCopiesOut().contains(c))
			result = true;
		else
			result = false;
		
	return result;
	}




	

	public boolean checkCopyIn(Copy c)
	{
	
		
		boolean bookReturned = false;
		
		//Get the ID of the book that is being returned (checkedIn).
		String book_ID_for_removal = c.getCopyID();
		
		Patron person_checking_in_a_book;
		
		//Get the ID of the person that is returning a book to the rental shop (checkingIn).
		String patron_id = c.getOutToID();
		
		//Get the ID of the person object.
		person_checking_in_a_book = FakeDB.getPatron(patron_id);
		
		//Get the ID of the person's name.
		String patron_name_checked_out_to = person_checking_in_a_book.getPatron_name();
		
		
		//Put book back into inventory at the Rental office

		
		
		StdOut.println("");
		StdOut.println("" + c.toString());
		StdOut.println("This book will be returned to the rental shop by Patron named " + patron_name_checked_out_to + ". His ID # is " + c.getOutToID() + "."  );
		StdOut.println("");
		
		
		bookReturned = this.getCopiesOut().remove(c);
		
	
		
		
		
		bookReturned = this.CopyisInArrayList(c);	
		bookReturned = !(bookReturned);
		
		return bookReturned;
	}

	@Override
	public boolean equals(Object o)
	{
		
		Patron p = (Patron) o;
		
		if (this.patron_ID.equals(p.getPatron_ID()))
		{
			return true;
		}
		else
		return false;
	}


	public String toString()
	{
				
		String p = "";
		
		p = p.concat("PATRON ID: " + this.getPatron_ID() + "\n" + "PATRON NAME: " + this.getPatron_name() + "\n" + "PATRON'S CHECKED OUT BOOKS: " + this.getCopiesOut() + "\n");
		
		
		return p;
	}
	

}
