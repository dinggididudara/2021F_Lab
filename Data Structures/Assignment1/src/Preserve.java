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
	int size;
	
	@Override
	boolean addItem(Scanner sc) {
		type = "preserve";
		System.out.print("Enter the size of the jar in millilitres: ");
		size = sc.nextInt();
		
		return true;
	}
	
	@Override
	public String toString() {
		return "  |  size : " + size + "ml\n";
	}
} //Preserve class end
