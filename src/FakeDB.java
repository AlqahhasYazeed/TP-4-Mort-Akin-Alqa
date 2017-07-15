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
////HASHMAPS
//   https://www.youtube.com/watch?v=hgawTLk0o3Y
//
////////////////////////////////////////////////////////////////////////

public class FakeDB
{
	private static Map<String,Patron> patronStore;
	private static Map<String,Worker> workerStore; 
	private static Map<String, Copy> inventory;
	//texbookStore holds an array list of all the Texts in inventory.
	private static Map<String,Textbook> textbookStore;
	private static Map<String, Course> classStore;
	
	static // the following runs once when class is loaded: "static initializer"
	{
		patronStore = new HashMap<String,Patron>();	
		workerStore = new HashMap<String,Worker>();	
		inventory = new HashMap<String,Copy>();
		textbookStore = new HashMap<String,Textbook>();
		classStore = new HashMap<String, Course>();

		workerStore.put("W1", new Worker("W1"));
		workerStore.put("M1", new Manager("M1"));
		
		
		
//CREATE PATRON ERIC - no holds, no classes
		patronStore.put("P0", new Patron("P0", "null_patron"));
		patronStore.put("P1", new Patron("P1", "Eric"));

		
//MAKE TEMI'S CLASS, DATABASE DESIGN 63002, AND MAKE A CORRESPONDING TEXTBOOK AND COPY.

		
		Textbook t2  = new Textbook("Designing SQl", "Wiley",22, 63002, 123.55, LocalDate.now());
		textbookStore.put("63002", t2);
	
		Textbook t1 = new Textbook("Technical Communications", "Apress",32, 60501, 75.00, LocalDate.now());
		textbookStore.put("60501", t1);
		
		LocalDate lastSemester = LocalDate.of(2016, 01, 14);
	
		Course c1 = new Course("60501","Technical Communications","Summer2017",LocalDate.now(),LocalDate.now(),10,"SIES", true,t1);
		Course c2 = new Course("63002","Database Design","Summer2017",LocalDate.now(),LocalDate.now(),15,"SIES", true,t2 );
		classStore.put("63002", c2);
		classStore.put("60501", c1);
		
		Copy copy_1 = new Copy("copy#1",t2,null, false, false, false, null);
		Copy copy_2 = new Copy("copy#2",t2,null, false, false, false, null);
		Copy copy_3 = new Copy("copy#3",t2,null, false, false, false, null);

		inventory.put("copy#1",copy_1);
		inventory.put("copy#2",copy_2);
		inventory.put("copy#3",copy_3);
		
//CREATE TEMI AND PUT IN THE ASSOCIATED CLASS, TEXTBOOK, AND COPY DATA.
// Temi has no holds.
	
		patronStore.put("P3", new Patron("P3", "Temi", "6513333333", "123 St thomas blvd.", "456 st tommy street", "akin@stthomas.edu", "Summer17", t2));

//CREATE PATRON YAZEED - he has a hold and 2 classes
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
		
	
		Copy copy_4 = new Copy("copy#4",t3,yazeed, true, true, true,LocalDate.of(2014, 4, 1));
		copy_4.setChecked_out(true);
		inventory.put("copy#4", copy_4);
		
		yazeed.setCopyOut(copy_4);
		patronStore.put("P4",  yazeed);

//CREATE PATRON HEATHER - has no hold, no classes 

		Patron heather = new Patron("P2", "Heather");
		Copy copy_5 = new Copy("copy#5",t3,heather, true, true, true,LocalDate.of(2014, 4, 1));
		copy_5.checkIfOverdue();
		copy_5.setChecked_out(true);
		inventory.put("copy#5", copy_5);
		patronStore.put("P2", new Patron("P2", "Heather"));
		
	
	}


	
	//TEST THIS FUNCTION!!!!
	public void set_All_Patron_Hold()
	{
		for (int i = 0; i < (patronStore.size()); i++)
		{
			
			String id = "P";
			id = id.concat(""+(i));
			
			FakeDB database = new FakeDB();
			Map<String, Patron> patrons = database.getPatronStore();
		
			Patron p1 = patrons.get(id);
			p1.setHold();

			patrons.put(id, p1);
			
		}
	}
	//////////////////////////////////////////////////////////
	//	Getter & Setters
	//////////////////////////////////////////////////////////
	
	public static Patron getPatron(String patronID)
	{
		return patronStore.get(patronID);
	}
	
	public static Worker getWorker(String workerID)
	{
		return workerStore.get(workerID);
	}
	
	public static Map<String, Patron> getPatronStore() {
		return FakeDB.patronStore;
	}

	public static Map<String, Copy> getInventory() {
		return inventory;
	}

	public static void setPatronStore(Map<String, Patron> patronStore) {
		FakeDB.patronStore = patronStore;
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

	public static Map<String, Course> getClassStore() {
		return classStore;
	}
	public static Course getClass(String class_id) 
	{
		
		return classStore.get(class_id);
	}

	public static void setClassStore(Map<String, Course> classStore) {
		FakeDB.classStore = classStore;
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
	public void putClass(String class_ID, Course c)
	{
		this.classStore.put(class_ID, c);
	}

	

}
