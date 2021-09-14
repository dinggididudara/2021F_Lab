package Lab2;

import java.util.Scanner;

public class BinaryLinearSearch {
	protected int input;
	protected int[] random; //array for random numbers
	
	void iterativeBinarySearch(Scanner sc){ //iterative + looping construct
		System.out.print("Please enter an integer value to search: ");
		input = sc.nextInt();
	}
	
	void recursiveBinarySearch(Scanner sc) { //recursion
		System.out.print("Please enter an integer value to search: ");
		input = sc.nextInt();
	}
	
	void generateRandomInts(Scanner sc) {
		
		System.out.println("Array of randomly generated integers: ");
		System.out.print("[ ");
		for(int i=0;i<30;i++) {
			random[i] = (int) (Math.random()*100);//generate random number from 1 to 100
			System.out.print(random[i] + " ");
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
