package marinaSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
Person p = new Person ("firstName", "surname", "dob", "nationality");
Person q = new Person ("firstName", "surname", "dob", "nationality", "visaInfo");

	@Test
	public void getFirstNameTest() {
		assertEquals(p.getFirstName(), "firstName");
	}
	@Test
	public void setFirstNameTest(){
		p.setFirstName("TEST");
		assertEquals(p.getFirstName(), "TEST");
	}
	
	@Test
	public void getSurnameTest() {
		assertEquals(p.getSurname(), "surname");
	}
	@Test
	public void setSurnameTest(){
		p.setSurname("TEST");
		assertEquals(p.getSurname(), "TEST");
	}
	
	@Test
	public void getDobTest() {
		assertEquals(p.getDob(), "dob");
	}
	@Test
	public void setDobTest(){
		p.setDob("TEST");
		assertEquals(p.getDob(), "TEST");
	}
	
	@Test
	public void getNationalityTest() {
		assertEquals(p.getNationality(), "nationality");
	}
	@Test
	public void setNationalityTest(){
		p.setNationality("TEST");
		assertEquals(p.getNationality(), "TEST");
	}
	
	@Test
	public void getVisaInfoTest() {
		assertEquals(q.getVisaInfo(), "visaInfo");
	}
	@Test
	public void setVisaInfoTest(){
		q.setVisaInfo("TEST");
		assertEquals(q.getVisaInfo(), "TEST");
	}
}
