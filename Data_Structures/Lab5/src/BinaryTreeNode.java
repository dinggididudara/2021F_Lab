/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * @author Algonquin College
 * @author George Kriger
 * @author Soomin Lee
 */

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	/**
	 * Construct new tree node using these contents
	 * @param data contents of node
	 */
	public BinaryTreeNode(int data) {
		left = null;
		right = null;
		this.data = data;
	}

	/**
	 * retrieve the contents of the node
	 * @return contents of node
	 */
	public int getData() {
		return data;
	}

	/**
	 * retrieve the reference to the left hand subtree
	 * @return reference to left subtree
	 */
	public BinaryTreeNode getLeft() {
		return left;
	}

	/**
	 * retrieve the reference to the right hand subtree
	 * @return reference to right subtree
	 */
	public BinaryTreeNode getRight() {
		return right;
	}

	/**
	 * create new node and insert it in the proper location 
	 * using BST logic
	 * @param newData contents of node which will be inserted
	 */
	public void insert(int newData) {
		if (newData < data) { //if new data is smaller than right
			if (left == null) //if left is empty
				left = new BinaryTreeNode(newData); //then create new node
			else //if not empty
				left.insert(newData); //insert in the left side of that node
		} else if (newData > data) {
			if (right == null)
				right = new BinaryTreeNode(newData);
			else
				right.insert(newData);
		} else  //if key is duplicate - error message
			System.out.println("Duplicate � not adding" + newData);
	}// insert()

}// class
