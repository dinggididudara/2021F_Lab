
/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *  
 * @author Algonquin College
 * @author George Kriger
 * @author Soomin Lee
 */

public class BinaryTree {
	BinaryTreeNode root = null;

	/**
	 * create new node with these contents and insert in the proper location
	 * using BST logic
	 * @param newData
	 */

	public void insertInTree(int newData) {
		if (root == null)
			root = new BinaryTreeNode(newData);
		else
			root.insert(newData);
	}

	/**
	 * Display tree contents using in-order traversal
	 */
	public void displayInOrder() {
		System.out.println("Tree display using in-order traversal:");
		displayInOrder(root);
		System.out.println();
		System.out.println();
	}

	/**
	 * Start at subtree and display tree contents using in-order traversal
	 * @param subRoot starting location in tree
	 */
	private void displayInOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		displayInOrder(subRoot.getLeft());
		System.out.print(" " + subRoot.getData() + " ");
		displayInOrder(subRoot.getRight());
	} //displayInOrder end
	/**
	 * Display tree contents using pre-order traversal
	 */
	public void displayPreOrder() {
		System.out.println("Tree display using pre-order traversal:");
		displayPreOrder(root);
		System.out.println();
		System.out.println();
	}
	/**
	 * Start at subtree and display tree contents using pre-order traversal
	 * @param subRoot starting location in tree
	 */
	private void displayPreOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		System.out.print(" " + subRoot.getData() + " ");
		displayPreOrder(subRoot.getLeft());
		displayPreOrder(subRoot.getRight());
	} //displayInOrder end


	/**
	 * search the key
	 * @param searchKey number to find
	 * @return true(found)/false(not found)
	 */
	public boolean search(int searchKey) { //have to set root as on top
		BinaryTreeNode subRoot = search(searchKey, root);
		while(subRoot != null) {
			if (subRoot != null) {
				System.out.println("Searching for " + searchKey + " : found");
				return true;
			} //if end
		} //while end
		System.out.println("Searching for " + searchKey + " : NOT found");
		return false;
		//move to the top root
	} //searching end

	/**
	 * searching tree to find searchKey
	 * @param searchKey the number to find
	 * @return recursive method repeat
	 */
	private BinaryTreeNode search(int searchKey, BinaryTreeNode subRoot) {
		if (subRoot == null || subRoot.getData() == searchKey) {
			return subRoot;
		} else if(subRoot.getData() > searchKey){ //if searchKey is less
			return search(searchKey, subRoot.getLeft());
		} //if-else end
		//if searchKey is greater
		return search(searchKey, subRoot.getRight());
	} //searching end
}// class
