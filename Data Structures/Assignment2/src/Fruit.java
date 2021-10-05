/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 2
 * October-10-2021
 * fruit product
 */
import java.util.Formatter;
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
	public boolean addItem(Scanner sc, boolean fromFile) {
		super.addItem(sc, fromFile);
		System.out.print("Enter the name of the orchard supplier: ");
		orchard = sc.nextLine();
		return true;
	} //addItem end
	/**
	 * toString print orchard supplier
	 * @return print orchard supplier
	 */
	@Override
	public String toString() {
		return super.toString() + "  |  orchard supplier: " + orchard + "\n";
	} //toString end
	/**
	 * @param writer formatter for file
	 */
	@Override
	public void outputItem(Formatter writer) {
		
	}
} //Fruit end
