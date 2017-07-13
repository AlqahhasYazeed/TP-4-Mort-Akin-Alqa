import static org.junit.Assert.*;

import org.junit.Test;

public class WorkerTest {

	@Test
	public void testGetWorker_ID() {
		Worker wo = new Worker();
		wo.setWorker_ID("1212");
		wo.getWorker_ID();
		assertEquals("1212", wo.getWorker_ID());
	}

	@Test
	public void testSetWorker_ID() {
		Worker wo = new Worker();
		wo.setWorker_ID("1212");
		assertEquals("1212", wo.getWorker_ID());
	}

//	@Test
//	public void testWorker() {
//		
//	}

}
