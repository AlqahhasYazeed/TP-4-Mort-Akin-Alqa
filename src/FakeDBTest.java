	import static org.junit.Assert.*;

	import java.time.LocalDate;
	import java.util.Map;

	import org.junit.Test;

	public class FakeDBTest 
	{

//	@Test
//	public void testGetPatronStore() 
//	{
//		
//
//		
//		Textbook t1 = new Textbook("Technical Communications", "Apress",32, 60501, 75.00, LocalDate.now());
//		Textbook t2  = new Textbook("Designing SQl", "Wiley",22, 63002, 123.55, LocalDate.now());
//		Patron Yazeed = new Patron("P4", "Yazeed", "6514444444", "129 St thomas blvd.", "789 st tommy street", "eng@stthomas.edu", "Summer17", t1);
//		
//		Map<String,Patron> patronStore;
//		
//		patronStore = new HashMap<String,Patron>();	
//		patronStore.put("P1", new Patron("P1", "Eric"));
//		//There's an error with this one. It wont set to have a hold.
//		patronStore.put("P2", new Patron("P2", "Heather"));
//		patronStore.put("P3", new Patron("P3", "Temi", "6513333333", "123 St thomas blvd.", "456 st tommy street", "akin@stthomas.edu", "Summer17", t2));
//		patronStore.put("P4", Yazeed);
//		
//        //1. Test size
//		assertTrue(patronStore.size()==4);
//		
//		
//		assertTrue(patronStore.containsKey("P1") && patronStore.get("Eric") != null);
//		assertTrue(patronStore.containsKey("P2") && patronStore.get("Heather") != null);
//		assertTrue(patronStore.containsKey("P3") && patronStore.get("Temi") != null);
//		assertTrue(patronStore.containsKey("P4") && patronStore.get("Yazeed") != null);
		
		


//        //3. Test map entry, best!
//        assertThat(patronStore, IsMapContaining.hasEntry("n", "node"));
//
//        assertThat(patronStore, not(IsMapContaining.hasEntry("r", "ruby")));
//
//        //4. Test map key
//        assertThat(patronStore, IsMapContaining.hasKey("j"));
//
//        //5. Test map value
//        assertThat(patronStore, IsMapContaining.hasValue("node"));
//	}



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

//		@Test
//		public void testGetClassString() {
//			Patron pat = new Patron();
//			pat.setPatron_ID("1212");
//			pat.setPatron_name("yaz");
//			FakeDB fa = new FakeDB();
//			assertEquals("60501" , fa.getClass("60501").getClass_ID());
//		}

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
//		@Test
//		public void testPutPatron() {
//			Patron pat = new Patron();
//			pat.setPatron_ID("1212");
//			pat.setPatron_name("yaz");
//			FakeDB fa = new FakeDB();
//			FakeDB.putPatron(pat);
//			assertEquals("yaz" , FakeDB.getPatron("1212").getPatron_name());
//			}
	//
//		@Test
//		public void testGetCopy() {
//			//"Technical Communications"
//			FakeDB fa = new FakeDB();
//			assertEquals("Designing SQl" , fa.getCopy("copy#1").getText_title());
//		}
	//
//		@Test
//		public void testPutCopy() 
//		{
//			FakeDB fa = new FakeDB();
//			Textbook tx = new Textbook();
//			 tx.setText_title("Programming");
//			 Copy copy = new Copy(tx, "11");
//			fa.putCopy("360", copy);
//			assertEquals("Programming" , fa.getCopy("360").getText_title());
//		}

		@Test
		public void testPutClass() {
			FakeDB fa = new FakeDB();
			Textbook t1 = new Textbook();
			Course c1 = new Course("60511","Programming","Summer2017",LocalDate.now(),LocalDate.now(),10,"SIES", true,t1);
			fa.putClass("60511", c1);
			assertEquals("Programming" , fa.getClass("60511").getClass_name());
		}
	//
	}
