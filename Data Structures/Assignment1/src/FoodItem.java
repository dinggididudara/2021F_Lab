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

class FoodItem extends Inventory{
	FoodItem f;
	private String type;

	private int itemCode;
	private String name;
	private int quantity;
	private double price;
	private double cost;

//	/**
//	 * 
//	 * @param type
//	 * @param itemCode
//	 * @param name
//	 * @param quantity
//	 * @param price
//	 * @param cost
//	 */
//	FoodItem(String type, int itemCode, String name, int quantity, double price, double cost){
//		this.type = type;
//		this.itemCode = itemCode;
//		this.name = name;
//		this.quantity = quantity;
//		this.price = price;
//		this.cost = cost;
//	} //FoodItem
	
	/**
	 * display the all data members in the class
	 */	
	@Override
	public String toString() {
		super.toString();
		return "Item: " + this.itemCode + " " + this.name + " " + this.quantity + "  | price: $" + this.price +  "  |  cost: $" + this.cost;
	} //toString end
	/**
	 * getter and setter for external class, method
	 */
	/**
	 * save type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * save type
	 * @param type
	 */
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	/**
	 * save type
	 * @param type
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * save quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * save price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * save cost
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * storing type of the product
	 * @return type
	 */
	String getType() {
		return type;
	}
	/**
	 * storing item code and return
	 * @return itemCode
	 */
	int getItemCode() {
		return itemCode;
	} //getItemCode end
	/**
	 * 
	 * @return 
	 */
	String getName() {
		return name;
	} //getName end
	/**
	 * 
	 * @return
	 */
	int getQuantity() {
		return quantity;
	} //getQuantity end
	/**
	 * @return
	 */
	double getPrice() {
		return price;
	} //getPrice end
	/**
	 * storing cost
	 * @return cost
	 */
	double getCost() {
		return cost;
	} //cost end
	/**
	 * read from Scanner passed in and fills data member
	 */
//	@Override
	boolean addItem(Scanner sc) {
		Inventory i = new Inventory();
		while(true) {
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
			type = sc.next();
			if(!(type.equals("f")) && !(type.equals("v")) && !(type.equals("p"))) { //if not the type
				System.out.println("Invalid type");
				return false; //if fail
			} else {
				break;
			} //if-else end
		} //while end
		
		System.out.print("Enter the code for the item: ");
		itemCode = sc.nextInt();
		sc.nextLine();

		int e = i.alreadyExists(sc, itemCode); //check the code if it already exists
		if(e == -1) { //if code does not exist in array
			f = new FoodItem();
			int error = 0;
			while(error == 0) {
				try {
					System.out.print("Enter the name for the item: ");
					name = sc.nextLine();
					System.out.print("Enter the quantity for the item: ");
					quantity = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the cost of the item: ");
					cost = sc.nextDouble();
					System.out.print("Enter the sales price of the item: ");
					price = sc.nextDouble();
					sc.nextLine();

					switch(type) { //type of the product
					case "f": //if fruit
						f = new Fruit();						
						error = 2;
						break;
					case "v": //if vegetable
						f = new Vegetable();						
						error = 2;
						break;
					case "p": //if preserve
						f = new Preserve();						 
						error = 2;
						break;
					default:
						System.out.println("Invalid entry");
						break;
					} //switch end	
					
					f.addItem(sc);
				
				} catch(InputMismatchException m) {
					System.out.println("Invalid entry");
				}catch (Exception ex) {
					System.out.println("error");
				} //try-catch end
			} //while end
		} //if end
		return true;
	} //addItem end
	/**
	 * update the quantity field - buying / selling
	 * @param sc Scanner
	 * @param index number for the array
	 * @param buy_sell option for buy or sell
	 */
	boolean updateItem(int amount) {
		
		boolean b = false;
		String bs = null;

		if(buy_sell == 1) {
			bs = "buy";
		}else if(buy_sell ==2) {
			bs = "sell";
		} //if-else end

		try {
			
			
			b = true;
		} catch (InputMismatchException e) {
			System.out.printf("Error...could not %s item.\n", bs);
			b = false;		
		} //try-catch end
		return b; //succeed = true, fail = false
	} //updateItem
	/**
	 * if item code exists = return true
	 * 2.check input code is in the array
	 * @return true for success , false for fail
	 */
	boolean isEuqal(FoodItem item) {
		boolean tf = false; //true or false //success or failure
		int amount;
//		item.quantity 
			if (inventory[i] != null) { //if value is exists //error//how to check the code?????
				if(inventory[i].getItemCode() == checkCode) {
					updateItem(amount);
					tf = true; //if success
					break;
				} //if end
			} else {
				System.out.println("Code not found in inventory...");
				tf = false; //if not success
			} //if-else end
	
		return tf;
	} //isEqual end
	/**
	 * read a valid item code from scanner - buying & selling
	 * 1.checking if it is valid code or not -> if valid go to isEqual method
	 * true = buying 
	 * false = selling
	 */
	boolean inputCode(Scanner sc) {
		boolean b = false;
		int checkCode;
		
		while(true) {
			try {
				System.out.print("Enter valid code: ");
				checkCode = sc.nextInt();
				System.out.println("Enter valid quantity to : ");
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid code");
			} //try-catch		
		} //while end

		return b;
	} //inputCode end
} //FoodItem class end
