/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * preserve product
 */
import java.util.Scanner;
/**
 * Preserve class extends FoodItem
 * scan preserve product, print
 *
 */
public class Preserve extends FoodItem{
	double size;
	/**
	 * addItem size of the jar
	 * @param sc scanner
	 * @return true if succeed
	 */
	@Override
	boolean addItem(Scanner sc) {
		super.addItem(sc);
		System.out.print("Enter the size of the jar in millilitres: ");
		size = sc.nextDouble();
		return true;
	} //addItem end
	/**
	 * toString print size of the jar
	 * @return print size
	 */
	@Override
	public String toString() {
		return super.toString() + "  |  size : " + size + "mL\n";
	}
} //Preserve class end
