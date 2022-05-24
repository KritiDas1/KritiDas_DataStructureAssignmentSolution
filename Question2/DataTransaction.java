package Question2;

import DSA3.DataTransaction;
import DSA3.Node;

public class DataTransaction {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void ConvertBinaryTreeToSkewedTree(Node root, int order) {

		if (root == null) {
			return;
		}
		if (order > 0) {
			ConvertBinaryTreeToSkewedTree(root.right, order);
		} else {
			ConvertBinaryTreeToSkewedTree(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		// Condition to check if the root Node of skewed tree is not defined
		
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0) {
			ConvertBinaryTreeToSkewedTree(leftNode, order);
		} else {
			ConvertBinaryTreeToSkewedTree(rightNode, order);
		}
	}

	// Traverse the right one skewed using recursion
	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
	
		DataTransaction tree = new DataTransaction();
		DataTransaction.node = new Node(50);
		DataTransaction.node.left = new Node(30);
		DataTransaction.node.right = new Node(60);
		DataTransaction.node.left.left = new Node(10);
		DataTransaction.node.right.left = new Node(55);

		int order = 0;
		ConvertBinaryTreeToSkewedTree(node, order);
		traverseRightSkewed(headNode);

	}


}
