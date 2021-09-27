/**
 * 
 */
package Assignment1;

import java.util.Scanner;

public class Inventory {
	String option;
	Inventory(Scanner sc){
		System.out.println("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
		option = sc.next();

		switch(option) {
		case "f":
			break;
		case "v":
			break;
		case "p":
			break;
		default:
			break;
		}
	}
	/**
	 * 
	 */
	void addItem() {

	} //addItem end
	/**
	 * 
	 */
	void alreadyExists() {

	} //alreadyExists end
	/**
	 * 
	 */
	void updateQuantity() {

	} //updateQuantity
} //Inventory class end
