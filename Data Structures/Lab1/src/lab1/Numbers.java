package lab1;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Soomin
 * Student Number: 040899389
 * Section #:301
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 *  
  */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float[] numbers; //array for user's values
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;
	
	/**
	 * Store instances
	 */
	float total;
	float average;
	float min;
	float max;
	/**
	 * Default Constructor
	 */
	public Numbers(){//default constructor
		
	}
	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		numItems = size;
		numbers = new Float[numItems];
	}
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner sc) {
		while(true) {
			if(numbers[numbers.length-1] != null) { //if last element is null
				System.out.println("Array full");
				break;
			} else { 
				try {
					System.out.print("Enter value: "); //scan user input
					for(int i=0;i<numbers.length;i++) {
						if(numbers[i] == null) { //if element is null
							float input = sc.nextFloat();
							numbers[i] = input;
							break;
						} //if end
					} //for end
					break;
				}catch(InputMismatchException ime) {
					System.out.println("Invalid input. Try again.");
				} catch(Exception e) {
					System.out.println("Error. try again.");
				} //try-catch end
			} //if-else end
			break;
		} //while end
	} //addValue end

	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		int end=0;
		if(numbers[0] != null) {
			for(int i=0;i<numbers.length;i++) {
				if(numbers[i] != null) {
					total += numbers[i];
				} else if(numbers[i] == null) {
					end = i;
					break;
				}//if end
			} //for end
			average = total / end;
		} else {
			average = (float) 0.0;
		} 
		return average;
	}
	/**
	 * finds minimum and maximum elements
	 */
	public void findMinMax() { 
		if(numbers[0] != null) {
			min=numbers[0];
			max=numbers[0];
			for(int i=0;i<numbers.length;i++) {
				if(numbers[i]<=min) {
					min = (float) numbers[i];
				} else if(numbers[i]>=max) { 
					max = (float) numbers[i];
				} //else-if end
			} //for end
		} else {
			min = (float) 0.0;
			max = (float) 0.0;
		} //if-else end
	} //findMinMax end
	
	@Override
	public String toString() { //toString method
		System.out.println("Numbers are: ");
		for(int i=0;i<numbers.length;i++) { //print all elements
			if(numbers[i]!=null) {
				System.out.println(numbers[i]);
			} //if-else end
		} //for end
		System.out.println("");
		return null;
	} //toString end
} //Numbers class end
