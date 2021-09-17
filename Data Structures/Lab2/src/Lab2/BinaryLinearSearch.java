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
	
	/**
	 * recursiveBinarySearch : recursive binary search
	 * @param sc
	 */
	void recursiveBinarySearch(Scanner sc) { //recursion
		System.out.print("Please enter an integer value to search: ");
		searchKey = sc.nextInt();
		
		if(total%2 == 0) { //if it is even number
			mid = total/2;
		} else if(total%2 != 0) { //if it is odd number
			mid = (total+1)/2;
		} //if-else end
		
		System.out.print(mid + " ");
		
		nanoTime();
		currentTimeMills();
		recursiveLinearSearch(sc, searchKey);
	} //recursiveBinarySearch end
	/**
	 * recursiveLinearSearch : 
	 * @param sc Scanner
	 * @return 
	 */
	int recursiveLinearSearch(Scanner sc, int searchKey) {
		int no = 0;
		System.out.print("Please enter an integer value to search: ");
		searchKey = sc.nextInt();

		for(int i=0;i<randomArr.length;i++) { //linear search
			if(randomArr[i]==searchKey) {
				no = i;
				break;
			} //if end
		} //for end
		
		if (no == 0) {
			System.out.println(searchKey + " was not found");
			return -1;
		} else {
			System.out.println(searchKey + " found at index at " + no + ": Iterative Linear Search");

			nanoTime();
			currentTimeMills();

			return no;
		} //if-else end
		
		
	} //recursiveLinearSearch end
	
//------------iterative----------------------------------------------------------------------//
		
	/**
	 * 	iterativeBinarySearch : 
	 * @param sc
	 */
	void iterativeBinarySearch(Scanner sc){ //iterative + looping construct
		System.out.print("Please enter an integer value to search: ");
		searchKey = sc.nextInt();
		
		low = 0; //initial low value
		high = randomArr.length; //initial high value
		
		for(int i=0;i<randomArr.length;i++) {
			if(total%2 == 0) { //if it is even number
				mid = total/2;
			} else if(total%2 != 0) { //if it is odd number
				mid = (total+1)/2;
			} //if-else end
			System.out.print(mid + " "); //print mid
			if(mid==searchKey) { //middle point is input
				System.out.println( searchKey + " found at index " + i + " : Iterative Binary");
				break;
			}else if(mid>searchKey) { //if search key is smaller than middle point
				low = 0;
				high = mid -1;
			}else if(mid<searchKey) { //if search key is bigger than middle point
				low = mid + 1 ;
				high = mid*2 - 1;
			} //if-else end
			
			nanoTime();
			currentTimeMills();
			iterativeLinearSearch(sc, searchKey);
		} //for end
	} //iterativeBinarySearch end
	/**
	 * iterativeLinearSearch : get search key from user input and search with linear search
	 * @param sc Scanner for search key from user
	 */
	int iterativeLinearSearch(Scanner sc, int searchKey) { //iterative linear search
		int no = 0;
		System.out.print("Please enter an integer value to search: ");
		searchKey = sc.nextInt();

		for(int i=1;i<=randomArr.length;i++) { //linear search
			if(randomArr[i-1]==searchKey) {
				no = i-1;
				break;
			} //if end
		} //for end
		
		if (no == 0) {
			System.out.println(searchKey + " was not found");
			return -1;
		} else {
			System.out.println(searchKey + " found at index at " + no + ": Iterative Linear Search");

			nanoTime();
			currentTimeMills();

			return no;
		} //if-else end
	} //iterativeLinearSearch end
	
	/**
	 * generateRandomInts : generating 30 random integers and storing in array
	 * @param sc Scanner
	 */
	void generateRandomInts(Scanner sc) {
		SecureRandom random = new SecureRandom(); //between 10 to 100, random 30
		System.out.println("Array of randomly generated integers: ");
		System.out.print("Unsorted array: [ ");
		for(int i=0;i<30;i++) {
			randomArr[i] = (int) random.nextInt(100);
			System.out.print(randomArr[i] + " ");
		} //for end
		System.out.println("]");
		
		Arrays.sort(randomArr); //sorted array
		System.out.println("Sorted array:    [ ");
		for(int j=0;j<30;j++) {
			System.out.println(randomArr[j] + " "); //print sorted array
		} //for end
		System.out.println("]");
	} //generateRandomInts end
	
	void remainingElements(){
		
	}
	/**
	 * nanoTime : calculate taken time in nano seconds
	 */
	void nanoTime(){ //get time in nano
		System.out.println("Time taken in nanoseconds: " + System.nanoTime());
	}
	/**
	 * currentTimeMills : calculate taken time in million seconds
	 */
	void currentTimeMills(){ //get current time in mills
		System.out.print("Time taken in milliseconds: " + System.currentTimeMillis() );
	}
	
}
