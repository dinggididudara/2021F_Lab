/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * Inventory class : extends FoodItem class, inventory for food items
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Inventory extends Assign1{	
	private ArrayList<FoodItem> inventory; //array for storing food item inventory
	private final int NUM = 20; 

	/**
	 * 
	 */
	Inventory(){
		inventory = new ArrayList<>(NUM);
	} //Inventory end
	/**
	 * display of inventory
	 */
	public String toString() {
		StringBuilder a = new StringBuilder();
		for(int i=0; i < inventory.size(); i++) {
			a.append(inventory.get(i) + "\n");
		} //for end
		return a.toString();
	} //toString end
	/**
	 * adding item to inventory array
	 */
	boolean addItem(Scanner sc) {
		boolean b = false;
		FoodItem item = null;
		while(!b) {
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
			if(sc.hasNext(Pattern.compile("[fvp]"))) {
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
				sc.next();
				b = false;
			} //if-else end
		} //while end

		if(item.inputCode(sc)) { //if input code is true
			if(alreadyExists(item)==-1) { //if code already exists (return -1) = already exists
				if(item.addItem(sc)) { //go to add item in inventory class. if add item is true
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
		for(int i=0;i < inventory.size();i++) {
			if(inventory.get(i).isEuqal(item)){ //if code same
				return i;					
			} //if else
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
			System.out.println("Enter valid quantity to " + buysell + ": ");
			if(sc.hasNextInt()) {
				int amount = sc.nextInt();
				return inventory.get(index).updateItem(bs?amount:amount*-1); //if buy send amount, sell send 
			}
		} else {
			System.out.println("Invalid quantity...");
		}
		return false;
	} //updateQuantity
} //Inventory class end
