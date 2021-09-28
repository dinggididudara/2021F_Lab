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
		super.addItem(sc);
		
		return true;
	} //addItem end
	/**
	 * return index of food item array (inventory)
	 */
	int alreadyExists(Scanner sc, int i, int checkCode, int buy_sell) {
//		int index = i;
//		if(buy_sell == 1) { //if buy
//			updateQuantity(sc);
//			return index;
//		} else if(buy_sell == 2) { //if sell
//			
//			return index;
//		}
//			
		return -1; //if not exists
	} //alreadyExists end
	/**
	 * read item code to update quantity in inventory array.
	 * true = buying
	 * false = selling
	 */
	public boolean updateQuantity(Scanner sc, int buy_sell) {
		inputCode(sc, buy_sell);
		if(inputCode(sc, buy_sell) == true) { //buying
			System.out.print("Enter valid quantity to buy: ");
			int buyQuantity = sc.nextInt();
			if(buyQuantity > 0 && inventory[i].quantity >= buyQuantity) {
				inventory[i].quantity = inventory[i].quantity - buyQuantity;
				return true;
			} else if (inventory[i].quantity < buyQuantity){
				System.out.println("Insufficient stock in inventory...");				
			}else{ //if number is not valid
				System.out.println("Invalid quantity...");
				System.out.println("Error...could not buy item.");
				return false;
			} //if-else end
		}else if(inputCode(sc, buy_sell) == false){ //selling
			
		}
		return true;
	} //updateQuantity
} //Inventory class end
