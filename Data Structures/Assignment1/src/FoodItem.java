/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * scanning food items from user and send information to inventory
 * inputCode -> isEqual -> updateItem -> updateQuantity
 * addItem -><- alreadyExists
 */
import java.util.*;
import java.util.InputMismatchException;

class FoodItem{
	FoodItem f;

	private int itemCode;
	private String name;
	private int quantity;
	private double price;
	private double cost;

	/**
	 * 
	 */
	FoodItem(){
		itemCode = 0;
		name = "";
		quantity = 0;
		price = 0;
		cost = 0;
	} //FoodItem

	/**
	 * display the all data members in the class
	 */	
	@Override
	public String toString() {
		return "Item: " + itemCode + " " + name + " " + quantity + "  | price: $" + price +  "  |  cost: $" + cost;
	} //toString end
	/**
	 * read from Scanner passed in and fill data member
	 */
	boolean addItem(Scanner sc) {
		while (true) {
			System.out.print("Enter the code for the item: ");
			if (!sc.hasNextInt()) {
				System.out.println("Invalid Entry");
				sc.nextLine();
			} else{
				break;
			}//if end
		} //while end
		sc.nextLine(); //remove newline
		while (name.replaceAll(" ", "").equals("")) { //reset the name if not valid
			System.out.print("Enter the name for the item: ");
			if (sc.hasNextLine()) {
				name = sc.nextLine();
			} //if end
		} //while end
		sc.nextLine();
		while (true) { //quantity
			System.out.print("Enter the quantity for the item: ");

			if (!sc.hasNextInt()) {
				System.out.println("Invalid Entry");
				sc.nextLine();
			} else {
				quantity = sc.nextInt();
				if (quantity > 0) {	break;}
				else {
					System.out.println("Invalid Entry");
					sc.nextLine();
				} //if-else end
			} //if-else end
		} //while end
		sc.nextLine(); //remove newline
		while (true) {
			System.out.print("Enter the cost for the item: ");

			if (!sc.hasNextDouble())	{
				System.out.println("Invalid Entry");
				sc.nextLine();
			} else {
				cost = sc.nextDouble();
				if (cost > 0) {break;}
				else {
					System.out.println("Invalid Entry");
					sc.nextLine(); //remove newline
				} //if-else end
			} //if-else end
		}//while end
		sc.nextLine();
		while (true) {
			System.out.print("Enter the price for the item: ");

			if (!sc.hasNextDouble())	{
				System.out.println("Invalid Entry");

				sc.nextLine();
			} else {
				price = sc.nextDouble();
				if (price > 0) {break;}
				else {
					System.out.println("Invalid Entry");
					sc.nextLine(); //remove newline
				} //if-else end
			} //if-else end
		} //while end
		sc.nextLine();
		return true;
	} //addItem end
	/**
	 * update the quantity field - buying / selling
	 * @param amount for change quantity
	 * 
	 */
	boolean updateItem(int amount) {
		if(amount <= quantity) {
			quantity -= amount;
			return true;
		} else {
			return false;
		}
	} //updateItem
	/**
	 * if item code exists = return true
	 * 2.check input code is in the array
	 * @return true for success , false for fail
	 */
	boolean isEuqal(FoodItem item) {
		if(item.itemCode == itemCode) {
			return true;
		}
		return false;
	} //isEqual end
	/**
	 * read a valid item code from scanner - buying & selling
	 * 1.checking if it is valid code or not -> if valid go to isEqual method
	 * true = buying 
	 * false = selling
	 */
	boolean inputCode(Scanner sc) { //just scanning the value
		boolean b = false;
		int checkCode;

		while(true) {
			try {
				System.out.print("Enter valid item code: ");
				checkCode = sc.nextInt();
				b = true;
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid code");
				b = false;
			} //try-catch		
		} //while end
		return b; //true=success, false=fail
	} //inputCode end
} //FoodItem class end
