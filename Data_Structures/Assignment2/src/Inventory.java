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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Inventory class storing food item in inventory
 *
 */
class Inventory implements Serializable, Comparator<FoodItem>{	
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

	@SuppressWarnings("unchecked")
	void inventoryFromFile(ArrayList<FoodItem> inventory){
		this.inventory = (ArrayList<FoodItem>) inventory.clone(); //copy to current inventory
	}
	/**
	 * display of inventory
	 */
	public String toString() {
		String result = "";

		if(numItems == 0) { //if user input anything yet
			result = "";
		} else {
			inventory.sort(Comparator.comparing(inventory -> inventory.getItemCode()));//sort array
			for(int i=0; i < numItems; i++) {
				if(inventory.get(i) != null) {
					result += inventory.get(i).toString() + "\n";
				} //if end
			} //for end
			result += "\n";
		} //if-else end
		return result;
	} //toString end
	/**
	 * adding item to inventory array list and to file
	 */
	public boolean addItem(Scanner sc, boolean fromFile) {
		if(fromFile) {

		} else {
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

			if(item.inputCode(sc, fromFile)) { //if input code valid = true
				if(alreadyExists(item)==-1) { //send the object to another method
					if(item.addItem(sc, fromFile)) { //if adding item succeed
						inventory.add(numItems,item); //put object to array
						numItems++;
						return true;
					} //if end
					return false;
				} else {
					System.out.println("Item code already exists");
					return false;
				} //if-else end	
			} //if end
		} //if end
		return true;
	} //addItem end
	/**
	 * scan user input item for search, and binary search in inventory from file
	 * @param sc
	 */
	public void searchForItem(Scanner sc) {
		FoodItem fi = new FoodItem();
		boolean in = fi.inputCode(sc, false); //true for 'it is from file'
		if(in) { //if input code is success
			int a = alreadyExists(fi);
			if(a != -1) { //if code is in the file
				System.out.println(inventory.get(a).toString());
			} else {
				System.out.println("Code not found in inventory...");
			}//if end
		} //if end
	} //searchForItem end
	/**
	 * return index of food item array (inventory)
	 * check if item code already exists or not - during add item
	 * @param item FoodItem from updateQuantity method
	 */
	int alreadyExists(FoodItem item) {
		int c=-1;
		for(int i=0;i < numItems;i++) {
			c = compare(item, inventory.get(i)); //using comparator
			if (c == 0) { //if matches 
				return i; //return index
			} //if-else end
		} //for end
		return -1; //not input that code yet
	} //alreadyExists end
	/**
	 * write new object to file
	 * @param sc
	 * @throws IOException 
	 */
	public void saveToFile(Scanner sc){		
		System.out.print("Enter the filename to save to: ");
		String filename = sc.next();
		filename = "C:" + File.separator + "OneDrive" + File.separator + "JAVA" + File.separator + "2021F_Lab" + File.separator + "Data_Structures" + File.separator + "Assignment2" + File.separator + "src" + File.separator + filename;
		Path path = Paths.get(filename); //file path
		try {
			if(inventory.isEmpty()) { //if inventory is empty
				System.out.println("inventory is empty now.");
			} else { //if inventory is not empty
				if(!Files.exists(path)) { //if file name is not exists
					File file = new File(filename);
					file.createNewFile(); //create new file
					FileOutputStream output = new FileOutputStream(file, false);
					ObjectOutputStream objectOutput = new ObjectOutputStream(output);

					objectOutput.writeObject(inventory);//write array list to the file

					inventory.clear(); //clear the array list
					output.close(); //close output
					objectOutput.close(); //close object output
				} else { //if file name already exists
					System.out.println("File already exists.");
				} //if-else end
			} //if-else end
		} catch (IOException e) {
			System.out.println("Error Encountered while reading the file, aborting...");
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
		String filename = sc.next(); //filename scan
		filename = "C:" + File.separator + "OneDrive" + File.separator +"JAVA" + File.separator + "2021F_Lab" + File.separator + "Data_Structures" + File.separator + "Assignment2" + File.separator + "src" + File.separator + filename;
		Path path = Paths.get(filename); //file path

		if(!Files.exists(path)) { //if file exists
			System.out.println("File Not Found, ignoring...");
		} else if(Files.exists(path)){ //if file exist
			try {
				File file = new File(filename); //new file
				FileInputStream input = new FileInputStream(file); //file input stream
				ObjectInputStream objectInput = new ObjectInputStream(input); //input object
				
				inventory.addAll((ArrayList<FoodItem>) objectInput.readObject()); //save to inventory array list
				numItems = inventory.size();
				
				inventoryFromFile(inventory);

				System.out.println(); //new line

				input.close(); //close file input stream
				objectInput.close(); //close object input stream
			} catch(FileNotFoundException fnf) {
				System.out.println("File not found, ignoring...");
			} catch(ClassNotFoundException ce) {
				System.out.println("Error Encountered while reading the file, aborting..."
						+ "");
			} catch(IOException ioe) {
				System.out.println("Error File cannot open.");
			} //try-catch end

		} //if-else end
	} //readFromFile
	/**
	 * read item code to update quantity in inventory array.
	 * bs = true = buying
	 * bs = false = selling
	 * @param sc Scanner
	 * @param bs boolean buy or sell
	 */
	boolean updateQuantity(Scanner sc, boolean bs) {
		if(numItems == 0) { //if user input anything yet
			return false;
		} //if end
		FoodItem fi = new FoodItem();
		fi.inputCode(sc, false);
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
	@Override
	public int compare(FoodItem o1, FoodItem o2) {
		return o1.getItemCode()-o2.getItemCode();
	}
} //Inventory class end
