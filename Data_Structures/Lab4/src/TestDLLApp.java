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
		DoublyLinkedList newLL = new DoublyLinkedList(); //new object of doubly linkedlist
//		LinkedList<Integer> newDLL = new LinkedList<Integer>(); //new doubly linked list
		
		newLL.insertFirst(20); //insert 20 at front
		newLL.insertFirst(42); //insert 42 at front
		newLL.insertFirst(63); //insert 63 at front
		newLL.insertFirst(93); //insert 93 at front
		
		newLL.insertLast(9); //insert 9 at last
		newLL.insertLast(34); //insert 34 at last
		newLL.insertLast(51); //insert 51 at last
		
		newLL.printForwards(); //print form first to last
		newLL.printBackwards(); //print from last to first
		
		newLL.deleteFirstNode(); //delete first item (node)
		newLL.deleteLastNode(); //delete last item (node)
		
		newLL.searchAndDelete(9); //search 9 and delete
		newLL.printForwards(); //print from first to last
		
		newLL.insertAfter(20,69); //insert 69 after 20
		newLL.insertAfter(34,77); //insert 77 after 34
		newLL.printForwards(); //print from first to last
		
	} // end of main() method
} // end class TestDLLApp
