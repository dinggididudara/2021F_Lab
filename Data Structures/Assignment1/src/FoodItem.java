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
import java.lang.Comparable;
//implements Comparable<FoodItem>
class FoodItem extends Assign1{
	protected String type;

	private int itemCode = 0;
	private String name;
	private int quantity;
	private double price;
	private double cost;
	private String extra; //extra information
	//	protected String fruitOrchard; //fruit
	//
	//	protected String vegFarm; //vegetable
	//
	//	protected double preJar;  //preserve
	private String a;
	/**
	 * 
	 */
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
	 * display the all data members in the class
	 */	
	@Override
	public String toString() {
		if (inventory[0] == null) {
			System.out.println("yes it is null");
			Assign1.main(null);
		}else { //if end
			if(getType().equals("fruit")) {
				setA("  |  orchard supplier: " + getExtra() + "\n");
			} else if(getType().equals("vegetable")) {
				setA("  |  orchard supplier: " + getExtra() + "\n");
			} else if(getType().equals("preserve")) {
				setA("  |  size : " + getExtra() + "\n") ;
			} //if-else end
		} //if-else end
			return "Item: " + getItemCode() + " " + getName() + " " + getQuantity() + "  | price: $" + getPrice() +  "  |  cost: $" + getCost() + getA() ;
			//				return "Item: " + getItemCode() + " " + getName() + " " + getQuantity() + "  | price: $" + getPrice() +  "  |  cost: $" + getCost() + getA() ;
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
				} else {
					break;
				} //if-else end
			} //while end
			
			System.out.print("Enter the code for the item: ");
			itemCode = sc.nextInt();
			sc.nextLine();
			
			System.out.println("before already exists");/////////
			int e = i.alreadyExists(sc, itemCode); //check the code if it already exists
			System.out.println(e);////////////////
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
							error = 2;
							break;
						case "v": //if vegetable
							type = "vegetable";
							System.out.print("Enter the name of the farm supplier: ");
							extra = sc.nextLine();
							error = 2;
							break;
						case "p": //if preserve
							type = "preserve";
							System.out.print("Enter the size of the jar in millilitres: ");
							extra = sc.nextLine();
							error = 2;
							break;
						default:
							System.out.println("Invalid entry");
							break;
						} //switch end
						//					FoodItem fi = new FoodItem(type, itemCode, name, quantity, price, cost, extra);
						new FoodItem(type, itemCode, name, quantity, cost, price, extra);
					} catch(InputMismatchException m) {
						System.out.println("Invalid entry");
					}catch (Exception ex) {
						System.out.println("Invalid entry");
					}
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
			//
			//		if(a == true) { //buying
			//			System.out.print("Enter valid quantity to buy: ");
			//			buyQuantity = sc.nextInt();
			//			in.updateQuantity(sc, buyQuantity, index, bs);
			//			b = true;
			//		}else if(a == false){ //selling
			//			System.out.print("Enter valid quantity to sell: ");
			//			sellQuantity = sc.nextInt();
			//			in.updateQuantity(sc, sellQuantity, index, bs);
			//			b = true;
			//		} else{ //if number is not valid
			//			System.out.printf("Error...could not %s item.\n", bs);
			//			b = false;			
			//		} //if-else end

			return b; //succeed = true, fail = false
		} //updateItem
		/**
		 * if item code exists = return true
		 * 2.check input code is in the array
		 * @return true for success , false for fail
		 */
		boolean isEqual(Scanner sc, int checkCode, int num) {
			boolean tf = false; //true or false //success or failure
			for(int i=0; i < inventory.length; i++) {
				if (inventory[i].getItemCode() == checkCode) { //if value is exists //error//how to check the code?????
					updateItem(sc, i, num);
					tf = true; //if success
					break;
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
					isEqual(sc, checkCode, num); //send input value to another method //error
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid code");
				} //try-catch		
			} //while end

			return b;
		} //inputCode end
	} //FoodItem class end
