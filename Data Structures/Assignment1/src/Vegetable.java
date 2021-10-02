/**
 * CST - CS CST8130 301 Data Structures
 * Soomin Lee
 * 040899389
 * Assignment 1
 * September-30-2021
 * vegetable product
 */
import java.util.Scanner;

public class Vegetable extends FoodItem{
	String type;
	String farm;
	
	@Override
	boolean addItem(Scanner sc) {
		type = "vegetable";
		System.out.print("Enter the name of the farm supplier: ");
		farm = sc.nextLine();
		
		return true;
	} //addItem
	
	@Override
	public String toString() {
		return "  |  farm supplier: " + farm + "\n";
	} //toString
} //vegetable class end
