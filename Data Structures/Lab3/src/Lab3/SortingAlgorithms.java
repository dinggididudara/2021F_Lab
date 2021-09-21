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

import java.util.Scanner;

/**
 * 
 * sorting algorithms : Bubble sort, Insertion sort, Selection sort, Merge sort, Quick sort
 *
 */
public class SortingAlgorithms {

	void menuDisplay() { //menu display
		System.out.println("Select a sorting algorithm to sort the data array");
		System.out.println("\tB. Bubble Sort");
		System.out.println("\tI. Insertion Sort");
		System.out.println("\tS. Selection Sort");
		System.out.println("\tM. Merge Sort");
		System.out.println("\tQ. Quick Sort");
		System.out.println("\tR. Return to Main Menu");

		Scanner sc = new Scanner(System.in);
		byte option = sc.nextByte();

		switch(option) {
		case 'B':
			break;
		case 'I':
			break;
		case 'S':
			break;
		case 'M':
			break;
		case 'Q':
			break;
		case 'R':
			break;
		default:
			System.out.println("");
			break;
		} //switch-case end
	}
	/**
	 * 
	 */
	void bubbleSort() {
		System.out.println("Bubble Sort: Simple sorting algorithm\t- o(n2) Complexity -");
	} //bubble sort end
	/**
	 * 
	 */
	void insertionSort() {
		System.out.println("Insertion Sort: Simple sorting algorithm\t- o(n2) Complexity -");
	} //insertion sort end
	/**
	 * 
	 */
	void selectionSort() {
		System.out.println("Selection Sort: Simple sorting algorithm\t- o(n2) Complexity -");
	} //selection sort end
	/**
	 * 
	 */
	void mergeSort() {
		System.out.println("Merge Sort: Simple sorting algorithm\t- o(n log n) Complexity -");
	} //merge sort end
	/**
	 * 
	 */
	void quickSort() {
		System.out.println("Quick Sort: Simple sorting algorithm\t- o(n log n) Complexity -");
	} //quick sort end
	/**
	 * nanoTime : calculate taken time in nano seconds
	 */
	void nanoTime(long startTimeNano, long endTimeNano){ //get time in nano
		System.out.println("Time taken in nanoseconds: " + (endTimeNano-startTimeNano));
	} //nanoTime end
	/**
	 * currentTimeMills : calculate taken time in million seconds
	 */
	void currentTimeMills(long startTimeMil, long endTimeMil){ //get current time in mills
		System.out.println("Time taken in milliseconds: " + (endTimeMil-startTimeMil));
		System.out.println("");
	} //currentTimeMills end
} //sortingAlgorithms end
