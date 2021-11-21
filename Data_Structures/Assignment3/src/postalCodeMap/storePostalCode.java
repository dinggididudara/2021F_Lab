package postalCodeMap;

import java.util.HashMap;
import java.util.Map;
/**
 * sotrePostalCode : saving csv file data to hash map with key and value
 *
 */
public class storePostalCode {
	static Map<String,String> map = new HashMap<String,String>();
	static void store(String key, String value) {
		map.put(key,value);
	} //store end
} //storePostalCode
