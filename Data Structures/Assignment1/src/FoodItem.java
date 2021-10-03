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


	FoodItem(){}
	/**
	 * 
	 * @param type
	 * @param itemCode
	 * @param name
	 * @param quantity
	 * @param price
	 * @param cost
	 */
	FoodItem(int itemCode, String name, int quantity, double price, double cost){
		this.itemCode = itemCode;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
	} //FoodItem

	/**
	 * display the all data members in the class
	 */	
	@Override
	public String toString() {
		super.toString();
		return "Item: " + itemCode + " " + name + " " + quantity + "  | price: $" + price +  "  |  cost: $" + cost;
	} //toString end
	/**
	 * getter and setter for external class, method
	 */

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
	 * read from Scanner passed in and fill data member
	 */
	boolean addItem(Scanner sc) {
		int error = 0;
		while(error == 0) {
			try {
				System.out.println("Enter the code for the item: ");
				itemCode = sc.nextInt();
				
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
				return true;
			} catch(InputMismatchException m) {
				System.out.println("Invalid entry");
			}catch (Exception ex) {
				System.out.println("error");
			} //try-catch end
		} //while end
		return false;
	} //addItem end
	/**
	 * update the quantity field - buying / selling
	 * @param amount for change quantity
	 * 
	 */
	boolean updateItem(int amount) {
		if(amount <= quantity) {
			quantity += amount;
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
		if(item.itemCode == this.itemCode) {
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
