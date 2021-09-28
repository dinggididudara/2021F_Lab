/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * Inventory class : extends FoodItem class, inventory for food items
 */
import java.util.Scanner;

public class Inventory extends FoodItem{	
	/**
	 * adding item to inventory array
	 */
	@Override
	boolean addItem(Scanner sc) {
		boolean b = false;
//		super.addItem(sc);
		for(int i=0;i < inventory.length;i++) {
			if(inventory[i] == null) {
				inventory[i].addItem(sc);
				b = true; //success
				break;
			} else {
				b = false; //fail
			}//if end
		} //for end
		return b;
	} //addItem end
	/**
	 * return index of food item array (inventory)
	 * check if item code already exists or not - during add item
	 */
	int alreadyExists(Scanner sc, int code) {
		int index = -1;
		for(int i=0;i < inventory.length;i++) {
			if(inventory[i].itemCode == code) {
				index = i;
				break;
			} //if end
			if(inventory[i].itemCode != code) {
				index = -1;
			} //if end
		} //for end
		return index;
	} //alreadyExists end
	/**
	 * read item code to update quantity in inventory array.
	 * true = buying
	 * false = selling
	 */
	boolean updateQuantity(Scanner sc, int updatingQuantity, int index) {
		//		inputCode(sc);
		boolean b = false;

		inventory[index].quantity = (inventory[index].quantity - updatingQuantity);

		return b;
	} //updateQuantity
} //Inventory class end
