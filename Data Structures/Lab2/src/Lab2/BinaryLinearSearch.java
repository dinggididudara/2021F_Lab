package Lab2;

import java.security.SecureRandom;
import java.util.Scanner;

public class BinaryLinearSearch {
	protected int searchKey;
	protected int[] randomArr; //array for random numbers
	protected int low, mid, high;
	protected int total = low + high;
//	random.setSeed(System.currentTimeMillis());
//	random.setSeed(System.currentTimeNanos());
	
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
		} //for end
	} //iterativeBinarySearch end
	
	void recursiveBinarySearch(Scanner sc) { //recursion
		System.out.print("Please enter an integer value to search: ");
		searchKey = sc.nextInt();
		
		if(total%2 == 0) { //if it is even number
			mid = total/2;
		} else if(total%2 != 0) { //if it is odd number
			mid = (total+1)/2;
		} //if-else end
	}
	/**
	 * iterativeLinearSearch : get search key from user input and search with linear search
	 * @param sc Scanner for search key from user
	 */
	void iterativeLinearSearch(Scanner sc) { //iterative linear search
		int no = 0;
		System.out.print("Please enter an integer value to search: ");
		searchKey = sc.nextInt();
		
		for(int i=0;i<randomArr.length;i++) {
			if(randomArr[i]==searchKey) {
				no = i;
				System.out.println(searchKey + " found at index at " + no + ": Iterative Linear Search");
				break;
			} //if end
			no++;
		} //for end
		if(no == randomArr.length) {
			System.out.println(searchKey + " was not found");
		} //if end		
	} //iterativeLinearSearch end
	/**
	 * recursiveLinearSearch : 
	 * @param sc
	 */
	void recursiveLinearSearch(Scanner sc) {
		
	}
	
	void generateRandomInts(Scanner sc) {
		SecureRandom random = new SecureRandom(); //between 10 to 100, random 30
		System.out.println("Array of randomly generated integers: ");
		System.out.print("[ ");
		for(int i=0;i<30;i++) {
			
			randomArr[i] = (int) random.nextInt(100);
			System.out.print(randomArr[i] + " ");
		}
		System.out.print("]");
	}
	
	void remainingElements(){
		
	}
	
	void nanoTime(){ //get time in nano
		System.out.println("Time taken in nanoseconds: " + System.nanoTime());
	}
	
	void currentTimeMills(){ //get current time in mills
		System.out.print("Time taken in milliseconds: " + System.currentTimeMillis() );
	}
	
}
