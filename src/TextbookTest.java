import static org.junit.Assert.*;

import org.junit.Test;

public class TextbookTest {

//	@Test
//	public void testTextbook() {
//			}

//	@Test
//	public void testTextbookTextbook() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testTextbookStringStringIntIntDoubleLocalDate() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testToString() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		assertEquals("Programming", tx.getText_title());

	}

	@Test
	public void testGetText_title() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		tx.getText_title();
		assertEquals("Programming", tx.getText_title());

	}

	@Test
	public void testSetText_title() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		assertEquals("Programming", tx.getText_title());

	}

	@Test
	public void testGetPublisher_name() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		tx.setPublisher_name("yaz.com");
		tx.getPublisher_name();
		assertEquals("yaz.com", tx.getPublisher_name());

	}

	@Test
	public void testSetPublisher_name() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		tx.setPublisher_name("yaz.com");
		assertEquals("yaz.com", tx.getPublisher_name());
	}

	@Test
	public void testGetClass_ID() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		tx.setClass_ID(12);
		tx.getClass_ID();
		assertEquals(12, tx.getClass_ID());
	}

	@Test
	public void testSetClass_ID() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		tx.setClass_ID(12);
		assertEquals(12, tx.getClass_ID());
	}

	@Test
	public void testGetPrice_if_lost() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		tx.setPrice_if_lost(2.5);
		tx.getPrice_if_lost();
		assertEquals(2.5,2.5, tx.getPrice_if_lost());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetPrice_if_lost() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		tx.setPrice_if_lost(0);
		assertEquals(0,0, tx.getPrice_if_lost());
	}

	@Test
	public void testGetDue_date() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		tx.setDue_date(null);
		tx.getDue_date();
		assertEquals(null, tx.getDue_date());
	}

	@Test
	public void testSetDue_date() {
		Textbook tx = new Textbook();
		tx.setText_title("Programming");
		tx.setDue_date(null);
		assertEquals(null, tx.getDue_date());
	}

}
