package familyTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PersonDetails {

	private String name = "";
	private int birthYear = 0;
	private int deathYear = 0;
	private ArrayList<PersonDetails> marriage = new ArrayList<PersonDetails>();
	private ArrayList<PersonDetails> children = new ArrayList<PersonDetails>();
	//Using a HashMap to store events as they have associated dates with the event to make it simpler to use
	private HashMap<Integer, String> events = new HashMap<>(); 
	
	public PersonDetails(String name, int birthYear, int deathYear) {
		this.name = name;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
	}
	
	public PersonDetails(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDeathYear() {
		return deathYear;
	}
	
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public HashMap<Integer,String> getEvents(){
		return events;
	}
	
	public String sortEvent(HashMap<Integer, String> events) {
		if(events == null || events.size() == 0){ //no events base case, return nothing
			return "";
		}
		else { 
			//Creating an array list by using the keySet function so that we can sort by key
			//reference: Baeldung.com/java-hashmap-sort
			ArrayList<Integer> sortedEventKeys = new ArrayList<Integer>(events.keySet());
			Collections.sort(sortedEventKeys);
			
			//Using an empty string to store the sorted events
			String eventsList = "";
			for (Integer date : sortedEventKeys) {
				eventsList += "; " + date.toString() + ": " + events.get(date) + "\n";
			}
			return eventsList;
		}
	}	
	
	public String printMarriage() {
		if(marriage == null || marriage.size() == 0) { //no marriage base case so we return empty
			return "";
		}
		else { //indicates there is a marriage so we print them out
			String s = "";
			//count has +1 so that we can run the while loop otherwise they're equal
			int count = marriage.size()+1; 
			while(count > marriage.size()) {
				s += " m. " + marriage.get(count).getName();
				count--;
			}	
			return s;
		}
	}
	
	public ArrayList<PersonDetails> getMarriage(){
		return marriage;
	}
	
	public void setMarriage(PersonDetails partner) {
		this.marriage.add(partner);
	}
	
	public ArrayList<PersonDetails> getChildren(){
		return children;
	}
	
	public void setChildren(PersonDetails thechild){
		this.children.add(thechild);
	}
	
	public void setEvent(int date, String event) {
		this.events.put(date, event);
		
	}
	
	public String toString() {
		if(deathYear == 0) {
			return name + " (" + birthYear + " - " + ")" + sortEvent(events) + printMarriage();
		}
		else {
			return name + " (" + birthYear + " - " + deathYear + " )" + sortEvent(events) + printMarriage();
		}
	}

}
