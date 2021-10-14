/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 2
 * October-10-2021
 * preserve product
 */
import java.io.Serializable;
import java.util.Formatter;
import java.util.Scanner;
/**
 * Preserve class extends FoodItem
 * scan preserve product, print
 *
 */
public class Preserve extends FoodItem implements Serializable{
	double size;
	/**
	 * addItem size of the jar
	 * @param sc scanner
	 * @return true if succeed
	 */
	@Override
	public boolean addItem(Scanner sc, boolean fromFile) {
		super.addItem(sc, fromFile);
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
	/**
	 * @param writer formatter for file
	 */
	@Override
	public void outputItem(Formatter writer) {
		
	}
} //Preserve class end
