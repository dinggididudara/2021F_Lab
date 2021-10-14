/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 2
 * October-10-2021
 * vegetable product
 */
import java.io.Serializable;
import java.util.Formatter;
import java.util.Scanner;
/**
 * Vegetable class extends FoodItem
 * scan information about vegetable, print
 *
 */
public class Vegetable extends FoodItem implements Serializable{
	String farm;
	/**
	 * addItem farm supplier
	 * @param sc scanner
	 * @return true if succeed
	 */
	@Override
	public boolean addItem(Scanner sc, boolean fromFile) {
		super.addItem(sc, fromFile);
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
	/**
	 * @param writer formatter for file
	 */
	@Override
	public void outputItem(Formatter writer) {
		
	}
} //vegetable class end
