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
//implements Comparable<FoodItem>
class FoodItem extends Assign1{
	protected FoodItem[] inventory = new FoodItem[20]; //array for storing food item inventory

	private String type;

	private int itemCode;
	private String name;
	private int quantity;
	private double price;
	private double cost;
	private String extra; //extra information

	private String a;
	/**
	 * initialize FoodItem class
	 */
	FoodItem(){}
	/**
	 * set total size of array
	 * @param num total size of array
	 */
	FoodItem(int num){
		inventory = new FoodItem[num];
	}
	/**
	 * 
	 * @param type
	 * @param itemCode
	 * @param name
	 * @param quantity
	 * @param price
	 * @param cost
	 */
	FoodItem(String type, int itemCode, String name, int quantity, double price, double cost, String extra){
		this.type = type;
		this.itemCode = itemCode;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
		this.extra = extra;
	} //FoodItem
	/**
	 * displaying inventory
	 */
	void displayInventory() {
		for(int i=0;i <inventory.length;i++) {
			if(inventory[i] != null) {
				System.out.println(itemCode);
				toString();
			} else {
				Assign1.main(null);
				break;
			}//if-else end
		} //for end
	} //displayInventory end
	/**
	 * display the all data members in the class
	 */	
	//	@Override
	public String toString() {
		//		for(int i=0;i<inventory.length;i++) {
		//			if (inventory[0] == null) {
		//				System.out.println("");
		//				Assign1.main(null);
		//				break;
		//			}else { //if end
		//				if(type.equals("fruit")) {
		//					setA("  |  orchard supplier: " + getExtra() + "\n");
		//				} else if(type.equals("vegetable")) {
		//					setA("  |  farm supplier: " + getExtra() + "\n");
		//				} else if(getType().equals("preserve")) {
		//					setA("  |  size : " + getExtra() + "ml\n") ;
		//				} //if-else end
		//			} //if-else end
		//		} //for end

		return "Item: " + this.itemCode + " " + this.name + " " + this.quantity + "  | price: $" + this.price +  "  |  cost: $" + this.cost + this.a ;
	} //toString end
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
	 * save extra information of product
	 * @param type
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}
	/**
	 * save string sentence for display
	 * @param a
	 */
	public void setA(String a) {
		this.a = a;
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
	 * storing extra information
	 * @return extra
	 */
	String getExtra() {
		return extra;
	}
	/**
	 * storing result
	 * @return a
	 */
	String getA() {
		return a;
	}
	/**
	 * read from Scanner passed in and fills data member
	 */
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
		if(e == -1) {
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
						type = "fruit";
						System.out.print("Enter the name of the orchard supplier: ");
						extra = sc.nextLine();
						a = "  |  orchard supplier: " + extra + "\n";
						error = 2;
						break;
					case "v": //if vegetable
						type = "vegetable";
						System.out.print("Enter the name of the farm supplier: ");
						extra = sc.nextLine();
						a = "  |  farm supplier: " + extra + "\n";
						error = 2;
						break;
					case "p": //if preserve
						type = "preserve";
						System.out.print("Enter the size of the jar in millilitres: ");
						extra = sc.nextLine();
						a = "  |  size : " + extra + "ml\n";
						error = 2;
						break;
					default:
						System.out.println("Invalid entry");
						break;
					} //switch end
				} catch(InputMismatchException m) {
					System.out.println("Invalid entry");
				}catch (Exception ex) {
					System.out.println("errorrrr");
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
	boolean updateItem(Scanner sc, int index, int buy_sell) {
		Inventory in = new Inventory();

		int updatingQuantity;
		boolean b = false;
		String bs = null;

		if(buy_sell == 1) {
			bs = "buy";
		}else if(buy_sell ==2) {
			bs = "sell";
		} //if-else end

		try {
			System.out.printf("Enter valid quantity to %s: \n", bs);
			updatingQuantity = sc.nextInt();
			in.updateQuantity(updatingQuantity, index, bs);
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
	boolean isEqual(Scanner sc, int num) {
		boolean tf = false; //true or false //success or failure
		for(int i=0; i < inventory.length; i++) {
			System.out.print("Enter valid item code: ");
			int checkCode = sc.nextInt();
			if (inventory[i] != null) { //if value is exists //error//how to check the code?????
				System.out.println("in if loop");
				if(inventory[i].itemCode == checkCode) {
					updateItem(sc, i, num);
					tf = true; //if success
					break;
				} //if end
			} else {
				System.out.println("Code not found in inventory...");
				tf = false; //if not success
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
		boolean b = false;

		if(num == 1) {
			b = true;
		} else if(num == 2) {
			b = false;
		} //if-else end

		while(true) {
			try {
				isEqual(sc, num); //send input value to another method //error
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid code");
			} //try-catch		
		} //while end

		return b;
	} //inputCode end
} //FoodItem class end
