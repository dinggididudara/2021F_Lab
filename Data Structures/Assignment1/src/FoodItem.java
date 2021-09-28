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
	protected Inventory[] inventory = new Inventory[20]; //array for storing food item inventory

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
		for(int i=0; i < inventory.length; i++) { //code name quantity price cost
			if (inventory[0] == null) {
				System.out.println("");
				break;
			}
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
		while(true) {
			try {
				System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
				type = sc.next();

				//check the item code
				while(true) { //checking item code if it exists or not
					System.out.print("Enter the code for the item: ");
					itemCode = sc.nextInt();
					int a = i.alreadyExists(sc, itemCode); 
					if (a == -1) { //return value if -1 = if already exists
						System.out.println("Invalid code");
					} else {
						break; //escape while loop
					} //if-else end
				} //while end
				System.out.print("Enter the name for the item: ");
				name = sc.nextLine();
				System.out.print("Enter the quantity for the item: ");
				quantity = sc.nextInt();
				System.out.print("Enter the cost of the item: ");
				cost = sc.nextDouble();
				System.out.print("Enter the sales price of the item: ");
				price = sc.nextInt();

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
			} catch(InputMismatchException m) {
				System.out.println("Invalid entry");
			} catch (Exception e) {
				System.out.println("Invalid entry");
			} //try-catch end
		} //while end

	} //addItem end
	/**
	 * update the quantity field - buying / selling
	 */
	boolean updateItem(Scanner sc, int index, int buy_sell) {
		//		int index = i;
		//		if(buy_sell == 1) { //if buy
		//			Inventory.updateQuantity(sc);
		//		} else if(buy_sell == 2) { //if sell
		//
		//		}
		//		return false;
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
					inventory[i].quantity = inventory[i].quantity - buyQuantity;
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
					inventory[i].quantity = inventory[i].quantity - sellQuantity;
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
