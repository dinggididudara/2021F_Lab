/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * Inventory class : extends FoodItem class, inventory for food items
 */
import java.util.Scanner;

class Inventory extends Assign1{	
	private FoodItem[] inventory; //array for storing food item inventory
	private final int NUM = 20; 

	/**
	 * 
	 */
	Inventory(){
		inventory = new FoodItem[NUM];
	} //Inventory end
	/**
	 * displaying inventory
	 */
	void displayInventory() { //not saving anything 
		for(int i=0;i <inventory.length;i++) {
			if(inventory[i] != null) {
				toString();
			} else {
				Assign1.main(null);
				break;
			}//if-else end
		} //for end
	} //displayInventory end
	/**
	 * 
	 */
	//	@Override
	public String toString() {
		return "inventory: \n";
	} //toString end
	/**
	 * adding item to inventory array
	 */
	boolean addItem(Scanner sc) {
		boolean b = false;
		for(int i=0; i < inventory.length; i++) {
			if(inventory[i] == null) { //if null
				inventory[i].addItem(sc); //FoodItem class - addItem				
				b = true; //success
				break;
			} else {
				b = false; //fail
			}//if end
		} //for end
		return b;
	} //addItem end
	/**
	 * return index of food item array (inventory)
	 * check if item code already exists or not - during add item
	 * @param item FoodItem from updateQuantity method
	 */
	int alreadyExists(FoodItem item) {
		int index = -1;
		

		for(int i=0;i < inventory.length;i++) {
			if(inventory[i] != null && item.getItemCode() == inventory[i].getItemCode()) { //if code already exists
				System.out.println("Invalid code"); //already exists
				index = i; //return index
				break;
			} //if else
			index = -1;
		} //for end
		return index;
	} //alreadyExists end
	/**
	 * read item code to update quantity in inventory array.
	 * true = buying
	 * false = selling
	 */
	boolean updateQuantity(Scanner sc, boolean bs) {
		boolean b = false;
		int checkCode;
		int newQuantity;

		System.out.print("Enter the code for the item: ");
		checkCode = sc.nextInt();
		
		for(int i=0;i < inventory.length;i++) { //check if it exists
			int index = alreadyExists(inventory[i]);
			
			if(index != -1) { //if index is not
				if(bs == true) { //if buying
					System.out.print("Enter valid quantity to buy: ");
					b = true;
				} else if (bs == false) { //if selling
					System.out.print("Enter valid quantity to sell: ");
					b = false;
				} //if-else end

				newQuantity = sc.nextInt(); //read next value as new quantity for calculating

				if(newQuantity <= inventory[index].getQuantity()) {
					if(bs == true) { //if buy
						inventory[index].setQuantity(inventory[index].getQuantity() - newQuantity);
					} else if(bs == false) {
						inventory[index].setQuantity(inventory[index].getQuantity() + newQuantity);
					} //if-else end
					b = true;
				} else if (inventory[index].getQuantity() < newQuantity){ //if sell
					System.out.println("Insufficient stock in inventory...");				
				} //if-else end
			} else {
				System.out.println("Error...Could not buy/sell item(s)");
			} //if-else end	
		} //for end

		return b;
	} //updateQuantity
} //Inventory class end
