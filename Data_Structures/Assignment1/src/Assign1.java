/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * Assign1 class display main menu with validate entry checking.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * Assign1 class display main menu with validate entry checking                                                        
 *
 */
class Assign1 {
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
					i.addItem(sc);
					break;
				case 2: //display inventory
					System.out.println("Inventory :\n" + i);
					break;
				case 3: //buy item
					bs = true;
					i.updateQuantity(sc, bs);
					break;
				case 4: //sell item
					bs = false;
					i.updateQuantity(sc, bs);
					break;
				case 5: //exit
					sc.close();
					System.out.println("Exiting...");
					System.exit(0);
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
		System.out.println("5: To Exit");
		System.out.print("> ");
	} //displayMenu end
} //Assign1 class end
