/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 2
 * October-10-2021
 * Assign2 class display main menu with validate entry checking.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * Assign1 class display main menu with validate entry checking
 *
 */
class Assign2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		boolean bs; //buy = true, sell = false	
		Inventory i =  new Inventory();	
		while(true) {
			try {
				displayMenu();
				option = sc.nextInt();

				switch(option) {
				case 1: //add item
					i.addItem(sc, false);
					break;
				case 2: //display inventory
					System.out.println("Inventory :\n" + i);
					break;
				case 3: //buy itembs: bo
					bs = true;
					i.updateQuantity(sc, bs);
					break;
				case 4: //sell item
					bs = false;
					i.updateQuantity(sc, bs);
					break;
				case 5:
					i.searchForItem(sc); //search for item
					break;
				case 6:
					i.saveToFile(sc);
					break;
				case 7:
					i.readFromFile(sc);
					break;
				case 8:
					sc.close();
					System.out.println("Exiting...");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid entry");
					break;
				} //switch end
			} catch (InputMismatchException e) {
				System.out.println("Invliad entry");
			} //try-catch end
		} //while end		
	} //main end
	/**
	 * display the main menu
	 */
	static void displayMenu() {
		System.out.println("Please select one of the following:");
		System.out.println("1: Add Item to Inventory");
		System.out.println("2: Display Current Inventory");
		System.out.println("3: Buy Item(s)");
		System.out.println("4: Sell Item(s)");
		System.out.println("5: Search for Item");
		System.out.println("6: Save Inventory to File");
		System.out.println("7: Read Inventory from File");
		System.out.println("8: To Exit");
		System.out.print("> ");
	} //displayMenu end
} //Assign1 class end
