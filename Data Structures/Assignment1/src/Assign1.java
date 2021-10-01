/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 */
import java.util.InputMismatchException;
import java.util.Scanner;

class Assign1 {
	protected static FoodItem[] inventory = new FoodItem[20]; //array for storing food item inventory
	protected static FoodItem[] invencpy = new FoodItem[20];
	public static void main(String[] args) {
		displayMenu();
	} //main end
	/**
	 * display the main menu
	 */
	static void displayMenu() {
		Inventory i =  new Inventory();		
		FoodItem f;
		Scanner sc = new Scanner(System.in);
		int option;
		
		while(true) { //main menu
			try {
				f = new FoodItem();
				
				System.out.println("Please select one of the following:");
				System.out.println("1: Add Item to Inventory");
				System.out.println("2: Display Current Inventory");
				System.out.println("3: Buy Item(s)");
				System.out.println("4: Sell Item(s)");
				System.out.println("5: To Exit");
				System.out.print("> ");
				option = sc.nextInt();
				
				switch(option) {
				case 1: //add item
					f.addItem(sc);
					break;
				case 2: //display inventory
					System.out.println("Inventory :");
					f.toString();
					break;
				case 3: //buy item

					f.inputCode(sc, 1);
					break;
				case 4: //sell item
					f.inputCode(sc, 2);
					break;
				case 5:
					sc.close();
					System.out.println("Exiting...");
					System.exit(0);
				default:
					System.out.println("Invalid entry");
					break;
				}
			} catch(InputMismatchException m) {
				System.out.println("Invalid entry");
			} catch (Exception e) {
				System.out.println("Error");
			}
		} //while end
	} //displayMenu end
} //Assign1 class end
