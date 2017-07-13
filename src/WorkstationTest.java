import static org.junit.Assert.*;
//
import org.junit.Test;
//
public class WorkstationTest {
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
//	@Test
//	public void testGetRequiredTextbookList() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testStartCheckout() {
		
		Workstation w=new Workstation("1234");
		w.startCheckout("1234");
		//assertEquals( "P0", w.patron_ID_entered);
	}
//
//	@Test
//	public void testCheckOutLoop() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEndCheckout() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testMain() {
//		fail("Not yet implemented");
//	}
//
}
