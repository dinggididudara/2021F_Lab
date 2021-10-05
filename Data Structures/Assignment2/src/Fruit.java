/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * fruit product
 */
import java.util.Scanner;
/**
 * Fruit class extends FoodItem 
 * scan information about fruit, print
 *
 */
public class Fruit extends FoodItem{
	String orchard;
	/**
	 * addItem orchard supplier
	 * @param sc scanner
	 * @return true if succeed
	 */
	@Override
	boolean addItem(Scanner sc) {
		super.addItem(sc);
		System.out.print("Enter the name of the orchard supplier: ");
		orchard = sc.nextLine();
		return true;
	}
	/**
	 * toString print orchard supplier
	 * @return print orchard supplier
	 */
	@Override
	public String toString() {
		return super.toString() + "  |  orchard supplier: " + orchard + "\n";
	}
} //Fruit end
