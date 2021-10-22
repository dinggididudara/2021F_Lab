import java.util.LinkedList;

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

class TestDLLApp {
	public static void main(String[] args) {
//		LinkedList<Integer> newLL = new LinkedList<Integer>(); //new doubly linked list
		
		DoublyLinkedList newLL = new DoublyLinkedList(); //new object of doubly linkedlist
		newLL.insertFirst(20);
		newLL.insertFirst(42);
		newLL.insertFirst(63);
		newLL.insertFirst(93);
		
		newLL.insertLast(9);
		newLL.insertLast(34);
		newLL.insertLast(51);
		
		newLL.printForwards();
		newLL.printBackwards();
		
		newLL.deleteFirstNode();
		newLL.deleteLastNode();
		newLL.searchAndDelete(9);
		
		newLL.insertAfter(20,69);
		newLL.insertAfter(34,77);
		
		newLL.printForwards(); //print from first to last
		
	} // end of main() method
} // end class TestDLLApp
