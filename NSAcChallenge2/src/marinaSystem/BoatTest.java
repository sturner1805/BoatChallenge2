package marinaSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoatTest {
	Boat b = new Boat("boatName", "countryOfOrigin", 1);
	
	@Test
	public void getBoatNameTest() {
		assertEquals(b.getBoatName(), "boatName");
	}
	@Test
	public void setBoatNameTest(){
		b.setBoatName("TEST");
		assertEquals(b.getBoatName(), "TEST");
	}
	
	@Test
	public void getCountryOfOriginTest() {
		assertEquals(b.getCountryOfOrigin(), "countryOfOrigin");
	}
	@Test
	public void setCountryOfOriginTest(){
		b.setCountryOfOrigin("TEST");
		assertEquals(b.getCountryOfOrigin(), "TEST");
	}
	
	@Test
	public void getSizeTest() {
		assertEquals(b.getSize(), 1, 0.01);
	}
	@Test
	public void setSizeTest(){
		b.setSize(110);
		assertEquals(b.getSize(), 110, 0.01);
	}
	
	Person test = new Person ("sam", "turner", "18May94", "British");
	Person test2 = new Person ("sam", "turner", "18May94", "British");
	
	@Test
	public void addCrewTest(){
		b.addCrew(test);
		for(Person p : b.crew){
			
		}
		assertEquals(b.getCrew(), test);
	}
	
	@Test
	public void addCaptainAlreadyCrewTest(){
		b.addCrew(test);
		b.addCaptain(test);
		assertEquals(b.getCaptain() , test);
	}
	
	@Test
	public void addCaptainAlreadyCaptainTest(){
		b.addCaptain(test2);
		b.addCaptain(test);
		assertFalse(b.getCaptain().equals(test));
	}


}
