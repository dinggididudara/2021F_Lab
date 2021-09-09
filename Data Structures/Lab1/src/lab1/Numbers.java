package lab1;
import java.util.Scanner;
/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Soomin
 * Student Number: 040899389
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
	 * Default Constructor
	 */
	public Numbers(){//constructor
		
	}
	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		numbers = new Float[size];
	}
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner sc) {
		if(numbers[numbers.length-1] != 0.0) { //if last element is default value of float type
			System.out.println("Array full");
		} else { 
			for(int i=0;i<numbers.length;i++) {
				if(numbers[i] == 0.0) { //if array is empty. 0.0 is default value of float
					System.out.print("Enter value: "); //scan user input
					float input = sc.nextFloat();
				numbers[i] = input;
			} //if end
		} //for end
		} //if-else end
	} //addValue end
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		float total=0;
		float ave=0;
		for(int i=0;i<numbers.length;i++) {
			total += numbers[i];
		}
		ave = total / numbers.length;
		return ave;
	}
	
	public float findMinMax() {
		float min=0;
		float max=0;
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]>=numbers[i+1]) {
				min = numbers[i];
			} else if(numbers[i]<=numbers[i+1]) {
				max = numbers[i];
			}
		}
		return min;
	}
	@Override
	public String toString() { //toString method
//		String str[]= new String[numbers.length];
		String aveStr = String.toString(ave);
		String minStr = String.toString(min);
		String maxStr = String.toString(max);
			return "Average is: " + aveStr + ", Minimum value is " + minStr + ", Maximum value is " + maxStr;
		
	} //toString end
} //Numbers class end
