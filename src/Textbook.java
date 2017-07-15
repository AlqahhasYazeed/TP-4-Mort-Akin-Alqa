import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;

public class Textbook
{
	
	protected String text_title;
	protected String publisher_name;
	protected int class_ID;   //For sies 635, section 7 --> class_ID = 63507
	protected double price_if_lost;

	
	@SuppressWarnings("deprecation")
	protected
	//All Textbooks are currently set to have a due_date = August 30th, 2017
	LocalDate due_date = LocalDate.of(2017,8,30);
	//protected boolean overDue = false;

	public Textbook() 
	{
		text_title = "";
		publisher_name = "";
		class_ID = 0;
		price_if_lost = 0.0;
		
		//due_date = new LocalDate(0, 0, 0);
		
	}
	public Textbook(Textbook t2)
	{
		
		
		this.setText_title(t2.getText_title());
		this.publisher_name = t2.getPublisher_name();
		//this.num_in_inventory = t2.getNum_in_inventory();
		
		class_ID = t2.class_ID;
		
		price_if_lost = t2.getPrice_if_lost();
		
		//can textbook have an arraylist of copy objects??
		///ArrayList<Copy> inventory = 
		
		// inherits this due_date = LocalDate.of(2017,8,30);
	}
	
	public Textbook(String title, String nameOfPub,int num, int classID, double price, LocalDate date_is_due) 
	{
		this.text_title = title;
		this.publisher_name = nameOfPub;
		
		//this.num_in_inventory = num;
		this.class_ID = classID;
		
		this.price_if_lost = price;
		
		this.due_date = date_is_due;
		
	}
	
	public String toString() 
	{
		return this.getText_title();
	}
	
//	public void resetDue_date(LocalDate newDueDate)
//	{
//		this.due_date = newDueDate;
//		//recalculate this.overdue
//		if (checkIfOverdue())
//			this.overDue = true;
//		else
//			this.overDue = false;
//	}
	

	

	
	//Getter and Setters
	public String getText_title() 
	{
		return this.text_title;
	}
	
	public void setText_title(String text_title) 
	{
		this.text_title = text_title;
	}
	
	public String getPublisher_name() 
	{
		return publisher_name;
	}
	
	public void setPublisher_name(String publisher_name) 
	{
		this.publisher_name = publisher_name;
	}


	
	public int getClass_ID() 
	{
		return class_ID;
	}
	public void setClass_ID(int class_ID) 
	{
		this.class_ID = class_ID;
	}
	
	
	public double getPrice_if_lost() 
	{
		return price_if_lost;
	}
	
	public void setPrice_if_lost(double price_if_lost) 
	{
		this.price_if_lost = price_if_lost;
	}
	
	
	public LocalDate getDue_date() 
	{
		return due_date;
	}
	public void setDue_date(LocalDate due_date) 
	{
		this.due_date = due_date;
	}
	
	}
