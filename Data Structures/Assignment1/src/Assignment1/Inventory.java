/**
 * 
 */
package Assignment1;

import java.util.Scanner;
/**
 * 
 * 
 *
 */
public class Inventory extends FoodItem{	
	/**
	 * adding item to inventory array
	 */
	@Override
	boolean addItem(Scanner sc) {
		while(true) {
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
			type = sc.next();
			
			System.out.print("Enter the code for the item: ");
			itemCode = sc.nextInt();
			System.out.print("Enter the name for the item: ");
			name = sc.nextLine();
			System.out.print("Enter the quantity for the item: ");
			quantity = sc.nextInt();
			System.out.print("Enter the cost of the item: ");
			cost = sc.nextDouble();
			
			switch(type) {
			case "f":
				type = "fruit";
				System.out.print("Enter the name of the orchard supplier: ");
				fruitOrchard = sc.nextLine();
				break;
			case "v":
				type = "vegetable";
				System.out.print("Enter the sales price of the item: ");
				System.out.print("Enter the name of the farm supplier: ");
				break;
			case "p":
				type = "preserve";
				System.out.print("Enter the sales price of the item: ");
				System.out.print("Enter the size of the jar in millilitres: ");
				break;
			default:
				System.out.println("Invalid entry");
				break;
			} //switch end
		} //while end
	} //addItem end
	/**
	 * if the item code exists returns -1 / if exists return index
	 */
	int alreadyExists() {
		return -1;
	} //alreadyExists end
	/**
	 * read item code to update quantity in inventory array.
	 * true = buying
	 * false = selling
	 */
	boolean updateQuantity(Scanner sc) {
		inputCode(sc);
		
		return true;
	} //updateQuantity
} //Inventory class end
