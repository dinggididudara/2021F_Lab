/**
 * CET - CS Academic Level 3
 * Linear and Binary Search
 * Student Name: Soomin
 * Student Number: 040899389 
 * Section #:301
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
package Lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Lab2BinLinSearchTest : Main method, displaying main menu
 * 
 *
 */
public class Lab2BinLinSearchTest {
	/**
	 * main method : displaying main menu and leading to that option
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryLinearSearch b = new BinaryLinearSearch();
		while(true) {
		try {
			System.out.println("Select your option in the menu:");
			System.out.println("1.Initialize and populate an array of 30 random integers.");
			System.out.println("2.Perform recursive binary and linear search.");
			System.out.println("3.Perform iterative binary and linear search.");
			System.out.println("4.Exit");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				b.generateRandomInts(sc);
				break;
			case 2:
				b.recursiveBinarySearch(sc);
				break;
			case 3:
				b.iterativeBinarySearchResult(sc);
				break;
			case 4:
				sc.close();
				System.out.println("exiting...");
				System.exit(0);
			default:
				System.err.println("Please choose the option 1 to 4.");
				break;
			} //switch-case end
			}catch(InputMismatchException ime) {
				System.err.println("*****Input Mismatch Exception*****");
			}catch (Exception e) {
				System.err.println("error");
			} //try-catch end
		} //while end
	} //main end
} //Lab2BinLinSearchTest class end
