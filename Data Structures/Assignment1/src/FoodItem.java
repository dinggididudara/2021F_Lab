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
/**
 * FoodItem class scanning user input, and  update item when user buy/sell products
 *
 */
class FoodItem{
	FoodItem f;

	private int itemCode;
	private String name;
	private int quantity;
	private double price;
	private double cost;

	/**
	 * initialize to zero to everything first
	 */
	FoodItem(){
		itemCode = 0;
		name = "";
		quantity = 0;
		price = 0;
		cost = 0;
	} //FoodItem
	/**
	 * saving members
	 * @param itemCode itecm code
	 * @param name item name
	 * @param quantity item in stock
	 * @param price item price
	 * @param cost item cost
	 */
	FoodItem(int itemCode, String name, int quantity, double price, double cost){
		this.itemCode = itemCode;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
	}
	/**
	 * getF FoodItem object
	 * @return f
	 */
	public FoodItem getF() { 
		return f;
	}
	/**
	 * getItemCode item code store
	 * @return itemCode
	 */
	public int getItemCode() {
		return itemCode;
	}
	/**
	 * getName store name of product
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * getQuantity store quantity of product
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * getPrice store price of product
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * getCost store cost of product
	 * @return cost
	 */
	public double getCost() {
		return cost;
	}
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
		while (name.replaceAll(" ", "").equals("")) { //reset the name if not valid
			System.out.print("Enter the name for the item: ");
			if (sc.hasNextLine()) {
				name = sc.nextLine();
			} //if end
		} //while end

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

			if (!sc.hasNextDouble())	{ //if it is not double type
				System.out.println("Invalid Entry");
				sc.nextLine();
			} else {
				cost = sc.nextDouble(); //if it is double type then save cost
				if (cost > 0) {break;}
				else {
					System.out.println("Invalid Entry");
					sc.nextLine(); //remove newline
				} //if-else end
			} //if-else end
		}//while end
		sc.nextLine(); //remove newline
		while (true) {
			System.out.print("Enter the price for the item: ");

			if (!sc.hasNextDouble())	{
				System.out.println("Invalid Entry");

				sc.nextLine(); //remove newline
			} else { //if it is double type
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
	boolean updateItem(int amount) { //get amount from another method
		if(amount <= this.quantity) { //if it is smaller than this quantity (already stored)
			this.quantity += amount;
			if(this.quantity > 0) { 
				return true;
			} //if end
			return false;
		} else {
			return false;
		} //updateItem end
	} //updateItem
	/**
	 * if item code exists = return true
	 * 2.check input code is in the array
	 * @return true for success , false for fail
	 */
	boolean isEuqal(FoodItem item) {
		if(item.itemCode == this.itemCode) { //if itemCode is same
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
	boolean inputCode(Scanner sc) { 
		boolean b = false;

		while(true) {
			try { //scan the item code
				System.out.print("Enter valid item code: ");
				this.itemCode = sc.nextInt();
				b = true;
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid code");
				b = false;
			} //try-catch		
		} //while end
		return b; //true=success, false=fail
	} //inputCode end
	/**
	 * read a valid item code from scanner - during addItem
	 */
	boolean inputCode(Scanner sc, FoodItem item) { 
		boolean b = false;
		while (true) { //continue until get valid code
			System.out.print("Enter the code for the item: ");

			if (!sc.hasNextInt()) {
				System.out.println("Invalid Entry");
			} else{
				this.itemCode = sc.nextInt();
				sc.nextLine(); //remove newline
				b=true;
				break;
			}//if end
			sc.nextLine(); //remove new line
		} //while end
		return b; //true=success, false=fail
	} //inputCode end
} //FoodItem class end
