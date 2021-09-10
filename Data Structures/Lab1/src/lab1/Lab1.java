package lab1;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Soomin
 * Student Number: 040899389 
 * Section #:301
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
public class Lab1 { //Lab1 class
	/**
	 * 
	 * @param args
	 * {@summary main method: call displayMainMenu method}
	 */
	public static void main(String[] args) {
		displayMainMenu();
	} //main end
	
	static void displayMainMenu(){ //displaying main menu
		Numbers n = new Numbers();
		while(true) {
			try {
				System.out.println("Please select one of the following:");
				System.out.println("1: Initialize a default array");
				System.out.println("2: To specify the max size of the array");
				System.out.println("3: Add value to the array");
				System.out.println("4: Display values in the array");
				System.out.println("5: Display average of the values, minimum value, maximum value");
				System.out.println("6: To Exit");
				System.out.print("> ");
				Scanner sc = new Scanner(System.in); //scanner for 
				int option = sc.nextInt();
				
				switch(option){
					case 1: //initialize an array = empty it
						n = new Numbers(0); //empty it
						break;
						
					case 2: //scan maximum size of array
						System.out.print("Enter new size of array: ");
						int size = sc.nextInt();
						n = new Numbers(size);
						break;
						
					case 3: //scan new values from user
						n.addValue(sc); //scan new value from user
						break;
						
					case 4: //display array's values
						n.toString();
						break;
						
					case 5: //display average, minimum , maximum
						System.out.printf("Average is: %f, minimum is %f, maximum is %f", n.getAverage(), n.getMin(), n.getMax());
						System.out.println("");
						break;
						
					case 6:
						System.out.println("Exiting...");
						System.exit(0);
						break;
					default :
						System.err.println("Invalid input, please try again.");
						break;
				} //switch-case end
			
			} catch (InputMismatchException e) {
				System.err.println("Invalid input, please try again.");
			} catch(Exception e){
				System.err.println("Error. Please try again.");
			}//try-catch end
		} //while end
	} //displayMainMenu end
} //Lab1 class end
