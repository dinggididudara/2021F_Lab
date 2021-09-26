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

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
/**
 * BinaryLinearSearch class : performing binary and linear search
 */
public class BinaryLinearSearch {
	protected int searchKey;
	protected int[] randomArr; //array for random numbers - sorted
	protected int[] unsorted; //unsorted array
	protected int low, mid, high;
	protected int total;
	protected long startTimeNano; //for checking time
	protected long endTimeNano; //for checking time
	protected long startTimeMil;
	protected long endTimeMil;

	//-------------recursive : stack frame's push, pop / call another method--------------------------// 	

	/**
	 * recursiveBinarySearch : recursive binary search, calling the method
	 * @param sc
	 */
	void recursiveBinarySearch(Scanner sc) { //recursion
		System.out.println("Please enter an integer value to search: ");
		System.out.print(">");
		searchKey = sc.nextInt();
		//unsorted array print
		System.out.println("");
		printSortedArr();
		//recursive binary search
		remainingElements(searchKey);
		//recursive linear search
		recursiveLinearSearch(searchKey);
	} //recursiveBinarySearch end
	/**
	 * remainingElements : calculate middle point, comparing with search key, print index
	 * @param searchKey
	 */
	void remainingElements(int searchKey){ //for recursive search
		startTimeNano = System.nanoTime();
		startTimeMil = System.currentTimeMillis();
		
		low = 0; //initial low value
		high = randomArr.length-1; //initial high value

		for(int i=0;i<randomArr.length;i++) {
			total = low + high;
			if(total%2 == 0) { //if it is even number
				mid = total/2;
			} else if(total%2 != 0) { //if it is odd number
				mid = (total+1)/2;
			} //if-else end

			if(randomArr[mid]==searchKey) { //middle point is input, found!
				endTimeNano = System.nanoTime();
				endTimeMil = System.currentTimeMillis();

				System.out.println(searchKey + " found at index at " + mid + ": Recursive Binary Search");
				System.out.println("");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMil, endTimeMil);

				break;
			}else if(randomArr[mid]>searchKey) { //if search key is smaller than middle point
				high = mid -1;
			}else if(randomArr[mid]<searchKey) { //if search key is bigger than middle point
				low = mid + 1 ;
			} //if-else end

			if(randomArr[high]<searchKey){
				endTimeNano = System.nanoTime();
				endTimeMil = System.currentTimeMillis();
				System.out.println("");
				System.out.println(searchKey + " was not found : Recursive Binary Search");
				System.out.println("");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMil, endTimeMil);
				break;
			}//if end
		} //for end
	} //remainingElements end
	/**
	 * recursiveLinearSearch : Recursive Linear Search with for loop
	 * @param sc Scanner
	 * @return 
	 */
	int recursiveLinearSearch(int searchKey) {
		startTimeNano = System.nanoTime();
		startTimeMil = System.currentTimeMillis();

		int no = -1; //initial number -1
		for(int i = 0;i < randomArr.length;i++) { //linear search
			if(randomArr[i]==searchKey) {
				no = i;
				break;
			} else{
				continue;
			}//else-if end
		} //for end

		if (no == -1) { //if no is initial value
			endTimeNano = System.nanoTime();
			endTimeMil = System.currentTimeMillis();

			System.out.println(searchKey + " was not found : Recursive Linear Search");
			System.out.println("");

			nanoTime(startTimeNano, endTimeNano);
			currentTimeMills(startTimeMil, endTimeMil);

			return -1;
		} else {
			endTimeNano = System.nanoTime();
			endTimeMil = System.currentTimeMillis();

			System.out.println(searchKey + " found at index at " + no + ": Recursive Linear Search");
			System.out.println("");

			nanoTime(startTimeNano, endTimeNano);
			currentTimeMills(startTimeMil, endTimeMil);

			return no;
		} //if-else end
	} //recursiveLinearSearch end

	//------------iterative: for,while,do-while loop--------------------------------------------------//

	/**
	 * 	iterativeBinarySearch : main iterative binary search
	 * @param sc
	 */
	int iterativeBinarySearch(Scanner sc){ //iterative + looping construct
		System.out.println("Please enter an integer value to search: ");
		System.out.print(">");
		searchKey = sc.nextInt();
		System.out.println("");
		printSortedArr();

		low = 0; //initial low value
		high = randomArr.length-1; //initial high value

		for(int i = 0; i < randomArr.length; i++) {
			total = low + high;
			if(total%2 == 0) { //if it is even number
				mid = total/2;
			} else if(total%2 != 0) { //if it is odd number
				mid = (total+1)/2;
			} //if-else end
			if(randomArr[mid]==searchKey) { //middle point is input, found!
				return mid;
			}else if(randomArr[mid]>searchKey) { //if search key is smaller than middle point
				high = mid -1;
			}else if(randomArr[mid]<searchKey) { //if search key is bigger than middle point
				low = mid + 1 ;
			} //if-else end 
			
			if((high-low) == 1){
				endTimeNano = System.nanoTime();
				endTimeMil = System.currentTimeMillis();

				System.out.println(searchKey + " was not found : Iterative Binary Search");
				System.out.println("");
				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMil, endTimeMil);
				break;
			}//if end
		} //for end
		return -1; //if not found, return -1
	} //iterativeBinarySearch end
	/**
	 * iterativeBinarySearchResult : result for the iterative binary search
	 * @param sc Scanner
	 */
	void iterativeBinarySearchResult(Scanner sc) { //printing the result
		startTimeNano = System.nanoTime();
		startTimeMil = System.currentTimeMillis();

		iterativeBinarySearch(sc);
		if (mid != -1) { //if not return -1
			endTimeNano = System.nanoTime();
			endTimeMil = System.currentTimeMillis();
			System.out.println(searchKey + " found at index " + mid + " : Iterative Binary Search");
			System.out.println("");
			nanoTime(startTimeNano, endTimeNano);
			currentTimeMills(startTimeMil, endTimeMil);
		} else {
			endTimeNano = System.nanoTime();
			endTimeMil = System.currentTimeMillis();

			System.out.println(searchKey + " was not found : Iterative Binary Search");
			System.out.println("");
			nanoTime(startTimeNano, endTimeNano);
			currentTimeMills(startTimeMil, endTimeMil);
		} //if-else end

		iterativeLinearSearch(searchKey);		
	} //iterativeBinarySearch end
	/**
	 * iterativeLinearSearch : get search key from user input and search with linear search
	 * @param sc Scanner for search key from user
	 */
	int iterativeLinearSearch(int searchKey) { //iterative linear search
		startTimeNano = System.nanoTime();
		startTimeMil = System.currentTimeMillis();
//		Arrays.sort(randomArr);
		int no = -1;
		for(int i = 0; i < randomArr.length; i++) { //linear search
			if(randomArr[i]==searchKey) {
				no = i;
				break;
			} else{
				continue;
			}//else-if end
		} //for end
		
		if (no == -1) { //if no is initial value
			endTimeNano = System.nanoTime();
			endTimeMil = System.currentTimeMillis();

			System.out.println(searchKey + " was not found : Iterative Linear Search");
			System.out.println("");
			nanoTime(startTimeNano, endTimeNano);
			currentTimeMills(startTimeMil, endTimeMil);

			return -1;
		} else {
			endTimeNano = System.nanoTime();
			endTimeMil = System.currentTimeMillis();

			System.out.println(searchKey + " found at index at " + no + ": Iterative Linear Search");
			System.out.println("");
			nanoTime(startTimeNano, endTimeNano);
			currentTimeMills(startTimeMil, endTimeMil);

			return no;
		} //if-else end
	} //iterativeLinearSearch end

	//----------------------------generate random numbers and printing time---------------------------//	

	/**
	 * generateRandomInts : generating 1000 random integers for sorting (unsorted)
	 * @param sc Scanner
	 */
	void generateRandomInts(Scanner sc) {
		SecureRandom random = new SecureRandom(); //for random numbers
		randomArr = new int[1000];
		unsorted = new int[1000];

		System.out.println("Array of randomly generated integers: ");
		int a=0; //array index start number
		for(int i=0;i<10000000;i++) {
			int number = random.nextInt(1000); //generate random number = maximum 1000

			if(number>20) { //random range minimum 20
				randomArr[a] = number;
				unsorted[a] = number; //copy to unsorted array
				a++; //increase index number
			} //if end
			if(a == 1000) { //if last element
				break;
			} //if end			
		} //for end
		System.out.print("[ ");
		for(int d=0;d<30;d++) {
			System.out.print(randomArr[d] + " ");
		}
		System.out.println("...]");
		System.out.println("");

		Arrays.sort(randomArr); //randomArr = sorted array
	} //generateRandomInts end
	/**
	 * unsorted array print
	 */
	void printSortedArr() {
		Arrays.sort(randomArr);
		System.out.print("[ ");
		for(int j=0;j<20;j++) {
			System.out.print(randomArr[j] + " "); //print sorted array
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

} //BinaryLinearSearch class end
