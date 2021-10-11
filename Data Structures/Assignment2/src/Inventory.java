/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 2
 * October-10-2021
 * Inventory class  inventory for food items
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Inventory class storing food item in inventory
 *
 */
class Inventory {	
	private ArrayList<FoodItem> inventory; //array for storing food item inventory
	private final int NUM = 20; //array size
	private int numItems=0; //user entered items' number
	/**
	 * initialize the array
	 */
	Inventory(){
		inventory = new ArrayList<FoodItem>(NUM);
	} //Inventory end
	/**
	 * display of inventory
	 */
	public String toString() {
		String result = "";

		if(numItems == 0) { //if user input anything yet
			result = "";
		} else {
			for(int i=0; i < numItems; i++) {
				if(inventory.get(i) != null) {
					result += inventory.get(i).toString();
				} //if end
			} //for end
		} //if-else end
		return result;
	} //toString end
	/**
	 * adding item to inventory array list and to file
	 */
	public boolean addItem(Scanner sc, boolean fromFile) {
		if(numItems == 20) {
			System.out.println("Inventory is full now");
			return false;
		} //if end
		boolean b = false;
		FoodItem item = null;
		while(!b) { //while true
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
			String type = sc.next();
			if(type.equals("f") || type.equals("v") || type.equals("p")) {
				switch(type) { //type of the product
				case "f": //if fruit
					item = new Fruit();	
					break;
				case "v": //if vegetable
					item = new Vegetable();	
					break;
				case "p": //if preserve
					item = new Preserve();	
					break;
				default:
					System.out.println("Invalid entry");
					break;
				} //switch end		
				b = true; //break while loop
			} else {
				System.out.println("Invalid entry");
				b = false;
			} //if-else end
		} //while end
		if(item.inputCode(sc, item)) { //if input code valid = true
			if(alreadyExists(item)==-1) { //send the object to another method
				if(item.addItem(sc)) { //if adding item succeed
					inventory.add(numItems, item); //put object to array
					numItems++;
					return true;
				} //if end
				return false;
			} else {
				System.out.println("Item code already exists");
				return false;
			} //if-else end	
		} //if end
		return true;
	} //addItem end
	/**
	 * scan user input item for search, and search in inventory
	 * @param sc
	 */
	public void searchForItem(Scanner sc) {
		System.out.print("Enter the code for the item: ");
		int searchItem = sc.nextInt();
		
		
	}
	/**
	 * 
	 * @param sc
	 */
	public void saveToFile(Scanner sc) {
		System.out.print("Enter the filename to save to: ");
		String filename = sc.nextLine();
	}
	/**
	 * read from file
	 * @param sc
	 */
	public void readFromFile(Scanner sc) throws IOException {
		System.out.print("Enter the filename to read from: ");
		File file = new File(sc.nextLine());
		

		if(file.exists()) { //if file exists = true
			System.out.println("File name already exist. ");
		} //if end

	} //readFromFile
	/**
	 * return index of food item array (inventory)
	 * check if item code already exists or not - during add item
	 * @param item FoodItem from updateQuantity method
	 */
	int alreadyExists(FoodItem item) {
		for(int i=0;i < numItems;i++) {
			if (inventory.get(i).isEuqal(item)) { 
				return i;
			} //if-else end
		} //for end
		return -1; //not input that code yet
	} //alreadyExists end
	/**
	 * read item code to update quantity in inventory array.
	 * bs = true = buying
	 * bs = false = selling
	 */
	boolean updateQuantity(Scanner sc, boolean bs) {
		if(numItems == 0) { //if user input anything yet
			return false;
		} //if end
		FoodItem fi = new FoodItem();
		fi.inputCode(sc);
		int index = alreadyExists(fi); //check the code is already exists or not
		if(index != -1) {
			while(true) {
				String buysell = bs?"buy":"sell"; //if bs is true buy, false sell
				System.out.print("Enter valid quantity to " + buysell + ": ");
				if(sc.hasNextInt()) { //if valid quantity
					int amount = sc.nextInt();
					if(amount > 0 && amount <= inventory.get(index).getQuantity()) { //if right amount
						return inventory.get(index).updateItem(bs?amount:amount*-1); //if buy send amount, sell send //return the amount is valid or not
					} else {
						System.out.println("Invalid quantity...");
						return false;
					} //if-else end
				} else { //if has index = code already exists
					System.out.printf("Error...could not %s item\n", buysell);
				} //if-else end
			} //while end
		} else if(index == -1) {
			System.out.println("Code not found in inventory...");
		} //if-else end
		return false;
	} //updateQuantity
} //Inventory class end
