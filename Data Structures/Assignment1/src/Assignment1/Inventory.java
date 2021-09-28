/**
 * 
 */
package Assignment1;

import java.util.Scanner;

public class Inventory {
	private String option;
	protected FoodItem[] inventory; //array for storing food item inventory
	private int itemCode;
	private String name;
	private int quantity;
	private double cost;
	
	private String fruitOrchard; //fruit
	
	private double vegSale; //vegetable
	private String vegFarm; //vegetable
	
	private double preSale; //preserve
	private double preJar;  //preserve
	
	/**
	 * adding item to inventory array
	 */
	@Override
	boolean addItem(Scanner sc) {
		String type; //type of the product
		while(true) {
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
			type = sc.next();

			switch(type) {
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
	 * if the item code exists returns -1 / if exists return index
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
	 * read item code to update quantity in inventory array.
	 * true = buying
	 * false = selling
	 */
	boolean updateQuantity() {
		
		return true;
	} //updateQuantity
} //Inventory class end
