/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * fruit product
 */
import java.util.Scanner;

public class Fruit extends FoodItem{
	String type;
	String orchard;
	
	@Override
	boolean addItem(Scanner sc) {
		super.addItem(sc);
		type = "fruit";
		System.out.print("Enter the name of the orchard supplier: ");
		orchard = sc.nextLine();
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "  |  orchard supplier: " + orchard + "\n";
	}
} //Fruit end
