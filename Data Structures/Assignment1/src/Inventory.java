/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * Inventory class : extends FoodItem class, inventory for food items
 */

import java.util.Scanner;
import java.util.regex.Pattern;

class Inventory extends Assign1{	
	private FoodItem[] inventory; //array for storing food item inventory
	private final int NUM = 20; //array size

	/**
	 * 
	 */
	Inventory(){
		inventory = new FoodItem[NUM];
	} //Inventory end
	/**
	 * display of inventory
	 */
	public String toString() {
		StringBuilder a = new StringBuilder();
		for(int i=0; i < inventory.length; i++) {
			if(inventory[i] != null) {
				a.append(inventory[i].toString());
			} else {
				a.append("\n");
				break;
			} //if-else end			
		} //for end
		return a.toString();
	} //toString end
	/**
	 * adding item to inventory array
	 */
	boolean addItem(Scanner sc) {
		boolean b = false;
		FoodItem item = null;
		while(!b) { //while true
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
			if(sc.hasNext(Pattern.compile("[fvp]"))) { //error?
				String type = sc.next();
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
				b = true;
			} else {
				System.out.println("Invalid entry");
				sc.next(); //remove newline
				b = false;
			} //if-else end
		} //while end

		if(item.addItem(sc)) { //if adding item succeed
			if(alreadyExists(item)==-1) { //if code already exists (return -1) = already exists
					return true;
				} //if end
				return false;
			} else {
				System.out.println("Item code already exists");
				return false;
			} //if-else end
	} //addItem end
	/**
	 * return index of food item array (inventory)
	 * check if item code already exists or not - during add item
	 * @param item FoodItem from updateQuantity method
	 */
	int alreadyExists(FoodItem item) {
		for(int i=0;i < inventory.length;i++) {
			if (inventory[i].isEuqal(item)) { //if same true //null pointer error
				return i;
			} //if-else end
		} //for end
		return -1;
	} //alreadyExists end
	/**
	 * read item code to update quantity in inventory array.
	 * true = buying
	 * false = selling
	 */
	boolean updateQuantity(Scanner sc, boolean bs) {
		FoodItem fi = new FoodItem();
		fi.inputCode(sc);
		int index = alreadyExists(fi); //check the code is already exists or not
		if(index != -1) {
			String buysell = bs?"buy":"sell"; //if bs is true buy, false sell
			System.out.print("Enter valid quantity to " + buysell + ": ");
			if(sc.hasNextInt()) {
				int amount = sc.nextInt();
				sc.next();
				if(amount > 0) {
					return inventory[index].updateItem(bs?amount:amount*-1); //if buy send amount, sell send //return the amount is valid or not
				} else {
					System.out.println("Invalid quantity...");
				}
			}
		} else {
			System.out.println("Invalid quantity...");
		}
		return false;
	} //updateQuantity
} //Inventory class end
