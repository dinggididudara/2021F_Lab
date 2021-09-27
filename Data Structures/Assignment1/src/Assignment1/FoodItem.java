/**
 * CST - CS
 * Soomin Lee
 * 040899389
 * Assignment 1
 */
package Assignment1;

import java.util.Scanner;

public class FoodItem {
	/**
	 * 
	 */
	@Override
	public String toString() {
		
		return null;
	} //toString end
	/**
	 * 
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
	 * 
	 */
	boolean updateItem() {
		return false;
	} //updateItem
	/**
	 * 
	 * @return
	 */
	public boolean isEqual() {
		
		return false;
	} //isEqual end
	/**
	 * 
	 */
	boolean inputCode() {
		return true;
	} //inputCode end
} //FoodItem class end
