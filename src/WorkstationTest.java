import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class WorkstationTest 
{
	
	//Test the loop methods in Workstation in order to write.

	@Test
	public void testIfHoldsOnPatrons() 
	{
		//This instance variable of the Patron class should only be true
		//for Yazeed, patron_4.
		//private Boolean patron_hold = false;
		
		FakeDB db = new FakeDB();
		
		Patron Patron_1 = new Patron();
		Patron Patron_2 = new Patron();
		Patron Patron_3 = new Patron();
		Patron Patron_4 = new Patron();
		
		Patron_1 = db.getPatron("P1");
		Patron_2 = db.getPatron("P2");
		Patron_3 = db.getPatron("P3");
		Patron_4 = db.getPatron("P4");
		
		//only patron_4 should start with a hold
		assertTrue(Patron_4.checkHasHolds());
		
		assertFalse(Patron_1.checkHasHolds());
		assertFalse(Patron_2.checkHasHolds());
		assertFalse(Patron_3.checkHasHolds());
		
	}
	@Test
	public void testIfHoldsOnCopies() 
	{
		//This instance variable of the Patron class should only be true
		//for Yazeed, patron_4.
		//private Boolean patron_hold = false;
		
		FakeDB db = new FakeDB();
		
		Patron Patron_1 = new Patron();
		Patron Patron_2 = new Patron();
		Patron Patron_3 = new Patron();
		Patron Patron_4 = new Patron();
		
		Patron_1 = db.getPatron("P1");
		Patron_2 = db.getPatron("P2");
		Patron_3 = db.getPatron("P3");
		Patron_4 = db.getPatron("P4");
		
		ArrayList<Copy> copies_1 = new ArrayList<Copy>();
		
		copies_1 = Patron_1.getCopiesOut();
		
		
		// look for overdue copies
		//assertTrue(copies_1.checkIfOverdue());
		
		assertFalse(Patron_1.checkHasHolds());
		assertFalse(Patron_2.checkHasHolds());
		assertFalse(Patron_3.checkHasHolds());
		
	}
	

	//
		@Test
		public void testWorkstation() {
			Workstation w=new Workstation();
			
			assertEquals( "P0", w.patron_ID_entered);
		}
		
	//
		@Test
		public void testWorkstationString() {
			
			Workstation w=new Workstation("1234");
			assertEquals( "1234", w.patron_ID_entered);
		}
	// Not implemented yet originally to be tested
//		@Test
//		public void testGetRequiredTextbookList() {
//			fail("Not yet implemented");
//		}
	//
		@Test
		public void testStartCheckout() {
			
			Workstation w=new Workstation("1234");
			w.startCheckout("1234");
			//assertEquals( "P0", w.patron_ID_entered);
		}
	//
//		@Test
//		public void testCheckOutLoop() {
//			fail("Not yet implemented");
//		}
	//
//		@Test
//		public void testEndCheckout() {
//			fail("Not yet implemented");
//		}
	//
//		@Test
//		public void testMain() {
//			fail("Not yet implemented");
//		}
	//
	}
	
