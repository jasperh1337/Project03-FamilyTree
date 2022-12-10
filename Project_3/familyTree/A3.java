package familyTree;

import java.util.ArrayList;
import java.util.HashMap;

public class A3 {
	
	public static void displayTheFamilyTree(String person) {
		
		HashMap<String, PersonDetails> currentTree = FamilyTree.getTheTree();
		
		ArrayList<PersonDetails> children = currentTree.get(person).getChildren();
		
		System.out.println(currentTree.get(person));
		
		//printing the spouse
		//honestly i'm lost, not sure how to implement
		
		//printing the children
		int index = 0;
		while(index<children.size()) {
			ArrayList<PersonDetails> childArr = children.get(index).getChildren();
			
			//we have an indent " " to represent that these are children of the parent
			
			//the if statement is for printing the children of the children
			//i.e. Eleanor Roosevelt -> FDR jr. -> FDR jr. jr. 
			if(childArr.size() != 0) {
				System.out.println(" " + childArr.get(index));
				int count = 0;
				while(count < childArr.size()) {
					System.out.println(" " + childArr.get(count));
					count++;
				}
			}
			//just prints the child
			else {
				System.out.println(" " + children.get(index));
			}
			index++;
		}
	}
	
	//Can't figure out this function
	public void printSpouse(String name) {
		//To do 
	}
	
	public static void main(String[] args) {
		FamilyTree tree = new FamilyTree();
		
		// Details for Eleanor Roosevelt
		tree.addPerson("Anna Eleanor Roosevelt", 1884, 1962); // DOB, death
		tree.addEvent("Anna Eleanor Roosevelt",  1961,
				"1st Chair of the Presidential Commission on the Status of Women");
		tree.addEvent("Anna Eleanor Roosevelt",  1947,
				"1st United States Representative to the United Nations Commission on Human Rights");
		tree.addEvent("Anna Eleanor Roosevelt",  1946,
				"1st Chair of the United Nations Commission on Human Rights");
		
		// Details & marriage for Franklin Delano Roosevelt
		tree.addPerson("Franklin Delano Roosevelt", 1882, 1945); // DOB, death
		tree.addRelationship("Franklin Delano Roosevelt", "Anna Eleanor Roosevelt",
		"married");
		
		// Details & parents for Franklin Delano Roosevelt Jr.
		tree.addPerson("Franklin Delano Roosevelt Jr.", 1914);
		tree.addRelationship("Anna Eleanor Roosevelt", 
				"Franklin Delano Roosevelt Jr.", "parent");
		tree.addEvent("Franklin Delano Roosevelt Jr.", 1945, "Beat Hitler");
		
		// Details & parents for Something
		tree.addPerson("John Snow", 1916);
		tree.addRelationship("Anna Eleanor Roosevelt", "John Snow", "parent");
		tree.addEvent("John Snow", 2020, "Defeated Ninja");
		
		displayTheFamilyTree("Anna Eleanor Roosevelt");
	}
}
