/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 2
 * October-10-2021
 * Inventory class  inventory for food items
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Inventory class storing food item in inventory
 *
 */
class Inventory implements Serializable{	
	/**
	 * default serial version uid
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FoodItem> inventory; //array for storing food item inventory
	private final int NUM = 20; //array size
	private int numItems=0; //user entered items' number
	/**
	 * initialize the array
	 */
	Inventory(){
		inventory = new ArrayList<FoodItem>(NUM);
	} //Inventory end
	/**
	 * display of inventory
	 */
	public String toString() {
		String result = "";

		if(numItems == 0) { //if user input anything yet
			result = "";
		} else {
			for(int i=0; i < numItems; i++) {
				if(inventory.get(i) != null) {
					result += inventory.get(i).toString();
				} //if end
			} //for end
		} //if-else end
		return result;
	} //toString end
	/**
	 * adding item to inventory array list and to file
	 */
	public boolean addItem(Scanner sc, boolean fromFile) {
		if(numItems == 20) {
			System.out.println("Inventory is full now");
			return false;
		} //if end
		boolean b = false;
		FoodItem item = null;
		while(!b) { //while true
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
			String type = sc.next();
			if(type.equals("f") || type.equals("v") || type.equals("p")) {
				switch(type) { //type of the product
				case "f": //if fruit
					item = new Fruit();	
					break;
				case "v": //if vegetable
					item = new Vegetable();	
					break;
				case "p": //if preserve
					item = new Preserve();	
					break;
				default:
					System.out.println("Invalid entry");
					break;
				} //switch end		
				b = true; //break while loop
			} else {
				System.out.println("Invalid entry");
				b = false;
			} //if-else end
		} //while end
		if(item.inputCode(sc)) { //if input code valid = true
			if(alreadyExists(item)==-1) { //send the object to another method
				if(item.addItem(sc)) { //if adding item succeed
					inventory.add(item); //put object to array
					numItems++;
					return true;
				} //if end
				return false;
			} else {
				System.out.println("Item code already exists");
				return false;
			} //if-else end	
		} //if end
		return true;
	} //addItem end
	/**
	 * scan user input item for search, and binary search in inventory
	 * @param sc
	 */
	public void searchForItem(Scanner sc) {
		System.out.print("Enter the code for the item: ");
		int searchItem = sc.nextInt();

		readFromFile(sc);
		boolean tf = true; //true if has code
		int index = -1; //index for the matching item

		for(int i=0;i<inventory.size();i++) {
			if(inventory.get(i).getItemCode() == searchItem) { //if found
				printFromFile(inventory, i);
				break;
			} else {
				tf = false;
			}
		} //for end
		if(!tf) {
			System.out.println("Code not found in inventory...");
		}
	}
	/**
	 * write new object to file
	 * @param sc
	 * @throws IOException 
	 */
	public void saveToFile(Scanner sc){		
		System.out.print("Enter the filename to save to: ");
		File file = new File(sc.nextLine());
		try {
			if(!file.exists()) { //if file name is not exists
				FileOutputStream output = new FileOutputStream(file);
				ObjectOutputStream objectOutput = new ObjectOutputStream(output);

				objectOutput.writeObject(inventory);//write array list to the file

				output.close(); //close output
				objectOutput.close(); //close object output
			} else { //if file name already exists

			} //if-else end
			} catch (IOException e) {
				System.out.println("File Not Found, ignoring...");
			} //try-catch end
	} //saveToFile end
	/**
	 * read from file
	 * @param sc Scanner for reading file name from user
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void readFromFile(Scanner sc) {
		System.out.print("Enter the filename to read from: ");
		File file = new File(sc.nextLine()); //new file 

		if(!file.exists()) { //if file not exists
			System.out.println("File Not Found, ignoring...");
		} else { //if file exist
			ArrayList<FoodItem> inventory = new ArrayList<FoodItem>();
			try {
				FileInputStream input = new FileInputStream(file); //file input stream
				ObjectInputStream objectInput = new ObjectInputStream(input);
				inventory = (ArrayList<FoodItem>) objectInput.readObject();

				if(!inventory.isEmpty()) { //if array list is not empty
					
				} else { //if array list is empty
					System.out.println("Empty now");
				} //if-else end
					
				input.close(); //close file input stream
				objectInput.close(); //close object input stream
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch(ClassNotFoundException ce) {
				System.out.println("File not accessible");
			} catch(IOException ioe) {
				System.out.println("Error File cannot open.");
			} //try-catch end
		} //if-else end
	} //readFromFile
	/**
	 * print from file with array list inventory
	 * @param inventory
	 */
	public void printFromFile(ArrayList<FoodItem> inventory, int index) {
		inventory.get(index).toString(); //print all objects(FoodItem) in array list
	} //printFromFile end

	/**
	 * return index of food item array (inventory)
	 * check if item code already exists or not - during add item
	 * @param item FoodItem from updateQuantity method
	 */
	int alreadyExists(FoodItem item) {
		
		
		for(int i=0;i < numItems;i++) {
			compare(item, inventory.get(i));
			
			if (inventory.get(i).isEuqal(item)) { 
				return i;
			} //if-else end
		} //for end
		return -1; //not input that code yet
	} //alreadyExists end
	/**
	 * read item code to update quantity in inventory array.
	 * bs = true = buying
	 * bs = false = selling
	 * @parms sc Scanner
	 * @bs boolean buy or sell
	 */
	boolean updateQuantity(Scanner sc, boolean bs) {
		if(numItems == 0) { //if user input anything yet
			return false;
		} //if end
		FoodItem fi = new FoodItem();
		fi.inputCode(sc);
		int index = alreadyExists(fi); //check the code is already exists or not
		if(index != -1) {
			while(true) {
				String buysell = bs?"buy":"sell"; //if bs is true buy, false sell
				System.out.print("Enter valid quantity to " + buysell + ": ");
				if(sc.hasNextInt()) { //if valid quantity
					int amount = sc.nextInt();
					if(amount > 0 && amount <= inventory.get(index).getQuantity()) { //if right amount
						return inventory.get(index).updateItem(bs?amount:amount*-1); //if buy send amount, sell send //return the amount is valid or not
					} else {
						System.out.println("Invalid quantity...");
						return false;
					} //if-else end
				} else { //if has index = code already exists
					System.out.printf("Error...could not %s item\n", buysell);
				} //if-else end
			} //while end
		} else if(index == -1) {
			System.out.println("Code not found in inventory...");
		} //if-else end
		return false;
	} //updateQuantity
} //Inventory class end
