package Lab2;

import java.security.SecureRandom;
import java.util.Scanner;

public class BinaryLinearSearch {
	protected int input;
	protected int[] randomArr; //array for random numbers
	protected int low;
	protected int mid;
	protected int high;
//	random.setSeed(System.currentTimeMillis());
//	random.setSeed(System.currentTimeNanos());
	
	void iterativeBinarySearch(Scanner sc){ //iterative + looping construct
		System.out.print("Please enter an integer value to search: ");
		input = sc.nextInt();
		low = 0; //initial low value
		high = randomArr.length; //initial high value
		if( (low + high) % 2 == 0) { //if it is even number
			
		}
		for(int i=0;i<randomArr.length;i++) {
			
			if(randomArr[i]==input) {
				System.out.println( input + " found at index " + i + " : Iterative Binary");
			}else if(randomArr[i]>input) {
				low = 0;
				high = i;
			}else if(randomArr[i]<input) {
				
			} //if-else end
		} //for end
	}
	
	void recursiveBinarySearch(Scanner sc) { //recursion
		System.out.print("Please enter an integer value to search: ");
		input = sc.nextInt();
		
		
		
	}
	/**
	 * iterativeLinearSearch : get search key from user input and search with linear search
	 * @param sc Scanner for search key from user
	 */
	void iterativeLinearSearch(Scanner sc) { //iterative linear search
		int no = 0;
		System.out.print("Please enter an integer value to search: ");
		input = sc.nextInt();
		
		for(int i=0;i<randomArr.length;i++) {
			if(randomArr[i]==input) {
				no = i;
				System.out.println(input + " found at index at " + no + ": Iterative Linear Search");
				break;
			} //if end
			no++;
		} //for end
		if(no == randomArr.length) {
			System.out.println(input + " was not found");
		} //if end		
	} //iterativeLinearSearch end
	
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
	
//	System.nanotime(){
//		System.out.println("Time taken in nanoseconds: %d", );
//	}
//	
//	System.currentTimeMills(){
//		System.out.print("Time taken in milliseconds: %d", );
//	}
	
}
