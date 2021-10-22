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
	/**
	 * displayMode 
	 */
	public void displayNode() {
		System.out.print(mData + " ");
	}
// -------------------------------------------------------------
} // end class Node

//===================== class design starts here =============================
/**
 * DoublyLinkedList DLL
 * 
 *
 */
class DoublyLinkedList {
	private Node first; //first node
	private Node last; //last node

// -------------------------------------------------------------
	/**
	 * DoublyLinkedList constructor : initialize
	 */
	public DoublyLinkedList() {
		first = null;
		last = null;
	} //DoublyLinkedList end

// -------------------------------------------------------------
	/**
	 * isEmpty : set empty
	 * @return first 
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
	/**
	 * deleteFirstNode : deleting first node
	 * @return
	 */
	public Node deleteFirstNode() {
		first.mData = null; //first node data set null
		first.next = null; //next node set null
		
		return first;
	} //deleteFirstNode

// -----------------------------------------------// delete last node
	/**
	 * deleteLastNode 
	 * @return
	 */
	public Node deleteLastNode() {

		last.mData = null;
		last.next = null;

	} //deleteLastNode end

// -------------------------------------------------------------

// -----------------------------------------finds, deletes and returns the node that contains the given int value
	/**
	 * searchAndDelete
	 * @param number index
	 * @return
	 */
	public Node searchAndDelete(int number) {
		
		//search from last
		if(number > size/2) {
			Node x = tail;
			for(int i=size-1;i > number; i==) {
				x = x.previous; //move to previous node
			} //for end
			return x;
		} else { //search from head
			Node x = head;
			for(int i=0; i<number; i++) {
				x = x.next;
			} //for end
			return x;
		}
		
	} //searchAndDelete end

// -------------------------------------------display data from first node to last node
	/**
	 * printForwards : print from first elements
	 */
	public void printForwards() {
		System.out.print("Linked List: [From first_to_last] : ");

	}

// -------------------------------------------display data from last node  to first node
	/**
	 * printBackwards : print from last elements
	 */
	public void printBackwards() {
		System.out.print("Linked List: [From last_to_first] : ");

	}
// -------------------------------------------------------------
} // end class DoublyLinkedList

// ==========================================================
