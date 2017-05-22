package marinaSystem;

//STAGE 2 - Marina Object

import java.util.ArrayList;

public class Marina {
	
	private String marinaName;
	private String address;
	private double capacity;
	private ArrayList <Boat> docked = new ArrayList <Boat> (); //Stores moored boats for stage 4

	Marina (String marinaName, String address, double capacity){
		this.marinaName = marinaName;
		this.address = address;
		this.capacity = capacity;
	}
	
	public String getMarinaName(){
		return marinaName;
	}
	
	public void setMarinaName(String marinaName){
		this.marinaName = marinaName;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public double getCapacity(){
		return capacity;
	}
	
	public ArrayList<Boat> getDocked() {
		return docked;
	}

	public void setDocked(ArrayList<Boat> docked) {
		this.docked = docked;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	//STAGE 4 - adding Boat (instance b) to Marina 
	public void addBoat(Boat b){
		if(b.getCrew() == null & b.getCaptain() == null & b.getOwner() == null){	//if the instance of Boat has no crew assigned...
			System.out.println("Error: no crew assigned");							//...display error message
		}
		double currentVolume =+ b.getSize();							//increments the current volume of boats by the size of Boat			
		if(currentVolume > this.getCapacity()){							//if this results in the current volume exceeding the Marina's capacity...
			System.out.println("Error: Marina capacity exceeded");		//...display error message
		}
		
		if(b.getLocation() != null){																	//if the Boat already has a location set...
			System.out.println("Error: boat already docked in " + b.getLocation().getMarinaName());		//..display error message
		}else{
			docked.add(b);																	//no issues...
			b.setLocation(this);															//...set location to current Marina object
			System.out.println(b.getBoatName() + " docked in " + this.getMarinaName());		//display "Boat b docked in Marina m"
		}

	}

	
	
	
}
