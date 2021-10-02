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
	@Override
	boolean addItem(Scanner sc) {
		FoodItem fi = new FoodItem();
		boolean b = false;
		for(int i=0; i < inventory.length; i++) {
			if(inventory[i] == null) { //if null
				System.out.println("here is the error???");
				fi.addItem(sc);
				
				System.out.println("before new fooditem");
				inventory[i] = new FoodItem(getType(), getItemCode(), getName(), getQuantity(), getPrice(), getCost(), getExtra(), getA());
				System.out.println(inventory[i].getType() + "*******1111****");//test///////////////////////
				System.out.println(inventory[i].getName() + "&&&&&&&22222&&&");//test////////////
				System.out.println(inventory[i].getType() + "*******3333**");//test////////////////
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
	int alreadyExists(Scanner sc, int itemCodeCheck) {
		int index = -1;

		for(int i=0;i < inventory.length;i++) {
			if(inventory[i] != null && itemCodeCheck == inventory[i].getItemCode()) { //if code already exists //******error here///////////////////
				System.out.println("Invalid code");
				index = i;
				break;
			} //if else
			index = -1;
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
				inventory[index].setQuantity(inventory[index].getQuantity() - updatingQuantity);
			} else if(bs.equals("sell")) {
				inventory[index].setQuantity(inventory[index].getQuantity() + updatingQuantity);
			} //if-else end
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
