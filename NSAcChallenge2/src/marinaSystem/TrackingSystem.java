package marinaSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TrackingSystem {
	
	private static ArrayList <Marina> marinas = new ArrayList <Marina> ();
	private static ArrayList <Boat> boats = new ArrayList <Boat> ();
	private static ArrayList <Person> people = new ArrayList <Person> ();	
	
	public static void main (String args []){
		
		System.out.println(fileRead());
		
		assignCaptain(people.get(6) , boats.get(2));
		assignOwner(people.get(8) , boats.get(2));
		assignCrew(people.get(7) , boats.get(2));
		assignCrew(people.get(9) , boats.get(2));
		assignCrew(people.get(4) , boats.get(2));
		assignCrew(people.get(6) , boats.get(0));
		assignOwner(people.get(1) , boats.get(1));
		assignCaptain(people.get(5) , boats.get(3));
		assignOwner(people.get(3) , boats.get(3));
		assignOwner(people.get(0) , boats.get(3));
		
		placeBoat(boats.get(3) , marinas.get(1));
		placeBoat(boats.get(1) , marinas.get(0));
		placeBoat(boats.get(2) , marinas.get(0));
		placeBoat(boats.get(0) , marinas.get(1));
		
		oldestPerson(marinas.get(0));
		
		numberBoatsDocked(marinas.get(0));
	}
	
	//STAGE 5 - read text file, parse data and add to ArrayLists
	//reading data file and converting to string.
	public static String fileRead(){			
		String file = "";
		try{
			File f = new File ("C:\\Users\\Sam\\Desktop\\SamTurner\\NSAcademyCodeChallenge\\stage_5_input.txt");
			Scanner sc = new Scanner (f);
			
			while(sc.hasNextLine()){
				file +="@" + sc.nextLine();
			}
			sc.close();
			divideData(file);					//call parsing method
		} catch (FileNotFoundException e){	
		}return file;

	}
	
	//parsing and adding data to ArrayLists
	public static void divideData(String data){
		String [] object = data.replace("@@", "&").replace("|", "%").split("&");	//replacing characters to aid parsing, splitting each object and adding to a String Array

		String allMarinas = object[1];												//
		String [] individualMarina = allMarinas.split("%@");
		for (String x : individualMarina){
			String [] marinaData = x.split("@");
			String marinaName = marinaData[0];
			String address = marinaData[1];
			double capacity = Double.parseDouble(marinaData[2]);
			Marina m = new Marina (marinaName, address, capacity);
			marinas.add(m);
		}
			
		String allBoats = object [3];
		String [] individualBoats = allBoats.split("%@");
		for (String x : individualBoats){
			String [] boatData = x.split("@");
			String boatName = boatData[0];
			String countryOfOrigin = boatData[1];
			double size = Double.parseDouble(boatData[2]);
			Boat b = new Boat (boatName, countryOfOrigin, size);
			boats.add(b);
		}

		String allPeople = object [5];
		String [] individualPeople = allPeople.split("%@");
		for (String x : individualPeople){
			String [] peopleData = x.split("@");
			String fullName = peopleData[0];
			String[] names = fullName.split(" ");
			String firstName = names[0];
			String surname = names[1];
			String dob = peopleData[1];
			String nationality = peopleData[2];
			String visaInfo = "";
			if(peopleData.length == 3){
				Person p = new Person (firstName, surname, dob, nationality);
				people.add(p);
			}else{
				visaInfo = peopleData[3];
				Person q = new Person (firstName, surname, dob, nationality, visaInfo);
				people.add(q);
			}	
		}
	}
	
	//STAGE 6 - assigning relationships between Marinas, Boats and People
	
	public static void assignCaptain(Person p, Boat b){
		b.addCaptain(p);
	}
	
	public static void assignCrew(Person p , Boat b){
		b.addCrew(p);
	}
	
	public static void assignOwner(Person p , Boat b){
		b.addOwner(p);
	}
	
	public static void placeBoat(Boat b, Marina m){
		m.addBoat(b);
	}
	
	//STAGE 7 - calculations
	
	//finding oldest person in given marina
	public static void oldestPerson (Marina m){
		LocalDate local = LocalDate.now();
		int age = 0;
		String name ="";
		ArrayList<Integer> ages = new ArrayList <Integer>();
		ages.add(0);
		for(Boat b : m.getDocked()){
			for(Person p : b.getOccupant()){
				
				String dob = p.getDob();
				String [] dates = dob.split("/");
				int day = Integer.parseInt(dates[0]);
				int month = Integer.parseInt(dates[1]);
				int year = Integer.parseInt(dates[2]);
				LocalDate birthday = LocalDate.of(year, month, day);
				System.out.println(birthday);
				age = (Period.between(birthday, local).getYears())*365 + (Period.between(birthday, local).getMonths())*30 + Period.between(birthday, local).getDays();
				if(age > Collections.max(ages)){
					ages.add(age);
					name = p.getFirstName() + " " + p.getSurname();
				}
			}
		}
		System.out.println(name);	
	}
	
	//counting number of boats moored in given marina
	public static int numberBoatsDocked(Marina m){
		int number = m.getDocked().size();
		System.out.println(number);
		return number;
	}
}
