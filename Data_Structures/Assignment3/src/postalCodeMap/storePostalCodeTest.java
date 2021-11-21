package postalCodeMap;

public class storePostalCodeTest {
/**
 * main : storing postal code to map
 * @param args
 */
	public static void main(String[] args) {
		//10 random number generate
		String ran = "";
		for(int i=0;i < 10;i++) { //repeat 10 times
			System.out.printf("Retrieving: ");
			ran = PostalCodeEntry.getRandomPrefix(); //get random number
			System.out.println(ran); //print random number
			PostalCodeSearchTest.main(args); //run test for searching
			if(storePostalCode.map.containsKey(ran)) {
				System.out.println("\t"+storePostalCode.map.get(ran)); //print the code
				ran.toString();
			} else {
				System.out.println("\tNot Found"); //if not found
			} //if-else end
		}
	}
}
