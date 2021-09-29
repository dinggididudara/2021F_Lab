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
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodItem{
	protected FoodItem[] inventory; //array for storing food item inventory

	protected String type;

	protected int itemCode;
	protected String name;
	protected int quantity;
	protected double price;
	protected double cost;

	protected String fruitOrchard; //fruit

	protected double vegSale; //vegetable
	protected String vegFarm; //vegetable

	protected double preSale; //preserve
	protected double preJar;  //preserve
	/**
	 * set the size of inventory array
	 */
	FoodItem(){
		inventory = new FoodItem[20];
	}
	/**
	 * display the all data members in the class
	 */
	@Override
	public String toString() {
		for(int i=0; i < inventory.length; i++) { //code name quantity price cost
			if (inventory[0] == null) {
				System.out.println("");
				break;
			} //if end

			System.out.printf("Item: %5d %20s %3d   |   price: $%3f   |  cost: $%3f  |  ", itemCode, price, cost);

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
	boolean addItem(Scanner sc) {
		Inventory i = new Inventory();

		System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
		type = sc.next();

		//check the item code
		//checking item code if it exists or not

		i.alreadyExists(sc); //check the code if it already exists
		//while end
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
			type = "fruit";
			System.out.print("Enter the name of the orchard supplier: ");
			fruitOrchard = sc.nextLine();
			break;
		case "v": //if vegetable
			type = "vegetable";
			System.out.print("Enter the name of the farm supplier: ");
			vegFarm = sc.nextLine();
			break;
		case "p": //if preserve
			type = "preserve";
			System.out.print("Enter the size of the jar in millilitres: ");
			preJar = sc.nextDouble();
			break;
		default:
			System.out.println("Invalid entry");
			break;
		} //switch end
		return true;
	} //addItem end
	/**
	 * update the quantity field - buying / selling
	 */
	boolean updateItem(Scanner sc, int index, int buy_sell) {
		Inventory in = new Inventory();
		boolean a = inputCode(sc, buy_sell);
		int buyQuantity;
		int sellQuantity;
		boolean b = false;

		for(int i=0; i < inventory.length; i++) {
			if(a == true) { //buying
				System.out.print("Enter valid quantity to buy: ");
				buyQuantity = sc.nextInt();
				if(buyQuantity > 0 && buyQuantity <= inventory[i].quantity) {
					in.updateQuantity(sc, buyQuantity, i);
					b = true;
				} else if (inventory[i].quantity < buyQuantity){
					System.out.println("Insufficient stock in inventory...");				
				}else{ //if number is not valid
					System.out.println("Invalid quantity...");
					System.out.println("Error...could not buy item.");
					b = false;
				} //if-else end

			}else if(a == false){ //selling
				System.out.print("Enter valid quantity to sell: ");
				sellQuantity = sc.nextInt();
				if(sellQuantity > 0 && sellQuantity <= inventory[i].quantity) {
					in.updateQuantity(sc, sellQuantity, i);
				} else if (sellQuantity > inventory[i].quantity) {
					System.out.println("Insufficient stock in inventory...");	
				} //else-if end
			} else{ //if number is not valid
				System.out.println("Invalid quantity...");
				System.out.println("Error...could not buy item.");
				b = false;			
			} //if-else end
		} //for end
		return b;
	} //updateItem
	/**
	 * if item code exists = return true
	 * 2.check input code is in the array
	 * @return true
	 */
	boolean isEqual(Scanner sc, int checkCode, int num) {
		int index = 0;
		boolean tf = false;
		for(int i=0; i < inventory.length; i++) {
			if (inventory[i].itemCode == checkCode) { //if value is exists
				updateItem(sc, i, num);
				tf = true;
			} else {
				System.out.println("Code not found in inventory...");
				tf = false;
			} //if-else end
		} //for end
		return tf;
	} //isEqual end
	/**
	 * read a valid item code from scanner - buying & selling
	 * 1.checking if it is valid code or not -> if valid go to isEqual method
	 * true = buying 
	 * false = selling
	 */
	boolean inputCode(Scanner sc, int num) {
		int checkCode;
		boolean b = false;

		if(num == 1) {
			b = true;
		} else if(num == 2) {
			b = false;
		} //if-else end

		while(true) {
			try {
				System.out.print("Enter valid item code: ");
				checkCode = sc.nextInt();
				isEqual(sc, checkCode, num); //send input value to another method
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid code");
			} //try-catch		
		} //while end

		return b;
	} //inputCode end
} //FoodItem class end
