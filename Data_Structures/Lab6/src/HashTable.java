import java.util.LinkedList;
/**
 * 
 *
 */
public class HashTable {
	LinkedList<Node>[] data; //linked list data
	/**
	 * HashTable : set the size of table
	 */
	@SuppressWarnings("unchecked")
	public HashTable() {
		//hash table capacity is 25
		int tableSize = 25;
		this.data = new LinkedList[tableSize]; //new linked list with same size as table
	} //HashTable end
	/**
	 * getHashCode : get hash code
	 * @param key 
	 * @return hashCode
	 */
	int getHashCode(String key) {
		int hashCode = 0;
		
		for(char c : key.toCharArray()) {
			hashCode += c;
		} //for end
		return hashCode;
	} //getHashCode end
	/**
	 * toIndex : change to index number
	 * @param hashCode
	 * @return index number
	 */
	int toIndex(int hashCode) {
		return hashCode % data.length;//get index number of hash
	} //toIndex end
	/**
	 * searchKey : searching the key using linked list
	 * @param list linked list
	 * @param key
	 * @return node (if found key) null (if not found)
	 */
	Node searchKey(LinkedList<Node> list, String key) {
		if(list == null) return null;
		
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			} //if end
		} //for end
		return null;
	} //searchKey end
	/**
	 * put : putting the key and value to the table
	 * @param key
	 * @param value
	 */
	void put(String key, String value) {
		int hashCode = getHashCode(key); //get hash code(key)
		int index = toIndex(hashCode); //get index number
		
		LinkedList<Node> list = data[index]; //add linked list that data
		
		if(list==null) {
			list = new LinkedList<Node>();
			data[index] = list;
		} //if end
		
		Node node = searchKey(list,key); //set node to that search key
		
		if(node == null) { //if node is null = last node
			list.addLast(new Node(key, value));//if the last node
		} else {
			node.setValue(value);//set node value
		} //if-else end
	} //put end
	
	public String get(String key) {
		int hashCode = getHashCode(key);
		int index = toIndex(hashCode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list,key);
		return (node == null) ? "NOT found" : node.getValue(); //if node is null then not found, if not null then get that node's value
	} //get end
	/**
	 * Node : for the node in linked list
	 */
	class Node{
		String key;
		String value;
		/**
		 * Node : set key and value
		 * @param key
		 * @param value
		 */
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		} //Node end
		/**
		 * getValue : getting value of node in linked list
		 * @return value
		 */
		public String getValue() {
			return this.value;
		} //getValue end
		/**
		 * setValue : storing value of node
		 * @param value
		 */
		public void setValue(String value) {
			this.value = value;
		} //setValue end
	} //Node end
	
} //hashTable class end
