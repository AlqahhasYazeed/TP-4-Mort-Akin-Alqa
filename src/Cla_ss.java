import java.time.LocalDate;
import java.util.ArrayList;


public class Cla_ss 
{

	String class_ID;
	String class_name;
	String term;
	
	LocalDate start_date_for_term;
	LocalDate end_date_for_term;
	
	int max_num_students;
	String department;
	boolean active_nxt_semester;

	ArrayList<Textbook> books;

	
	
	public Cla_ss() 
	{
		
		this.class_ID = "";
		this.class_name = "";
		this.term = "";
		
		this.start_date_for_term = LocalDate.of(2017,6,3);
		this.end_date_for_term = LocalDate.of(2017,7,15);
		
		max_num_students = 30;
		department = "SIES";
		active_nxt_semester = true;
		
		books = new ArrayList<Textbook>();
		
		
	}
	
	public Cla_ss(String id,String name,String term,LocalDate start_date,LocalDate end_date,int max_num,String dept, boolean nxt_sem, Textbook text )
	{
		
		
		this.class_ID = id;
		this.class_name =  name;
		this.term = term;
		
		this.start_date_for_term = start_date;
		this.end_date_for_term = end_date;
		
		this.max_num_students = max_num;
		this.department = dept;
		this.active_nxt_semester = nxt_sem;
		
		
		this.books = new ArrayList<Textbook>();
		this.books.add(text);
	
		
	}
	public String toString()
	{
		String classString = "";
		classString = "" + this.class_name;
		
		return classString;
	}
	public void addBook(Textbook t)
	{
		this.books.add(t);
	}
	public void getBooks()
	{
		for(int i = 0; i < books.size(); i++)
		{
			System.out.println(""+ this.books.get(i) + " ");
		}
	}
	
	
	public int bookCount()
	{
		int numberOfBooksForClass = 0;
		numberOfBooksForClass = this.books.size();
			
	return numberOfBooksForClass;
	}
	
	public String getClass_ID() {
		return class_ID;
	}
	public void setClass_ID(String class_ID) {
		this.class_ID = class_ID;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public LocalDate getStart_date_for_term() {
		return start_date_for_term;
	}
	public void setStart_date_for_term(LocalDate start_date_for_term) {
		this.start_date_for_term = start_date_for_term;
	}
	public LocalDate getEnd_date_for_term() {
		return end_date_for_term;
	}
	public void setEnd_date_for_term(LocalDate end_date_for_term) {
		this.end_date_for_term = end_date_for_term;
	}
	public int getMax_num_students() {
		return max_num_students;
	}
	public void setMax_num_students(int max_num_students) {
		this.max_num_students = max_num_students;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public boolean isActive_nxt_semester() {
		return active_nxt_semester;
	}
	public void setActive_nxt_semester(boolean active_nxt_semester) {
		this.active_nxt_semester = active_nxt_semester;
	}

	
	

}
