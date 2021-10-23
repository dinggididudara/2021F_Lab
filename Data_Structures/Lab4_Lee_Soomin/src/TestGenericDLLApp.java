/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * 			Lab 4 : LinkedList Processing, Generic Double Linked List
 *          Student Name:Soomin Lee
 * 			Student ID: 040899389
 * 
 */
/**
 * TestGenericDLLApp : testing doubly linked list with DoublyLinked class
 * @author Soomin Lee
 *
 */
class TestGenericDLLApp {
	/**
	 * main : insert first 20,42,63,93 -> insert last 9,34,51 -> print forwards and backwards
	 * 		  delete first node (93), delete last node (51)
	 * 		  search 9 and delete -> print forwards
	 *        insert 69 after 20, 77 after 34 -> print forwards
	 * @param args
	 */
	public static void main(String[] args) {
		GenericDLL<Integer> newLL = new GenericDLL<Integer>(); //new object of doubly linked list
		
		newLL.insertFirst(20); //insert 20 at first
		newLL.insertFirst(42); //insert 42 at first
		newLL.insertFirst(63); //insert 63 at first
		newLL.insertFirst(93); //insert 93 at first
		
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
} // end class TestGenericDLLApp
