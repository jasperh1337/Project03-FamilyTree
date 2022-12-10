package familyTree;

import java.util.HashMap;

public class FamilyTree {

	//constructor
	private static HashMap<String, PersonDetails> theTree = new HashMap<>();
	
	
	//order of name, birth year, death year by given code then put into the hashmap
	public void addPerson(String name, int birthYear, int deathYear) {
		PersonDetails person = new PersonDetails(name, birthYear, deathYear);
		theTree.put(name, person);
	}
	
	//same as above but indicates they're alive 
	public void addPerson(String name, int birthYear) {
		PersonDetails person = new PersonDetails(name, birthYear);
		theTree.put(name, person);
	}
	
	//order of name, date, event by the given codes
	public void addEvent(String name, int date, String event) {
		if(name.equals(theTree.get(name).getName())){
			theTree.get(name).setEvent(date, event);
		}
	}
	
	/*
	 * Functions should be self explanatory
	 * first if statement is used to check if person 1 is in the hashmap or not otherwise we print the error message
	 */
	public void addRelationship(String p1, String p2, String relation) {
		if(p1.equals(theTree.get(p1).getName())) {
			if(relation == "married") {
				theTree.get(p1).setMarriage(theTree.get(p2));
			}
			else if(relation == "parent") {
				theTree.get(p1).setChildren(theTree.get(p2));
			}
			
			else {
				System.out.println("This relationship input is not valid.");
			}
		}
		else {
			System.out.println("Person 1 or Person 2 is not in the hashmap.");
		}
	}

	/*
	 * Functions to connect the FamilyTree.java to A3
	 */
	public static HashMap<String, PersonDetails> getTheTree() {
		return theTree;
	}

	public void setTheTree(HashMap<String, PersonDetails> theTree) {
		FamilyTree.theTree = theTree;
	}	
}
