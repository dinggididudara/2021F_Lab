package lab1;
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
		if(numbers[numbers.length-1] != null) { //if last element is null
			System.out.println("Array full");
		} else { 
			System.out.print("Enter value: "); //scan user input
			for(int i=0;i<numbers.length;i++) {
				if(numbers[i] == null) { //if element is null
					float input = sc.nextFloat();
					numbers[i] = input;
					break;
			} //if end
		} //for end
		} //if-else end
	} //addValue end
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		for(int i=0;i<numbers.length;i++) {
			total += numbers[i];
		}
		average = total / numbers.length;
		return average;
	}
	
	public float getAverage(){
		return average;
	}
	
	public void findMinMax() {
		min=numbers[0];
		max=numbers[0];
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]<=min) {
				min = numbers[i];
			} else if(numbers[i]>=max) { 
				max = numbers[i];
			} //else-if end
		} //for end
	} //findMinMax end
	
	public float getMin() { //returning minimum value
		return min;
	} //getMin end
	
	public float getMax() { //returning maximum value
		return max;
	} //getMax end
	
	@Override
	public String toString() { //toString method
		System.out.println("Numbers are: ");
		for(int i=0;i<numbers.length;i++) { //print all elements
			if(numbers[i]!=null) {
				System.out.println(numbers[i]);
				return numbers[i].toString();
			} //if-else end
		} //for end
		System.out.println("");
		return null;
	} //toString end
} //Numbers class end
