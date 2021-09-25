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
	protected long startTimeNano; //for checking time - nano
	protected long endTimeNano; //for checking time - nano
	protected long startTimeMil; //for checking time - milli
	protected long endTimeMil; //for checking time - milli

	void menuDisplay(int[] randomArr) { //menu display
		while(true) {
			System.out.println("Select a sorting algorithm to sort the data array");
			System.out.println("");
			System.out.println("\tB. Bubble Sort");
			System.out.println("\tI. Insertion Sort");
			System.out.println("\tS. Selection Sort");
			System.out.println("\tM. Merge Sort");
			System.out.println("\tQ. Quick Sort");
			System.out.println("\tR. Return to Main Menu");
			System.out.println("");
			System.out.print(">");
			Scanner sc = new Scanner(System.in);
			byte option = sc.nextByte();

			switch(option) {
			case 'B':
				bubbleSort(randomArr);
				break;
			case 'I':
				insertionSort(randomArr);
				break;
			case 'S':
				selectionSort(randomArr);
				break;
			case 'M':
				mergeSort(randomArr);
				break;
			case 'Q':
				break;
			case 'R':
				System.out.println("Returning to main menu...");
				//return to the main method
				break;
			default:
				System.err.println("Invalid option, please try again");
				break;
			} //switch-case end
		} //while end
	} //menuDisplay end
	/**
	 * bubble sort: 
	 */
	void bubbleSort(int[] randomArr) {
		System.out.println("Bubble Sort: Simple sorting algorithm\t- o(n2) Complexity -");
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();

		//do sort
		System.out.print("[");
		for(int i=0; i < 20; i++) {

		}
		System.out.println("...]");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //bubble sort end
	/**
	 * insertion sort: using unsorted array
	 */
	void insertionSort(int[] randomArr) {
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		int nextTurn;

		//show unsorted array
		System.out.print("[");
		for(int i=0; i < 20; i++) {
			System.out.println(randomArr[i]);
		}
		System.out.println("...]");

		//doing insertion sorting
		System.out.println("Insertion Sort: Simple sorting algorithm\t- o(n2) Complexity -");

		System.out.println("[");
		for(int j=0;j<20;j++) {
			for(int z = j; z > 0; z--) {
				if(randomArr[z] > randomArr[z+1]) {
					randomArr[z] = randomArr[z+1];
					randomArr[z+1] = randomArr[z];
				} else {
					break;
				} //else-if end
			}
			System.out.println(randomArr[j]);
		} //for end
		System.out.println("...]");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //insertion sort end
	/**
	 * Selection sort
	 */
	void selectionSort(int[] randomArr) {
		
		

		//do sort
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		System.out.println("Selection Sort: Simple sorting algorithm\t- o(n2) Complexity -");
		System.out.print("[");
		for(int i=0; i < 20; i++) {

		}
		System.out.println("...]");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //selection sort end
	/**
	 * Merge Sort
	 */
	void mergeSort(int[] randomArr) {
		System.out.println("[");
		for(int i=0;i < 20;i++) {
			System.out.print(randomArr[i]);
		}
		System.out.println("...]");
		System.out.println("");
		
		//do sort
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		System.out.println("Merge Sort: Simple sorting algorithm\t- o(n log n) Complexity -");
		System.out.println("");
		System.out.print("[");
		for(int i=0; i < 20; i++) {
			//cut half,half,half,half,...and copy
		}
		System.out.println("...]");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //merge sort end
	/**
	 * Quick Sort : using unsorted array
	 */
	void quickSort(int[] randomArr) {
		printUnsortedArr(randomArr);		
		//do sort
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		
		int pivot = randomArr[0];
		System.out.println("Quick Sort: Simple sorting algorithm\t- o(n log n) Complexity -");
		System.out.println("");
		System.out.print("[");
		for(int i=1; i < 20; i++) {
			if(pivot > randomArr[i]) {
				randomArr[i] = pivot;
				randomArr[i-1] = randomArr[i]; //change position
			} else {
				continue;
			}
		}
		System.out.println("...]");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //quick sort end
	/**
	 * printUnsortedArr : printing unsorted Array for the sorting
	 * @param randomArr random array from TestSortSearch class
	 */
	void printUnsortedArr(int[] randomArr) {
		System.out.println("[");
		for(int i=0;i<20;i++) {
			System.out.print(randomArr[i]);
		}
		System.out.println("...]");
		System.out.println("");
	}
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
