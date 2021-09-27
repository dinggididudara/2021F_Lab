/**
 * 
 */
package Assignment1;

import java.util.Scanner;

public class Assign1 {

	public static void main(String[] args) {
		displayMenu();
	} //main end
	
	static void displayMenu() {
		Scanner sc = new Scanner(System.in);
		int option;
		FoodItem f = new FoodItem();
		Inventory i = new Inventory();
		while(true) {
			System.out.println("Please select one of the following:");
			System.out.println("1: Add Item to Inventory");
			System.out.println("2: Display Current Inventory");
			System.out.println("3: Buy Item(s)");
			System.out.println("4: Sell Item(s)");
			System.out.println("5: To Exit");
			System.out.println("> ");
			option = sc.nextInt();
			
			switch(option) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				sc.close();
				System.out.println("Exiting...");
				System.exit(0);
			default:
				break;
			}
		} //while end
	} //displayMenu end
} //Assign1 class end
