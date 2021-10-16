/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 2
 * October-10-2021
 * scanning food items from user and send information to inventory
 * inputCode -> isEqual -> updateItem -> updateQuantity
 * addItem -><- alreadyExists
 */
import java.io.Serializable;
import java.util.*;
/**
 * FoodItem class scanning user input, and  update item when user buy/sell products
 *
 */
class FoodItem implements Serializable{
	/**
	 * default serial version uid
	 */
	private static final long serialVersionUID = 1L;

	FoodItem f;

	private int itemCode;
	private String name;
	private int quantity;
	private double price;
	private double cost;

	/**
	 * initialize to zero to everything first (initialize)
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
	 * getItemCode : getter for item code
	 * @return itemCode
	 */
	public int getItemCode() {
		return itemCode;
	} //getItemCode end
	/**
	 * getQuantity : getter for quantity
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	} //getQuantity end
	/**
	 * display the all data members in the class
	 */	
	@Override
	public String toString() {
		return "Item: " + itemCode + " " + name + " " + quantity + "  price: $" + price +  "  cost: $" + cost;
	} //toString end
	/**
	 * read from Scanner passed in and fill data member
	 * @param sc Scanner
	 * @param fromFile check if it is from file or not
	 */
	public boolean addItem(Scanner sc, boolean fromFile) {
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
		if(amount <= this.quantity) {
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
	 * Comparator, comparing item code in array list
	 */
	public static Comparator<FoodItem> codeComparator = new Comparator<FoodItem>() {
		@Override
		public int compare(FoodItem f1, FoodItem f2) {
			return (f1.getItemCode()-f2.getItemCode()); //return zero if match
		} //compare end
	}; //comparator end

	/**
	 * read a valid item code from file
	 */
	boolean inputCode(Scanner sc, boolean fromFile) { 
		boolean b = false;
		while (true) { //continue until get valid code
			System.out.print("Enter the code for the item: ");

			if (!sc.hasNextInt()) {
				System.out.println("Invalid Code");
				sc.nextLine(); //remove newline
			} else{
				this.itemCode = sc.nextInt();
				sc.nextLine(); //remove newline
				b=true;
				break;
			}//if end
			sc.nextLine();
		} //while end
		return b; //true=success, false=fail
	} //inputCode end
} //FoodItem class end
