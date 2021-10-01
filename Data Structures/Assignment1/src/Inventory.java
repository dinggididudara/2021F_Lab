/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * Inventory class : extends FoodItem class, inventory for food items
 */
import java.util.Scanner;

class Inventory extends FoodItem{	
	/**
	 * adding item to inventory array
	 */
	boolean addItem(Scanner sc) {
		boolean b = false;
		for(int i=0;i < inventory.length;i++) {
			if(inventory[i] == null) { //if null
				super.addItem(sc); //erroreeroreroerero
				inventory[i] = new FoodItem();
				inventory[i].
				b = true; //success
				break;
			} else {
				System.out.println("it is not null");
				b = false; //fail
			}//if end
		} //for end
		return b;
	} //addItem end
	/**
	 * return index of food item array (inventory)
	 * check if item code already exists or not - during add item
	 */
	int alreadyExists(Scanner sc) {
		int itemCode;
		int index = -1;

		System.out.print("Enter the code for the item: ");
		itemCode = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i < inventory.length;i++) {
			if(inventory[i].getItemCode() == 0) {
				System.out.println("where is error?");
				index = -1;
				break;
			}else if(inventory[i].getItemCode() == itemCode) { //if code already exists //error here///////////////////
				System.out.println("Invalid code");
				index = i;
				break;
			} else if(inventory[i].getItemCode() != itemCode) { //error
				index = -1;
				System.out.println(index);
			} //if-else end
		} //for end
		return index;
	} //alreadyExists end
	/**
	 * read item code to update quantity in inventory array.
	 * true = buying
	 * false = selling
	 */
	boolean updateQuantity(int updatingQuantity, int index, String bs) {
		boolean b = false;

		if(updatingQuantity > 0 && updatingQuantity <= inventory[index].getQuantity()) {
			if(bs.equals("buy")) {
				inventory[index].getQuantity() -= updatingQuantity;
			} else if(bs.equals("sell")) {
				inventory[index].getQuantity() += updatingQuantity;
			}
			b = true;
		} else if (inventory[index].getQuantity() < updatingQuantity){
			System.out.println("Insufficient stock in inventory...");				
		}else if (updatingQuantity <= 0){ //if number is not valid
			System.out.println("Invalid quantity...");
			b = false;
		} //if-else end


		return b;
	} //updateQuantity
} //Inventory class end
