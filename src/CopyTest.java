import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class CopyTest {

	@Test
	public void testToString() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		assertEquals(("\nCOPY TITLE: " + "Programming" + "\n" + "COPY ID: " + "11"),
				("\nCOPY TITLE: " + tx.getText_title() + "\n" + "COPY ID: " + copy.getCopyID()));

	}

	 @Test
	 public void testResetDue_date() {
		 LocalDate today = LocalDate.now();
		 
	 Textbook tx = new Textbook();
	 tx.setText_title("Programming");
	 Copy copy = new Copy(tx, "11");
		 copy.resetDue_date(today);
	assertEquals(false , copy.isOverdue());
	
	 }

	@Test
	public void testCheckIfOverdue() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		copy.setOverdue(false);
		assertEquals(false, copy.checkIfOverdue());

	}

	@Test
	public void testIsChecked_out() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		copy.isChecked_out();
		assertEquals(false, copy.isChecked_out());
	}

	@Test
	public void testSetChecked_out() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		copy.setChecked_out(false);
		assertEquals(false, copy.isChecked_out());
	}

	@Test
	public void testIsOverdue() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		copy.isOverdue();
		assertEquals(false, copy.isOverdue());

	}

	@Test
	public void testSetOverdue() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		copy.setOverdue(false);
		assertEquals(false, copy.isOverdue());
	}

	@Test
	public void testHasHold() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		copy.hasHold();
		assertEquals(false, copy.hasHold());
	}

	@Test
	public void testSetHold() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		copy.setHold(true);
		assertEquals(true, copy.hasHold());
	}

	@Test
	public void testGetCheck_out_date() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		copy.getCheck_out_date();
		assertEquals(null, copy.getCheck_out_date());
	}

	@Test
	public void testSetCheck_out_date() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("11");
		copy.setCheck_out_date(null);
		assertEquals(null, copy.getCheck_out_date());
	}

	@Test
	public void testGetCopyID() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		assertEquals("11", copy.getCopyID());
	}

	@Test
	public void testSetCopyID() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("21");
		assertEquals("21", copy.getCopyID());
	}

	@Test
	public void testGetTitle() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		copy.setCopyID("21");
		assertEquals("21", copy.getCopyID());
	}

	 @Test
	 public void testGetOutTo() {
		 
		 Patron patron =new Patron("1234", "Yazeed");
		 Textbook tx = new Textbook();
		 tx.setText_title("Programming");
		 Copy copy = new Copy(tx, "11");
		 copy.setOutTo(patron);

	 assertEquals("1234" , copy.getOutTo().getPatron_ID());
	 }

	 @Test
	 public void testGetOutToID() {
		 Patron patron =new Patron("1234", "Yazeed");
		 Textbook tx = new Textbook();
		 tx.setText_title("Programming");
		 Copy copy = new Copy(tx, "11");
		 copy.setOutTo(patron);

	 assertEquals("1234" , copy.getOutToID());
	 }

	 @Test
	 public void testSetOutTo() {
		 Patron patron =new Patron("1234", "Yazeed");
		 Textbook tx = new Textbook();
		 tx.setText_title("Programming");
		 Copy copy = new Copy(tx, "11");
		 copy.setOutTo(patron);

	 assertEquals("1234" , copy.getOutTo().getPatron_ID());
	 }

	@Test
	public void testEqualsObject() {

		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		Copy copy = new Copy(tx, "11");
		Textbook rx = new Textbook();
		tx.setText_title("Programming");
		Copy co = new Copy(rx, "12");
		assertEquals(false, copy.equals(co));

	}

}
