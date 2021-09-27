/**
 * 
 */
package Assignment1;

import java.util.Scanner;

public class Inventory {
	String option;
	private FoodItem[] inventory; //array for storing food item inventory
	/**
	 * 
	 */
	Inventory(){ //printing inventory
		System.out.println("Inventory:");
		//for fruit
		System.out.println("Item: %5d %20s %3d   |   price: $%3f   |  cost: $%3f  |  orchard supplier: %s", code, name, quantity, price, cost, orchard);
		//vegetable
		System.out.println("Item: %5d %20s %3d   |   price: $%3f   |  cost: $%3f  |  farm supplier: %s", code, name, quantity, price, cost, farm);
		//preserve
		System.out.println("Item: %5d %20s %3d   |   price: $%3f   |  cost: $%3f  |  size: %f ml", code, name, quantity, price, cost, size);
	} //Inventory end
	/**
	 * adding item to inventory array
	 */
	@Override
	boolean addItem(Scanner sc) {
		String option;
		while(true) {
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
			option = sc.next();

			switch(option) {
			case "f":
				System.out.print("Enter the code for the item: ");
				System.out.print("Enter the name for the item: ");
				System.out.print("Enter the quantity for the item: ");
				System.out.print("Enter the cost of the item: ");
				System.out.print("Enter the name of the orchard supplier: ");
				break;
			case "v":
				System.out.print("Enter the code for the item: ");
				System.out.print("Enter the name for the item: ");
				System.out.print("Enter the quantity for the item: ");
				System.out.print("Enter the cost of the item: ");
				System.out.print("Enter the sales price of the item: ");
				System.out.print("Enter the name of the farm supplier: ");
				break;
			case "p":
				System.out.print("Enter the code for the item: ");
				System.out.print("Enter the name for the item: ");
				System.out.print("Enter the quantity for the item: ");
				System.out.print("Enter the cost of the item: ");
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
	 * if the item code exists returns -1 / if exists index
	 */
	int alreadyExists() {
		int index = 0;
		for(int i=0;i < inventory.length;i++) {
			if (inventory[i].itemCode == exists) { //if value is exists
				System.out.println("Item code already exists");
				return -1;
			}
			if () {

			} //if end
		} //for end
	} //alreadyExists end
	/**
	 * 
	 */
	boolean updateQuantity() {
		return true;
	} //updateQuantity
} //Inventory class end
