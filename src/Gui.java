import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gui 
{


	public String outputNoManagerialAuthority()
	{
		String output = "";
		output.concat("Sorry, you do not have managerial authority for this action.");
		output.concat("\n You are a lowly, non-managerial human!   ");
		return output;
	}

	public String enterPatronID()
	{
		String patron_id = "";
		
		StdOut.println( "");
		StdOut.println( "--- Please enter the Patron's ID number ----");
		StdOut.println( "");
		StdOut.print( "    Enter 'P1' or 'P2' or 'P3' or 'P4' >> ");
		
		patron_id = StdIn.readLine();
	
		return patron_id;
	}
	
	public void outputWorkerID(String workerID)
	{
		String worker_id = "";
		StdOut.println("");
		StdOut.println( "--- Worker " + workerID + "  --------------------------" + "\n");
		
	}
	
	public String outputHolds(boolean has_holds, ArrayList<Copy> copiesOut)
	{
		String holds = " has no holds on account.";
		
		if (has_holds == true)
		{
		
			holds = (" HAS Holds on account for textbook(s):");
			holds = holds.concat("\n---------------------------------------------");
			
			for (int i = 0; i < copiesOut.size(); i++) 
			{
				if (copiesOut.get(i).isOverdue())
				{
					holds = holds.concat("" + copiesOut.get(i));

				}
			}	
		}
		else
			holds =  " has no holds on account.";

		return holds;
	}
	
	public String getCopyWithHolds(boolean has_holds, ArrayList<Copy> copiesOut)
	{
		String holds = "";
		Copy hold = null;
		
		if (has_holds == true)
		{
			for (int i = 0; i < copiesOut.size(); i++) 
			{
				if (copiesOut.get(i).isOverdue())
				{
					hold = copiesOut.get(i);
					holds = hold.getCopyID();
				}
			}	
		}
		
		else
			holds =  "";

		return holds;
	}
	

	public void printFinesFromCopysOut(Patron p)
	{
		
		double value = 0;
		
		for (int i = 0; i < p.getCopiesOut().size(); i++) 
		{
		
			Copy c = p.getCopiesOut().get(i);
		
			if (c.hasHold())
			{
				value = value + c.getPrice_if_lost();
	
				StdOut.println( "-------------------------");
				StdOut.println( "Patron Fines = $" + value);
				StdOut.println( "-------------------------");
			}
		}
	}
	public String payOutput() 
	{
		StdOut.println( "-------------------------");
		StdOut.println( "Does patron want to pay fines? " );
		StdOut.println( "Y - Yes");
		StdOut.println( "N - No");
		StdOut.print( ">>");
		
		Scanner scanner = new Scanner(System. in);
		
		 String c = scanner.next();
		 
	return c;
	}
	
	public double payAmountOutput() 
	{
		StdOut.print( "Please enter payment amount >>");
		
		double payment = StdIn.readDouble();
		 
	return payment;
	}
	
	public double calculate_change(double payment, double fines)
	{
		double change = payment - fines;
		
		StdOut.println( "Change = $ " + (change));
		
		return change;
	}

	public void outputMustPay() 
	{
		StdOut.println( "");
		System.out.println("Fines MUST be paid in order to continue checkout.");
		StdOut.println( "");
	}
	
	public void output_due_date(LocalDate date)
	{
		StdOut.println("");
		StdOut.println("All books are due on " + date);
		StdOut.println("");
	}

	public void outputPatronSchedule(Patron p) 
	{
		StdOut.println( "Patron Name: " + p.getPatron_name() + "\n" + "Patron classes: "+ p.getClasses().toString());
		StdOut.println( "\nPatrons Required Textbooks: " + p.getRequiredTextbooks() );
		StdOut.println( "");
	}

	
	public void outputPatronsCheckedOutBooks(Patron p) 
	{
		StdOut.println( "\nPatrons checkedOut books: " + p.getCopiesOut() );
		StdOut.println("");
	
	}
	
	public void outputPatronHoldsToWorkerFromLateCopies( Patron p, Boolean has_holds) 
	{
		
		StdOut.println( "" + p.getPatron_name() + this.outputHolds(has_holds, p.getCopiesOut()));
		StdOut.println("");
	}
	
	public void outputFinesAgain(double d)
	{
		StdOut.println( "");
		StdOut.println( "----------------------------");
		StdOut.println( "     Fines = $" + d + "    ");
		StdOut.println( "----------------------------");
	}
	
	public int firstMenuOutput()
	{
		int menu_selection = 0;
		
		StdOut.println( "");
		StdOut.println( "----------------------------------------");
		StdOut.println( "                MENU                    ");
		StdOut.println( "----------------------------------------");
		StdOut.println( "");
		StdOut.println( "--- 1 - Patron check out ---------------");
		StdOut.println( "--- 4 - Quit ---------------------------");
		StdOut.print( ">>");
		
		menu_selection = StdIn.readInt();

		return menu_selection;
	}
	
	public int menuOutput()
	{
		int menu_selection = 0;
		
		StdOut.println( "");
		StdOut.println( "----------------------------------------");
		StdOut.println( "                MENU                    ");
		StdOut.println( "----------------------------------------");
		StdOut.println( "");
		StdOut.println( "--- 1 - Patron check out ---------------");
		StdOut.println( "--- 2 - Patron check in ----------------");
		StdOut.println( "--- 3 - Place a hold on all patrons ----");
		StdOut.println( "--- 4 - Quit ---------------------------");
		StdOut.print( ">>");
		
		menu_selection = StdIn.readInt();

		return menu_selection;
	}
	
	public String checkout()
	{
		String id = "";
		
		StdOut.println( "");
		StdOut.println( "---------------------------------------------------------------------");
		StdOut.println( "                  Begin checkout - Please enter the copy ID");
		StdOut.println( "---------------------------------------------------------------------");
		StdOut.println( "");
		StdOut.println( "(You can enter 'copy#1','copy#2'...'copy#5' )");
		StdOut.print( " ");
		StdOut.print( "    Enter copy ID >> ");
		
		id = StdIn.readString();
		
		return id;
	}
	
	public String checkin()
	{
		String id = "";
		
		StdOut.println( "");
		StdOut.println( "---------------------------------------------------------------------");
		StdOut.println( "                  Begin check in - Please enter the copy ID");
		StdOut.println( "---------------------------------------------------------------------");
		StdOut.println( "");
		StdOut.println( "(You can enter 'copy#1','copy#2'...'copy#5' )");
		StdOut.print( " ");
		StdOut.print( "    Enter copy ID >> ");
		
		id = StdIn.readString();
		
		return id;
	}
	public void copyNotFound()
	{
		System.out.println("");
		System.out.println("Copy not found in arraylist");
		System.out.println("");
	}
	
	public String enterAnotherBook()
	{
		String anotherBook = null;
		
		StdOut.println( " ");
		StdOut.println( " Check in/out another book? 'Y' - Yes or 'N' - No");
		StdOut.print( ">> ");
		
		anotherBook = StdIn.readString();
		
		StdOut.println( "");
		
	return anotherBook;	
	}

	public void output_if_checkedOut(Copy c)
	{
		StdOut.print(c.getCopyID() + " is checkedOut already.");
	}
	
	public String report_CheckOut_States(Patron p)
	{
		String output = ("");
		
		//if (!(p.getPatron_name().equals(null)) || !(p.getPatron_ID().equals(null)))
		{
		
//		output = output.concat("   " + p.getPatron_name() + " " + p.getPatron_ID() + "\n");
		
		}
		
	//	if (!(p.getEmail().equals(null)) || !(p.getPhone().equals(null)))
		{
//			output = output.concat("Email: " + p.getEmail() + "Phone: " + p.getPhone() + "\n");
//			output = output.concat("\n");
		}
		
	//	if (p.getCopiesOut() != null)
		{
//			output = output.concat("" + p.checkHasHolds() + "\n");
//			output = output.concat("" + p.getCopiesOut() + "\n");
		}
		
		//outputPatronSchedule(p) ;
		
		return output;
	}

	public void enterOption() 
	{
		StdOut.println(" ");
		StdOut.println(" Please enter menu option 1 or 4.");
		StdOut.println(" ");
		
	}
	public void quit(String workerID) 
	{
		StdOut.println(" ");
		StdOut.println(workerID + " has exited the system.");
		StdOut.println(" ");
		
	}




		
	
}
