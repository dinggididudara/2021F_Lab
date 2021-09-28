/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 */
import java.util.Scanner;

public class FoodItem{
	protected Inventory[] inventory; //array for storing food item inventory

	protected String type;

	protected int itemCode;
	protected String name;
	protected int quantity;
	protected int price;
	protected double cost;

	protected String fruitOrchard; //fruit

	protected double vegSale; //vegetable
	protected String vegFarm; //vegetable

	protected double preSale; //preserve
	protected double preJar;  //preserve

	/**
	 * display the all data members in the class
	 */
	@Override
	public String toString() {
		for(int i=0; i < inventory.length; i++) {
			System.out.printf("Item: %5d %20s %3d   |   price: $%3f   |  cost: $%3f  |  ", itemCode, cost, cost);
			switch(inventory[i].type) {
			case "fruit":
				System.out.printf("orchard supplier: %s\n", fruitOrchard);
				break;
			case "vegetable":
				System.out.printf("farm supplier: %s\n", vegFarm);
				break;
			case "preserve":
				System.out.printf("size: %f ml\n", preJar);
				break;
			} //switch end
		} //for end
		return null;
	} //toString end
	/**
	 * read from Scanner passed in and fills data member
	 */
	//	@Override
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
	 * update the quantity field - buying / selling
	 */
	boolean updateItem(Scanner sc, int i, int checkCode, int buy_sell) {
		int index = i;
		if(buy_sell == 1) { //if buy
			Inventory.updateQuantity(sc);
		} else if(buy_sell == 2) { //if sell
			

		}
		return false;
	} //updateItem
	/**
	 * if item code is equal = return true
	 * @return
	 */
	public boolean isEqual(Scanner sc) {
		int checkCode = 0;
		int index = 0;
		for(int i=0; i < inventory.length; i++) {
			System.out.print("Enter valid item code: ");
			checkCode = sc.nextInt();
			if (inventory[i].itemCode == checkCode) { //if value is exists
				alreadyExists(sc, i, checkCode, buy_sell);
				return true;
			} else {
				System.out.println("Code not found in inventory...");
			} //if-else end
		} //for end
		return false;
	} //isEqual end
	/**
	 * read a valid item code from scanner - buying & selling
	 */
	boolean inputCode(Scanner sc, int buy_sell) {
		int checkCode = 0;
		int index = 0;
		for(int i=0; i < inventory.length; i++) {
			System.out.print("Enter valid item code: ");
			checkCode = sc.nextInt();
			if (inventory[i].itemCode == checkCode) { //if value is exists
				alreadyExists(sc, i, checkCode, buy_sell);
				return true;
			} else {
				System.out.println("Code not found in inventory...");
			} //if-else end
		} //for end
		return false;
	} //inputCode end
} //FoodItem class end
