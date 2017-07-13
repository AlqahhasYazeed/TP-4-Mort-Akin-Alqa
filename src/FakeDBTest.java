import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Map;

import org.junit.Test;

public class FakeDBTest {

	@Test
	public void testGetPatron() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.setPatronStore(null);
		assertEquals(null , FakeDB.getPatronStore());
	}

	@Test
	public void testGetPatronStore() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.setPatronStore(null); 
		FakeDB.getPatronStore(); 
		assertEquals(null , FakeDB.getPatronStore());
	}

	@Test
	public void testSetPatronStore() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.setPatronStore(null); 
		assertEquals(null , FakeDB.getPatronStore());	
		}

	@Test
	public void testGetInventory() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.setInventory(null); 
		FakeDB.getInventory(); 
		assertEquals(null , FakeDB.getInventory());	
		}

	@Test
	public void testSetInventory() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.setInventory(null); 
		assertEquals(null , FakeDB.getInventory());
	}

	@Test
	public void testGetTextbookStore() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.setTextbookStore(null);
		FakeDB.getTextbookStore(); 
		assertEquals(null , FakeDB.getTextbookStore());
		}

	@Test
	public void testSetTextbookStore() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.setTextbookStore(null);
		assertEquals(null , FakeDB.getTextbookStore());
	}

	@Test
	public void testGetClassStore() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.setClassStore(null);
		FakeDB.getClassStore();
		assertEquals(null , FakeDB.getClassStore());
	}

	@Test
	public void testGetClassString() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		assertEquals("60501" , fa.getClass("60501").getClass_ID());
	}

	@Test
	public void testSetClassStore() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.setClassStore(null);
		assertEquals(null , FakeDB.getClassStore());
		}

	/*@Test
	public void testGetText() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		fa.getText("60501");
		assertEquals(null , FakeDB.getClassStore());
	}*/
	
//
	@Test
	public void testPutPatron() {
		Patron pat = new Patron();
		pat.setPatron_ID("1212");
		pat.setPatron_name("yaz");
		FakeDB fa = new FakeDB();
		FakeDB.putPatron(pat);
		assertEquals("yaz" , FakeDB.getPatron("1212").getPatron_name());
		}
//
	@Test
	public void testGetCopy() {
		//"Technical Communications"
		FakeDB fa = new FakeDB();
		assertEquals("Designing SQl" , fa.getCopy("copy#1").getText_title());
	}
//
	@Test
	public void testPutCopy() {
		FakeDB fa = new FakeDB();
		Textbook tx = new Textbook();
		 tx.setText_title("Programming");
		 Copy copy = new Copy(tx, "11");
		fa.putCopy("360", copy);
		assertEquals("Programming" , fa.getCopy("360").getText_title());
	}

	@Test
	public void testPutClass() {
		FakeDB fa = new FakeDB();
		Textbook t1 = new Textbook();
		Cla_ss c1 = new Cla_ss("60511","Programming","Summer2017",LocalDate.now(),LocalDate.now(),10,"SIES", true,t1);
		fa.putClass("60511", c1);
		assertEquals("Programming" , fa.getClass("60511").getClass_name());
	}
//
}
