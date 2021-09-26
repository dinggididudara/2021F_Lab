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
package Lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TestSortSearch : Main method, displaying main menu
 * 
 *
 */
public class TestSortSearch {
	/**
	 * main method : displaying main menu and leading to that option
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryLinearSearch b = new BinaryLinearSearch();
		SortingAlgorithms s = new SortingAlgorithms();
		while(true) {
		try {
			System.out.println("Select your option in the menu below:");
			System.out.println("1: Initialize and populate an array of 1000 random integers.");
			System.out.println("2: Perform recursive binary and linear search.");
			System.out.println("3: Perform iterative binary and linear search.");
			System.out.println("4: Sort the array");
			System.out.println("5: Quit");
			System.out.print(">");
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
				s.menuDisplay(sc, b.randomArr);
				break;
			case 5:
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
} //TestSortSearch class end
