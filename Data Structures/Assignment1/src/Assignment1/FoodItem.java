/**
 * CST - CS
 * Soomin Lee
 * 040899389
 * Assignment 1
 */
package Assignment1;

import java.util.Scanner;

public class FoodItem extends Inventory{
	/**
	 * display the all data members in the class
	 */
	@Override
	public String toString() {
		for(int i=0; i < inventory.length; i++) {
			if(inventory[i])
			//for fruit
			System.out.println("Item: %5d %20s %3d   |   price: $%3f   |  cost: $%3f  |  orchard supplier: %s", code, name, quantity, price, cost, orchard);
			//vegetable
			System.out.println("Item: %5d %20s %3d   |   price: $%3f   |  cost: $%3f  |  farm supplier: %s", code, name, quantity, price, cost, farm);
			//preserve
			System.out.println("Item: %5d %20s %3d   |   price: $%3f   |  cost: $%3f  |  size: %f ml", code, name, quantity, price, cost, size);
		}
		return null;
	} //toString end
	/**
	 * read from Scanner object passed in and fills data member
	 */
	//	@Override
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
	 * update the quantity field 
	 */
	boolean updateItem() {
		return false;
	} //updateItem
	/**
	 * if item code is equal = return true
	 * @return
	 */
	public boolean isEqual() {

		return false;
	} //isEqual end
	/**
	 * read a valid item code from scanner 
	 */
	boolean inputCode(Scanner sc, int itemCode) {


		return true; //if success
	} //inputCode end
} //FoodItem class end
