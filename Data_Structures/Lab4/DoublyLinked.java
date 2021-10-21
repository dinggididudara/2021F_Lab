/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * 			Lab 4 : LinkedList Processing
 *          Student Name:Soomin Lee 
 * 			Student ID: 040899389
 * 
 */

//===================== class starts here=============================
/**
 * Node class
 * @author Soomin Lee
 *
 */
class Node {
	public int mData; // data item
	public Node next; // next node in list
	public Node previous; // previous node in list
// -------------------------------------------------------------
	/**
	 * Node
	 * @param d
	 */
	public Node(int d) // constructor
	{
		mData = d;
	} //Node end

// -------------------------------------------------------------
	// display this node data
	public void displayNode() {
		System.out.print(mData + " ");
	}
// -------------------------------------------------------------
} // end class Node

//===================== class design starts here =============================
class DoublyLinkedList {
	private Node first;
	private Node last;

// -------------------------------------------------------------
	/**
	 * DoublyLinkedList
	 */
	public DoublyLinkedList() {
		first = null;
		last = null;
	}

// -------------------------------------------------------------
	/**
	 * isEmpty
	 * @return
	 */
	public boolean isEmpty() {
		return first == null;
	}

// -------------------------------------------------------------
	/**
	 * insertFirst
	 * @param num
	 */
	public void insertFirst(int num) {
		Node newNode = new Node(num);

		if (isEmpty())
			last = newNode;
		else
			first.previous = newNode;
		newNode.next = first;
		first = newNode;
	}

// -------------------------------------------------------------
	/**
	 * insertLast
	 * @param num
	 */
	public void insertLast(int num) {
		Node newNode = new Node(num);
		if (isEmpty())
			first = newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	} //insertLast end

	// insert newNumber just after numToFind
	/**
	 * inseartAfter
	 * @param numToFind
	 * @param newNumber
	 * @return
	 */
	public boolean insertAfter(int numToFind, int newNumber) { // (assumes non-empty list)
		Node current = first;
		Node current = first;
		while (current.mData != numToFind) {
			current = current.next;
			if (current == null)
				return false;
		}
		Node newNode = new Node(newNumber);

		if (current == last) {
			newNode.next = null;
			last = newNode;
		} else {
			newNode.next = current.next;

			current.next.previous = newNode;
		}
		newNode.previous = current;
		current.next = newNode;
		return true;
	} //insertAfter end
	
//------------------------------------------------// delete first node

	public Node deleteFirstNode() {

		// write your code here

	} //deleteFirstNode

// -----------------------------------------------// delete last node
/**
 * deleteLastNode 
 * @return
 */
	public Node deleteLastNode() {

		// write your code here

	} //deleteLastNode end

// -------------------------------------------------------------

// -----------------------------------------finds, deletes and returns the node that contains the given int value
	/**
	 * searchAndDelete
	 * @param number
	 * @return
	 */
	public Node searchAndDelete(int number) {

		
	} //searchAndDelete end

// -------------------------------------------display data from first node to last node
	/**
	 * printForwards
	 */
	public void printForwards() {
		System.out.println("Linked List: [From first_to_last] : ");

	}

// -------------------------------------------display data from last node  to first node
	/**
	 * printBackwards
	 */
	public void printBackwards() {
		System.out.println("Linked List: [From last_to_first] : ");

	}
// -------------------------------------------------------------
} // end class DoublyLinkedList

// ==========================================================
