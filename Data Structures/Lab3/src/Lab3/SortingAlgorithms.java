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

	protected int[] temp; //using for merge sort. temporary array

	void menuDisplay(Scanner sc, int[] unsorted) { //menu display
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

			String option = sc.next();

			switch(option) {
			case "B":
				bubbleSort(unsorted);
				break;
			case "I":
				insertionSort(unsorted);
				continue;
			case "S":
				selectionSort(unsorted);
				continue;
			case "M":
				mergeSort(unsorted);
				continue;
			case "Q":
				quickSort(unsorted);
				continue;
			case "R":
				System.out.println("Returning to main menu...");
				System.out.println("");
				TestSortSearch.main(null);
				//return to the main method
				break;
			default:
				System.err.println("Invalid option, please try again");
				continue;
			} //switch-case end
		} //while end
	} //menuDisplay end
	
	/**
	 * bubble sort: compare two values right next, larger number send to the right side.
	 */
	void bubbleSort(int[] unsorted) {
		printArr(unsorted);		
		//do sort
		System.out.println("Bubble Sort: Simple sorting algorithm\t- o(n2) Complexity -");
		System.out.println("");
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		System.out.print("[");
		for(int i = 0; i < 20; i++) {
			for(int j = 1; j < (20-i); j++) {
				if(unsorted[j]<unsorted[j-1]) {
					int temp = unsorted[j-1];
					unsorted[j] = unsorted[j-1];
					unsorted[j-1] = temp;
				}
			} //for end
			System.out.print(unsorted[i] + " ");
		} //for end
		System.out.println("...]");
		System.out.println("");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //bubble sort end
	/**
	 * insertion sort: using unsorted array
	 */
	void insertionSort(int[] unsorted) {
		//show unsorted array
		printArr(unsorted);
		//doing insertion sorting
		System.out.println("Insertion Sort: Simple sorting algorithm\t- o(n2) Complexity -");
		System.out.println("");
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		System.out.print("[");
		for(int i=0;i<20;i++) {
			int key = unsorted[i];
			int j = i-1;
			while(j >= 0 && key < unsorted[j]) {
				int temp = unsorted[j];
				unsorted[j] = unsorted[j+1];
				unsorted[j+1] = temp;
			} //while end
			System.out.print(unsorted[i] + " ");
		}//for end
		System.out.println("...]");
		System.out.println("");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //insertion sort end
	/**
	 * Selection sort
	 * 
	 */
	void selectionSort(int[] unsorted) {
		printArr(unsorted);
		//do sorting
		System.out.println("Selection Sort: Simple sorting algorithm\t- o(n2) Complexity -");
		System.out.println("");
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();

		int min; //minimum index

		for(int i=0; i < 20; i++) {
			min = i;
			for(int j=i+1; j < 19; j++) { //searching the minimum value one by one
				if(unsorted[j] < unsorted[min]) { //if smaller than minimum index's value
					min = j;
					int temp = unsorted[i];
					unsorted[i] = unsorted[min];
					unsorted[min] = temp;
				} //if end
			} //for end
		} //for end
		System.out.print("[");
		for(int i=0;i<20;i++) {
			System.out.print(unsorted[i] + " ");
		}
		System.out.println("...]");
		System.out.println("");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //selection sort end
	/**
	 * Merge Sort : divide and conquer
	 */
	void mergeSort(int[] unsorted) {
		printArr(unsorted);
		//do sort
		System.out.println("Merge Sort: Simple sorting algorithm\t- o(n log n) Complexity -");
		System.out.println("");
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		System.out.print("[");
		mergeSort(unsorted, 0, 20);
		System.out.println("...]");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //merge sort end
	/**
	 * merge sort
	 * @param unsorted random array
	 * @param start start index
	 * @param end end index
	 */
	void mergeSort(int[] unsorted, int start, int end) {
		if(start >= end) {
			return;
		} //if end
		
		int mid = (start+end)/2; //find middle index
		mergeSort(unsorted, start, mid); //send start, end index / recursive with new parameters
		mergeSort(unsorted, mid+1, end); //send (middle point + 1) index, end index
		
		//merging
		int a = start;
		int b = mid + 1;
		int index = a;

		while (a <= mid || b <= end) { //within the range
			if(b > end || (a <= mid && unsorted[a] < unsorted[b])) { //if (b is smaller than end) or (a is smaller than middle index && a index value < b index value) 
				temp[index++] = unsorted[a++]; //put that next value in temporary array 
			} else { //if not
				temp[index++] = unsorted[b++]; //put next value of end index in temporary array - in next index number
			} //if-else end
		} //while end
		for(int i = a; i <= end; i++) { 
			unsorted[i] = temp[i]; //put temporary array to randomArr
		} //for end
	
	printArr(unsorted); //print array
} //mergeSort end
/**
 * Quick Sort : divide and conquer
 */
void quickSort(int[] unsorted) {
	//print unsorted array
	printArr(unsorted);		
	//do sort
	int pivot = unsorted[0];
	System.out.println("Quick Sort: Simple sorting algorithm\t- o(n log n) Complexity -");
	System.out.println("");
	
	startTimeNano = System.nanoTime();
	endTimeMil = System.currentTimeMillis();
	System.out.print("[");
	for(int i=1; i < 20; i++) {
		if(pivot >= unsorted[i]) {
			unsorted[i] = pivot;
			unsorted[i-1] = unsorted[i]; //change position
		} else {
			continue;
		} //if-else end
		System.out.print(unsorted[i] + " ");
	} //for end
	System.out.println("...]");

	endTimeNano = System.nanoTime();
	endTimeMil = System.currentTimeMillis();
	nanoTime(startTimeNano, endTimeNano);
	currentTimeMills(startTimeMil, endTimeMil);
} //quick sort end
/**
 * printUnsortedArr : printing unsorted Array for the sorting
 * @param unsorted random array from TestSortSearch class
 */
void printArr(int[] unsorted) {
	System.out.print("[");
	for(int i=0;i<20;i++) {
		System.out.print(unsorted[i] + " ");
	} //for end
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
