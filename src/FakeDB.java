import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/////////////////////////////////////////////////////////////////////////
//File: FakeDB.java
//
// This file is a database that holds all the data for people (Patron's) and 
// textbooks (Copy's). 
//
// The data is stored in a HashMap.
//
// Each HashMap is like a table in a database.
//
// There is one hashMap for people (Patrons). It stores all the data for people 
//      who check out textbooks. It is called patronStore.
//
// There is a second hashMap for textbooks (Copies). It stores all the data for
//      textbooks. It is called copyStore.
//
// HashMaps have a key, which is a String, associated with each person or book. 
//
// Keys MUST be unique.
//
// Equals() and HashCode() methods should be defined in order to use the HashMap.
//
// References
// -----------
// HashMaps : https://www.youtube.com/watch?v=hgawTLk0o3Y
// See page 561 on HashCode: https://zimslifeintcs.files.wordpress.com/2011/12/head-first-java-2nd-edition.pdf
// HashCodes: https://www.youtube.com/watch?v=DSTpMWv0IlA
//
//
//
////////////////////////////////////////////////////////////////////////

public class FakeDB
{
	private static Map<String,Patron> patronStore;
	private static Map<String,Worker> workerStore; 
	private static Map<String, Copy> inventory;
	//private static Map<String,Copy> copyStore;
	private static Map<String,Textbook> textbookStore;
	//Textook now holds an array list of all the copies in inventory
	private static Map<String, Cla_ss> classStore;
	
	static // the following runs once when class is loaded: "static initializer"
	{
		patronStore = new HashMap<String,Patron>();	
		workerStore = new HashMap<String,Worker>();	
		inventory = new HashMap<String,Copy>();
		textbookStore = new HashMap<String,Textbook>();
		classStore = new HashMap<String, Cla_ss>();

		workerStore.put("W1", new Worker("W1"));
		workerStore.put("M1", new Manager("M1"));
		
		
		
//CREATE PATRON ERIC - no holds, no classes
		patronStore.put("P0", new Patron("P0", ""));
		patronStore.put("P1", new Patron("P1", "Eric"));

		
		//MAKE TEMI'S CLASS, DATABASE DESIGN 63002, AND MAKE A CORRESPONDING TEXTBOOK AND COPY.
	
		Textbook t2  = new Textbook("Designing SQl", "Wiley",22, 63002, 123.55, LocalDate.now());
		textbookStore.put("63002", t2);
	
		Textbook t1 = new Textbook("Technical Communications", "Apress",32, 60501, 75.00, LocalDate.now());
		textbookStore.put("60501", t1);
		
		LocalDate lastSemester = LocalDate.of(2016, 01, 14);
		//public Copy(Textbook t, String copyID, Patron outTo, boolean checked_out, boolean overdue, boolean hold, LocalDate check_out_date)
		//Copy copy_4 = new Copy(t1,"copy#4", "P4", true, true, true, lastSemester);
		//Copy(Textbook t, String copyID, Patron outTo, boolean checked_out, boolean overdue, boolean hold, LocalDate check_out_date)
		//Copy copy_5 = new Copy(t1,"copy#5",null, false, false, false, null);
		
		Cla_ss c1 = new Cla_ss("60501","Technical Communications","Summer2017",LocalDate.now(),LocalDate.now(),10,"SIES", true,t1);
		Cla_ss c2 = new Cla_ss("63002","Database Design","Summer2017",LocalDate.now(),LocalDate.now(),15,"SIES", true,t2 );
		classStore.put("63002", c2);
		classStore.put("60501", c1);
		
		Copy copy_1 = new Copy("copy#1",t2,null, false, false, false, null);
		Copy copy_2 = new Copy("copy#2",t2,null, false, false, false, null);
		Copy copy_3 = new Copy("copy#3",t2,null, false, false, false, null);
		//copy_1.setOutTo(yazeed);
		//copy_2
		//copy_3
		inventory.put("copy#1",copy_1);
		inventory.put("copy#2",copy_2);
		inventory.put("copy#3",copy_3);
		
		//MAKE TEMI AND PUT THE ASSOCIATED CLASS, TEXTBOOK, AND COPY DATA.
		//public Patron(String patron_id, String patron_name, String phoneNumber, String local_address, String perm_address, String email, String term)

//CREATE PATRON TEMI		
		patronStore.put("P3", new Patron("P3", "Temi", "6513333333", "123 St thomas blvd.", "456 st tommy street", "akin@stthomas.edu", "Summer17", t2));

//CREATE PATRON YAZEED - has hold and 2 classes
		Patron yazeed = new Patron("P4", "Yazeed", "6514444444", "129 St thomas blvd.", "789 st tommy street", "eng@stthomas.edu", "Summer17", t2);

		yazeed.addClasstoSchedule(c1);
		yazeed.setRequiredTextbook(t1);
		
		@SuppressWarnings("deprecation")
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		LocalDate date_is_due = today.plus(100, ChronoUnit.DAYS);
		//set a new class and textbook for Yazeed and place a hold
		Textbook t3= new Textbook("Fun with Objects", "Apress",4, 60103, 55.00, yesterday); 
		
		//public Copy(String copyID,Textbook t, Patron outTo, boolean checked_out, boolean overdue, boolean hold, LocalDate check_out_date)
		Copy copy_4 = new Copy("copy#4",t3,yazeed, true, true, true,LocalDate.of(2014, 4, 1));
		copy_4.setChecked_out(true);
		inventory.put("copy#4", copy_4);
		
		yazeed.setCopyOut(copy_4);
		patronStore.put("P4",  yazeed);

//CREATE PATRON HEATHER - has hold, no classes
//WHY DOESN'T THIS SHOW A HOLD?????????????? Its the same as Yazeed's
//The constructor doesn't create a hold. That has to happen with a method 
//of the manager class in Workstation. 

		Patron heather = new Patron("P2", "Heather");
		Copy copy_5 = new Copy("copy#5",t3,heather, true, true, true,LocalDate.of(2014, 4, 1));
		copy_5.checkIfOverdue();
		//	heather.setCopyOut(copy_5);
		copy_5.setChecked_out(true);
	//	heather.
	//	heather.setCopyOut(copy_5);
		//Here, copy_5 should set a hold
		inventory.put("copy#5", copy_5);
		

		patronStore.put("P2", new Patron("P2", "Heather"));
		
		//copyStore.put("C2", new Copy("C2", "More Fun with Objects"));
		//copyStore.put("C3",new Copy("C3", "Java Programming") );
		//copyStore.put("C4", new Copy("C4", "Pattern-Oriented Software Architecture"));
			
//		@SuppressWarnings("deprecation")
		//All Textbooks are currently set to have a due_date = Sept 1, 2017
		
//		LocalDate today = LocalDate.now();
//		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
//		LocalDate yesterday = tomorrow.minusDays(2);
//		LocalDate date_is_due = today.plus(100, ChronoUnit.DAYS);
		
		
		//textbookStore.put("Pattern-Oriented Software Architecture", new Textbook("Pattern-Oriented Software Architecture","Wiley",7, 76301, 44.57,date_is_due));
		//Using the book title as the key is a problem if two classes use the same textbook.
		//textbookStore.put("Java Programming", new Textbook("Java Programming","Liang",30, 60101, 67.43,date_is_due));
		//textbookStore.put("Java Programming", new Textbook("Java Programming","Liang",29, 60201, 67.43,date_is_due));
		//textbookStore.put("Technical Communications", new Textbook("Technical Communications the easy way","Johnson",10, 60501, 78.99,date_is_due));
		//int id,String name,String term,LocalDate start_date,LocalDate end_date,int max_num,String dept, boolean nxt_sem, ArrayList<Textbook> text )
		//having a null in the Cla_ss constructor causes a nul pointer exception!!!!!!!!!!!!
	
	
	}
	//HASHMAPS
	//https://www.youtube.com/watch?v=hgawTLk0o3Y
//	public boolean equals(Object obj)
//	{
//		if (obj !=null && obj instanceof Patron)
//		{
//			String patron_ID = ((Patron)obj).getPatron_ID();
//			String patron_name = ((Patron)obj).getPatron_name();
//		
//		if (patron_ID !=null && patron_ID.equals(this.patron_ID))
//		{
//			return true;
//		}
//	}
//		return false;
//	}
	
	//TEST THIS FUNCTION!!!!
	public void set_All_Patron_Hold()
	{
		for (int i = 1; i < (patronStore.size()+1); i++)
		{
			//Loop through each Patron and see if there is a hold on a copy???
			//put hold into the Patron class, too.
			
			String id = "P";
			id = id.concat(""+i);
			
			FakeDB database = new FakeDB();
			Patron p1 = database.getPatron(id);
			p1.addHold();
			
		}
	}
	
	public static Patron getPatron(String patronID)
	{
		return patronStore.get(patronID);
	}
	public static Worker getWorker(String workerID)
	{
		return workerStore.get(workerID);
	}
	
	public static Map<String, Patron> getPatronStore() {
		return patronStore;
	}

	public static void setPatronStore(Map<String, Patron> patronStore) {
		FakeDB.patronStore = patronStore;
	}

	public static Map<String, Copy> getInventory() {
		return inventory;
	}

	public static void setInventory(Map<String, Copy> inventory) {
		FakeDB.inventory = inventory;
	}

	public static Map<String, Textbook> getTextbookStore() 
	{
		return textbookStore;
	}

	public static void setTextbookStore(Map<String, Textbook> textbookStore) {
		FakeDB.textbookStore = textbookStore;
	}

	public static Map<String, Cla_ss> getClassStore() {
		return classStore;
	}
	public static Cla_ss getClass(String class_id) 
	{
		
		return classStore.get(class_id);
	}

	public static void setClassStore(Map<String, Cla_ss> classStore) {
		FakeDB.classStore = classStore;
	}

	public static void getText(String class_id, Map<String,Textbook> inventory)
	{
		if(textbookStore.containsValue(class_id))
		{
            System.out.println("The textbookStore contains a book for class_id " + class_id);
            System.out.println("class_id " + class_id + " requires textbook " + textbookStore.get(class_id).getText_title());
		}
		else
			System.out.println("The textbookStore DOES NOT contain any books for class_id " + class_id);
	}
	
	
	//Heather wrote this. It isn't exactly right. P13 should count the number of elements in the hashmap and increment.
	public static void putPatron(Object patron)
	{
		Patron p = (Patron) patron;
				
		patronStore.put("" + p.getPatron_ID(), new Patron("" + p.getPatron_ID(), p.getPatron_name()));	
		
	}
	
	public static Copy getCopy(String copyID)
	{
		return inventory.get(copyID);
	}
	//this cant be a static method
	public void putCopy(String copyID, Copy c)
	{
		this.inventory.put(copyID, c);
	}

	//this cant be a static method
	public void putClass(String class_ID, Cla_ss c)
	{
		this.classStore.put(class_ID, c);
	}

	

}
