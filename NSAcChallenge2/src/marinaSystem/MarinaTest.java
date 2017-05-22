package marinaSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarinaTest {
	
	Marina m = new Marina ("marinaName", "address", 10);

	@Test
	public void getMarinaNameTest() {
		assertEquals(m.getMarinaName(), "marinaName");
	}
	@Test
	public void setMarinaNameTest(){
		m.setMarinaName("Test");
		assertEquals(m.getMarinaName(), "Test");
	}

	@Test
	public void getAddressTest() {
		assertEquals(m.getAddress(), "address");
	}
	@Test
	public void setAddressTest(){
		m.setAddress("Test");
		assertEquals(m.getAddress(), "Test");
	}
	
	@Test
	public void getCapacityTest() {
		assertEquals(m.getCapacity(), 10);
	}
	@Test
	public void setCapacityTest(){
		m.setCapacity(20);
		assertEquals(m.getCapacity(), 20);
	}
}
