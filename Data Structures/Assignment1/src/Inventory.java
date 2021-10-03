/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * Inventory class : extends FoodItem class, inventory for food items
 */

import java.util.Scanner;

class Inventory {	
	private FoodItem[] inventory; //array for storing food item inventory
	private final int NUM = 20; //array size
	private int numItems=0; //user entered items' number
	/**
	 * initialize the array
	 */
	Inventory(){
		inventory = new FoodItem[NUM];
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
				if(inventory[i] != null) {
					result += inventory[i].toString();
				} //if end
			} //for end
		} //if-else end
		return result;
	} //toString end
	/**
	 * adding item to inventory array
	 */
	boolean addItem(Scanner sc) {
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
					item = new FoodItem();  
					break;
				} //switch end		
				b = true; //break while loop
			} else {
				System.out.println("Invalid entry");
				sc.next();
				b = false;
			} //if-else end
		} //while end
		if(item.inputCode(sc, item)) { //if input code valid = true
			if(alreadyExists(item)==-1) { //send the object to another method
				if(item.addItem(sc)) { //if adding item succeed
					inventory[numItems] = item; //put object to array
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
	 * return index of food item array (inventory)
	 * check if item code already exists or not - during add item
	 * @param item FoodItem from updateQuantity method
	 */
	int alreadyExists(FoodItem item) {
		for(int i=0;i < numItems;i++) {
			if (inventory[i].isEuqal(item)) { //if same true //null pointer error******************************
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
			String buysell = bs?"buy":"sell"; //if bs is true buy, false sell
			System.out.print("Enter valid quantity to " + buysell + ": ");
			if(sc.hasNextInt()) { //if valid quantity
				int amount = sc.nextInt();
				if(amount > 0) { //if right amount
					return inventory[index].updateItem(bs?amount:amount*-1); //if buy send amount, sell send //return the amount is valid or not
				} else {
					System.out.println("Invalid quantity...");
				} //if-else end

			} else { //if has index = code already exists
				System.out.printf("Error...could not %s item\n", buysell);
			} //if-else end
		} else {
			System.out.println("Code not found in inventory...");
		} //if-else end
		return false;
	} //updateQuantity
} //Inventory class end
