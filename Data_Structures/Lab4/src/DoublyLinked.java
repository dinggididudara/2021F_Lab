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
 * Node class : set data into node + print node
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
	 * @param d set data into node
	 */
	public Node(int d) // constructor
	{
		mData = d;
	} //Node end

	// -------------------------------------------------------------
	// display this node data
	/**
	 * displayMode : print node
	 */
	public void displayNode() {
		System.out.print(mData + " ");
	}
	// -------------------------------------------------------------
} // end class Node

//===================== class design starts here =============================
/**
 * DoublyLinkedList DLL : managing doubly linked list based on first(head) and last(tail)
 *
 */
class DoublyLinkedList {
	private Node first; //first node
	private Node last; //last node

	// -------------------------------------------------------------
	/**
	 * DoublyLinkedList constructor : initialize node = null
	 */
	public DoublyLinkedList() {
		first = null;
		last = null;
	} //DoublyLinkedList end

	// -------------------------------------------------------------
	/**
	 * isEmpty : check if first is empty (if starts with initialized list)
	 * @return first 
	 */
	public boolean isEmpty() {
		return first == null;
	} //isEmpty end

	// -------------------------------------------------------------
	/**
	 * insertFirst : insert node before first
	 * @param num data for inside node
	 */
	public void insertFirst(int num) {
		Node newNode = new Node(num); //new node and set data

		if (isEmpty()) //if node is empty
			last = newNode; //put in the last node
		else
			first.previous = newNode; //put in first node
		newNode.next = first; //move next node to first
		first = newNode;
	} //insertFirst end

	// -------------------------------------------------------------
	/**
	 * insertLast : insert after last
	 * @param num : number wants to insert
	 */
	public void insertLast(int num) {
		Node newNode = new Node(num);
		if (isEmpty()) //if first is empty
			first = newNode; //set new node as first
		else { //if first is not empty
			last.next = newNode; //last node's next will be new node
			newNode.previous = last; //previous of new node will be last
		} //if-else end
		last = newNode; //now new node is last node
	} //insertLast end

	// insert newNumber just after numToFind
	/**
	 * inseartAfter : insert the node after specific node
	 * @param numToFind number that wants to find
	 * @param newNumber number that wants to add to new node
	 * @return
	 */
	public boolean insertAfter(int numToFind, int newNumber) { // (assumes non-empty list)
		Node current = first;
		
		while (current.mData != numToFind) { //until number to find is found
			current = current.next; //set current to next
			if (current == null) //if current is null then return false
				return false;
		} //while end
		Node newNode = new Node(newNumber); //put data into the new node

		if (current == last) { //if current is in tail
			newNode.next = null; //next node is null
			last = newNode; //last will be new node
		} else {  //if not in last
			newNode.next = current.next;

			current.next.previous = newNode;
		} //if-else end
		newNode.previous = current;
		current.next = newNode;
		return true;
	} //insertAfter end

	//------------------------------------------------// delete first node
	/**
	 * deleteFirstNode : deleting first node if not null
	 * @return
	 */
	public Node deleteFirstNode() {
		if(first == null) { //if first (head) is null = list is empty
			return null; //then return null
		} //if end
		
		Node remove = first;//gonna ignore first node
		first = first.next; //change first to next node
		
		return remove;
		
	} //deleteFirstNode

	// -----------------------------------------------// delete last node
	/**
	 * deleteLastNode : delete last node if not null
	 * @return remove : removed last node
	 */
	public Node deleteLastNode() {
		if(last == null) { //if last (tail) is null 
			return null; //then return null
		}
		Node remove = last;
		last = last.previous; //change last to previous node
		
		return remove;
	} //deleteLastNode end

	// -------------------------------------------------------------

	// -----------------------------------------finds, deletes and returns the node that contains the given int value
	/**
	 * searchAndDelete : search number and delete
	 * @param number = search number
	 * @return remove : the node that removed
	 */
	public Node searchAndDelete(int number) {
		Node remove = null; //node that will delete
		Node temp = first; //head is temp
		Node prev = first.previous; //previous starts from first
		
		while(temp != null) { //until temp is not empty
			if(temp.mData == number) { //if temp data is same as search number
				remove  = temp; //remove will be temp
				if(temp == first) { //if temp is in the first node
					deleteFirstNode(); //delete first node
				} else if(temp == last){  //if in the last node
					deleteLastNode(); //delete last node
				} else {//if not in the middle node
					//link, prev and prev.next
					prev.next = remove.next; //update previous's next node to remove's next node
					remove.next.previous = prev; //remove's next node's previous pointer is prev
					first.previous = prev.previous; //first is prev
				} //if-else end
				break; //if found break while loop
			} else { //if not found
				prev = temp; //move to next node
				temp = temp.next; //go to next node
			} //if-else end
		} //while end
		return remove;
	} //searchAndDelete end

	// -------------------------------------------display data from first node to last node
	/**
	 * printForwards : print from first elements to last
	 */
	public void printForwards() {
		Node node = first; //set node to first node
		System.out.print("Linked List: [From first_to_last] : ");
		while(node != last.next) { //until last(tail) node
			node.displayNode(); //display node
			node = node.next; //get next node
		} //while end
		System.out.println(); //new line
	} //printForwards

	// -------------------------------------------display data from last node  to first node
	/**
	 * printBackwards : print from last elements to first
	 */
	public void printBackwards() {
		Node node = last; //set node to last node
		System.out.print("Linked List: [From last_to_first] : ");
		while(node != first) { //until first(head) node
			node.displayNode(); //display node
			node = node.previous; //get previous node
		} //while end
		System.out.println(); //new line
	} //printBackwards end
	// -------------------------------------------------------------
} // end class DoublyLinkedList

// ==========================================================
