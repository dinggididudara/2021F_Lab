/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * @author Algonquin College
 * @author George Kriger
 * @author Soomin Lee
 */
public class BinaryTreeTest {

	/**
	 * main() method to test features of BinaryTree
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		int[] arr1 = {26,38,34,33,70,11,25,72,14,51};
		int[] arr2 = {13,77,6,40,95,84,50,35,31,54};
		int[] arr3 = {88,74,46,86,57,39,85,80,19,92};
		
		BinaryTree tree = new BinaryTree();
		
		for(int i=0;i<arr1.length;i++) {
			tree.insertInTree(arr1[i]);
		} //for end
		
		for(int i=0;i<arr2.length;i++) {
			tree.insertInTree(arr2[i]);
		} //for end
		
		for(int i=0;i<arr3.length;i++) {
			tree.insertInTree(arr3[i]);
		} //for end
		
		//display trees
		tree.displayInOrder();
		tree.displayPreOrder();
		//searching for number in tree
		tree.search(26);
		tree.search(11);
		tree.search(38);
		tree.search(100);
	}//main() end
}// class end


/**
 * 
 *							  26
 *						  /        \
 *						 /   		\
 *						/	     	 \
 *					  11		       38
 *					/	\	         /	   \
 *				   6    25 	       34         70
 *					   /          /  \     /     \
 *					  14         33  35   51      72
 *					 /	\		/        /  \       \
 *					13  19     31       40  54       77  
 *				 					   /  \    \    /  \ 
 * 									  39  50   57  74  95
 * 										 /            /	
 * 										46    		 84
 * 													/  \
 * 												   80   88
 * 													   /  \
 * 													  86  92
 * 													 /
 * 													85
 * 
 */
