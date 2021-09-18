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

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
/**
 * BinaryLinearSearch class : performing binary and linear search
 */
public class BinaryLinearSearch {
	protected int searchKey;
	protected int[] randomArr; //array for random numbers
	protected int low, mid, high;
	protected int total = low + high;
	
//-------------recursive : stack frame's push, pop / call another method--------------------------// 	
	
	/**
	 * recursiveBinarySearch : recursive binary search
	 * @param sc
	 */
	void recursiveBinarySearch(Scanner sc) { //recursion
		System.out.print("Please enter an integer value to search: ");
		searchKey = sc.nextInt();
				
		remainingElements(searchKey);
		
		nanoTime();
		currentTimeMills();
		recursiveLinearSearch(sc, searchKey);
	} //recursiveBinarySearch end
	/**
	 * remainingElements : calculate middle point, comparing with search key, print index
	 * @param searchKey
	 */
	void remainingElements(int searchKey){ //for recursive search
		low = 0; //initial low value
		high = randomArr.length-1; //initial high value
		
		for(int i=0;i<randomArr.length;i++) {
			if(total%2 == 0) { //if it is even number
				mid = total/2;
			} else if(total%2 != 0) { //if it is odd number
				mid = (total+1)/2;
			} //if-else end
			System.out.print(mid + " "); //print mid
			
			if(randomArr[mid]==searchKey) { //middle point is input, found!
				System.out.println(searchKey + " found at index at " + i + ": Recursive Binary Search");
				break;
			}else if(randomArr[mid]>searchKey) { //if search key is smaller than middle point
				low = 0;
				high = mid -1;
			}else if(randomArr[mid]<searchKey) { //if search key is bigger than middle point
				low = mid + 1 ;
				high = mid*2 - 1;
			} //if-else end
			System.out.println("");
		} //for end
		System.out.println();
	} //remainingElements end
	/**
	 * recursiveLinearSearch : 
	 * @param sc Scanner
	 * @return 
	 */
	int recursiveLinearSearch(Scanner sc, int searchKey) {
		int no = 0;

		for(int i=1;i<=randomArr.length;i++) { //linear search
			if(randomArr[i-1]==searchKey) {
				no = i-1;
				break;
			} //if end
		} //for end
		
		if (no == 0) { //if no is initial value
			System.out.println(searchKey + " was not found");
			return -1;
		} else {
			System.out.println(searchKey + " found at index at " + no + ": Recursive Linear Search");

			nanoTime();
			currentTimeMills();

			return no;
		} //if-else end
	} //recursiveLinearSearch end
	
	
//------------iterative: for,while,do-while loop--------------------------------------------------//
		
	/**
	 * 	iterativeBinarySearch : main iterative binary search
	 * @param sc
	 */
	int iterativeBinarySearch(Scanner sc){ //iterative + looping construct
		System.out.print("Please enter an integer value to search: ");
		searchKey = sc.nextInt();
		
		low = 0; //initial low value
		high = randomArr.length-1; //initial high value
		
		for(int i=0;i<randomArr.length;i++) {
			if(total%2 == 0) { //if it is even number
				mid = total/2;
			} else if(total%2 != 0) { //if it is odd number
				mid = (total+1)/2;
			} //if-else end
			System.out.print(mid + " "); //print mid
			if(randomArr[mid]==searchKey) { //middle point is input, found!
				return mid;
			}else if(randomArr[mid]>searchKey) { //if search key is smaller than middle point
				low = 0;
				high = mid -1;
			}else if(randomArr[mid]<searchKey) { //if search key is bigger than middle point
				low = mid + 1 ;
				high = mid*2 - 1;
			} //if-else end
		} //for end
		
		
		return -1; //if not found, return -1
	} //iterativeBinarySearch end
	/**
	 * iterativeBinarySearchResult : result for the iterative binary search
	 * @param sc Scanner
	 */
	void iterativeBinarySearchResult(Scanner sc) { //printing the result
		iterativeBinarySearch(sc);
		if (mid != -1) {
			System.out.println(searchKey + " found at index " + mid + " : Iterative Binary");
		} else {
			System.out.println(searchKey + " was not found");
		} //if-else end
		
		nanoTime();
		currentTimeMills();
		iterativeLinearSearch(searchKey);		
	} //iterativeBinarySearch end
	/**
	 * iterativeLinearSearch : get search key from user input and search with linear search
	 * @param sc Scanner for search key from user
	 */
	int iterativeLinearSearch(int searchKey) { //iterative linear search
		int no = 0;
		for(int i=1;i<=randomArr.length;i++) { //linear search
			if(randomArr[i-1]==searchKey) {
				no = i-1;
				break;
			} //if end
		} //for end
		if (no == 0) { //if no is initial value
			System.out.println(searchKey + " was not found");
			return -1;
		} else {
			System.out.println(searchKey + " found at index at " + no + ": Iterative Linear Search");

			nanoTime();
			currentTimeMills();

			return no;
		} //if-else end
	} //iterativeLinearSearch end
	
//----------------------------generate random numbers and printing time---------------------------//	
	
	/**
	 * generateRandomInts : generating 30 random integers and storing in array
	 * @param sc Scanner
	 */
	void generateRandomInts(Scanner sc) {
		SecureRandom random = new SecureRandom(); //for random numbers
		randomArr = new int[30];
		
		System.out.println("Array of randomly generated integers: ");
		System.out.print("Unsorted array: [ ");
		int a=0; //array index start number
		for(int i=0;i<100000;i++) { 
			int number = random.nextInt(100); //generate random number
			if(randomArr[29] > 0 ) { //if last element is not null(zero) = if it is full
				break;
			} //if end
			if(number>10) {
				randomArr[a] = number;
				System.out.print(randomArr[a] + " ");
				a++; //increase index number
			} //if end
		} //for end
		System.out.println("]");
		
		Arrays.sort(randomArr); //sorted array
		System.out.print("Sorted array:   [ ");
		for(int j=0;j<30;j++) {
			System.out.print(randomArr[j] + " "); //print sorted array
		} //for end
		System.out.println("]");
	} //generateRandomInts end
	/**
	 * nanoTime : calculate taken time in nano seconds
	 */
	void nanoTime(){ //get time in nano
		System.out.println("Time taken in nanoseconds: " + System.nanoTime());
	} //nanoTime end
	/**
	 * currentTimeMills : calculate taken time in million seconds
	 */
	void currentTimeMills(){ //get current time in mills
		System.out.println("Time taken in milliseconds: " + System.currentTimeMillis() );
	} //currentTimeMills end
	
} //BinaryLinearSearch class end
