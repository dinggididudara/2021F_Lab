package postalCodeMap;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Starter file for Assigment3 for CST8130-Fall2021
 * @author George Kriger
 */

public class PostalCodeSearchTest {

	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		
		String[] arr = null;
		String str = ""; //string builder for everything except prefix
		String filename = "ottawa_postal_codes.csv";
		Path file = Paths.get(filename);
		try (BufferedReader input = Files.newBufferedReader(file)) {
			String line = null;
			while ((line = input.readLine()) != null) {
				//store to map
				arr = line.split(","); //split each line with comma
				str=arr[1]+","+arr[2]+","+arr[3]+","+arr[4];
				storePostalCode.store(arr[0], str); //store to map
				str = null; //empty the string builder
//				System.out.println(line);
			}//while
		}
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();

		} 
		// no need to close input. Used try-with-resources above
	}// main()

}// class
