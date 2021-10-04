/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * vegetable product
 */
import java.util.Scanner;
/**
 * Vegetable class extends FoodItem
 * scan information about vegetable, print
 *
 */
public class Vegetable extends FoodItem{
	String farm;
	/**
	 * addItem farm supplier
	 * @param sc scanner
	 * @return true if succeed
	 */
	@Override
	boolean addItem(Scanner sc) {
		super.addItem(sc);
		System.out.print("Enter the name of the farm supplier: ");
		farm = sc.nextLine();
		return true;
	} //addItem
	/**
	 * toString print farm supplier
	 * @return print farm supplier
	 */
	@Override
	public String toString() {
		return super.toString() + "  |  farm supplier: " + farm + "\n";
	} //toString
} //vegetable class end
