package marinaSystem;

//STAGE 3 - Boat object

import java.util.ArrayList;

public class Boat implements Vehicle{
	
	private String boatName;
	private String countryOfOrigin;
	private double size;
	private ArrayList <Person> occupant = new ArrayList <Person>();	//list of all occupants (ie all crew, owners and captain) for stage 6
	private ArrayList <Person> crew = new ArrayList<Person>();		//list all crew for stage 6
	private ArrayList <Person> owner = new ArrayList<Person>();		//list all owners for stage 6
	private Person captain;											//sets captain for stage 6
	private Marina location;										//sets location for stage 4
	
	public String getBoatName(){
		return boatName;
	}
	
	public void setBoatName(String boatName){
		this.boatName = boatName;
	}
	
	public String getCountryOfOrigin(){
		return countryOfOrigin;
	}
	
	public void setCountryOfOrigin(String countryOfOrigin){
		this.countryOfOrigin = countryOfOrigin;
	}
	
	public double getSize(){
		return size;
	}
	
	public void setSize(double size){
		this.size = size;
	}
	public ArrayList<Person> getOccupant() {
		return occupant;
	}
	
	public void setOccupant(ArrayList<Person> occupant) {
			this.occupant = occupant;
	}

	public ArrayList<Person> getCrew() {
		return crew;
	}

	public void setCrew(ArrayList<Person> crew) {
		this.crew = crew;
	}

	public ArrayList<Person> getOwner() {
		return owner;
	}

	public void setOwner(ArrayList<Person> owner) {
		this.owner = owner;
	}

	public Person getCaptain() {
		return captain;
	}
	public void setCaptain(Person captain) {
			this.captain = captain;
	}
	
	public Marina getLocation() {
		return location;
	}

	public void setLocation(Marina location) {
		this.location = location;
	}

	public void addCrew(Person p){
		occupant.add(p);
		crew.add(p);
		System.out.println(p.getFirstName() + " " + p.getSurname() + " registered as crew of " + this.getBoatName());
	}
	
	public void removeCrew(Person p){
		crew.remove(p);
		occupant.remove(p);
	}
	
	public void addOwner(Person p){
		occupant.add(p);
		owner.add(p);
		System.out.println(p.getFirstName() + " " + p.getSurname() + " registered as owner of " + this.getBoatName());
	}
	
	public void removeOwner(Person p){
		owner.remove(p);
		occupant.remove(p);
	}
	
	public void addCaptain(Person p){
		for (Person x : crew){
			if (p.equals(x)){
				System.out.println("Error: already registered as crew");
				return;
			}
		}if(captain != null){
				System.out.println("Error: captain already assigned");
		}else{
			occupant.add(p);
			captain = p;
			System.out.println(p.getFirstName() + " " + p.getSurname() + " registered as Captain of " + this.getBoatName());
		}
		
	}
	
	public void removeCaptain(Person p){
		captain = null;
		occupant.remove(p);
	}
	
	
	
	Boat(String boatName, String countryOfOrigin, double size){
		this.boatName = boatName;
		this.countryOfOrigin = countryOfOrigin;
		this.size = size;
	}
	
	
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void accelerate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deccelerate() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
