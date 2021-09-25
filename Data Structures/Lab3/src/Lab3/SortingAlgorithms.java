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
				continue;
			case 'S':
				selectionSort(randomArr);
				continue;
			case 'M':
				mergeSort(randomArr);
				continue;
			case 'Q':
				continue;
			case 'R':
				System.out.println("Returning to main menu...");
				//return to the main method
				break;
			default:
				System.err.println("Invalid option, please try again");
				continue;
			} //switch-case end
			break;
		} //while end
	} //menuDisplay end
	/**
	 * bubble sort: compare two values right next, larger number send to the right side.
	 */
	void bubbleSort(int[] randomArr) {
		printUnsortedArr(randomArr);		
		//do sort
		System.out.println("Bubble Sort: Simple sorting algorithm\t- o(n2) Complexity -");
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		System.out.print("[");
		for(int i = 0; i < 20; i++) {
			for(int j = 1; j < (20-i); j++) {
				if(randomArr[j]<randomArr[j-1]) {
					int temp = randomArr[j-1];
					randomArr[j] = randomArr[j-1];
					randomArr[j-1] = temp;
				}
			}
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
		//show unsorted array
		printUnsortedArr(randomArr);
		//doing insertion sorting
		System.out.println("Insertion Sort: Simple sorting algorithm\t- o(n2) Complexity -");
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		System.out.println("[");
		for(int i=0;i<20;i++) {
			int key = randomArr[i];
			int j = i=1;
			while(j>=0 && key < randomArr[j]) {
				int temp = randomArr[j];
				randomArr[j] = randomArr[j+1];
				randomArr[j+1] = temp;
			} //while end
			System.out.println(randomArr[i]);
		}//for end
		System.out.println("...]");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //insertion sort end
	/**
	 * Selection sort
	 * 
	 */
	void selectionSort(int[] randomArr) {
		printUnsortedArr(randomArr);
		//do sorting
		System.out.println("Selection Sort: Simple sorting algorithm\t- o(n2) Complexity -");
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();

		int min; //minimum index

		for(int i=0; i < 20; i++) {
			min = i;
			for(int j=i+1; j < 19; j++) { //searching the minimum value one by one
				if(randomArr[j] < randomArr[min]) { //if smaller than minimum index's value
					min = j;
					int temp = randomArr[i];
					randomArr[i] = randomArr[min];
					randomArr[min] = temp;
				} //if end
			} //for end
		} //for end
		System.out.print("[");
		for(int i=0;i<20;i++) {
			System.out.print(randomArr[i]);
		}
		System.out.println("...]");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //selection sort end
	/**
	 * Merge Sort : divide and conquer
	 */
	void mergeSort(int[] randomArr) {
		printUnsortedArr(randomArr);
		//do sort
		System.out.println("Merge Sort: Simple sorting algorithm\t- o(n log n) Complexity -");
		System.out.println("");
		startTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		System.out.print("[");
	
		mergeSort(randomArr, 0, )
		System.out.println("...]");

		endTimeNano = System.nanoTime();
		endTimeMil = System.currentTimeMillis();
		nanoTime(startTimeNano, endTimeNano);
		currentTimeMills(startTimeMil, endTimeMil);
	} //merge sort end
	/**
	 * merge sort :
	 * @param randomArr
	 * @param start
	 * @param end
	 */
	void mergeSort(int[] randomArr, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(randomArr, start, end);
			mergeSort(randomArr, mid+1, end);

			int a = start;
			int b = mid + 1;
			int index = a;
			
			while (a <= mid || b <= end) {
				if(b > end || (a <= mid && src[a] < src[b])) {
					temp[index++] = src[a++];
				} else {
					temp[index++] = src[b++];
				} //if-else end
			} //while end
			for(int i=start; i <= end;i++) {
				src[i] = temp[i];
			}
		} //if end


	} //mergeSort end
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
