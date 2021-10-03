/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * preserve product
 */
import java.util.Scanner;

public class Preserve extends FoodItem{
	String type;
	double size;
	
	@Override
	boolean addItem(Scanner sc) {
		super.addItem(sc);
		type = "preserve";
		System.out.print("Enter the size of the jar in millilitres: ");
		size = sc.nextDouble();
		
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "  |  size : " + size + "mL\n";
	}
} //Preserve class end
