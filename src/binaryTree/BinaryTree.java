package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left;
	Node right;

	Node(int key) {
		data = key;
		left = right = null;
	}
};

public class BinaryTree {

	static Node root;

	private Node insertRecursive(Node current, int value) {

		if (current == null) {
			return new Node(value);
		}

		if (value > current.data) {
			current.right = insertRecursive(current.right, value);
		} else if (value < current.data) {
			current.left = insertRecursive(current.left, value);
		} else {
			return current;
		}

		return current;

	}

	public void add(int value) {
		root = insertRecursive(root, value);
	}

	public void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}
	
	public void preorderTraversal(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}
	
	public void postorderTraversal(Node root) {
		if(root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public void levelTraversal() {
		if(root == null) {
			return;
		}
		
		Queue<Node> nodes = new LinkedList<Node>();
		
		nodes.add(root);
		
		while(!nodes.isEmpty()) {
			Node node = nodes.remove();
			System.out.print(node.data + " ");
			if(node.left != null) {
				nodes.add(node.left);
			}
			
			if(node.right != null) {
				nodes.add(node.right);
			}
			
		}
	}
	
	public boolean containsNodeRecursive(Node current, int value) {
		
		if(current == null) {
			return false;
		}
		
		if(value == current.data) {
			return true;
		}
		
		return value > current.data ?  containsNodeRecursive(current.right, value) : containsNodeRecursive(current.left, value);
		
	}
	
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	
//	@Test
//	public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
//	    BinaryTree bt = createBinaryTree();
//
//	    assertTrue(bt.containsNode(6));
//	    assertTrue(bt.containsNode(4));
//	 
//	    assertFalse(bt.containsNode(1));
//	}

	public BinaryTree createBinaryTree() {
		BinaryTree binaryTree = new BinaryTree();
//		binaryTree.root = new Node(1);
//		binaryTree.root.left = new Node(2);
//		binaryTree.root.right = new Node(3);
//		binaryTree.root.left.left = new Node(4);
//		binaryTree.root.left.right = new Node(5);
		
		binaryTree.add(6);
		binaryTree.add(4);
		binaryTree.add(8);
		binaryTree.add(3);
		binaryTree.add(5);
		binaryTree.add(7);
		binaryTree.add(9);

		return binaryTree;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
		System.out.println("Inorder Traversal: ");
		bt.inorderTraversal(root);
		
		System.out.println("\n");
		
		System.out.println("PreOrder Traversal: ");
		bt.preorderTraversal(root);
		
		System.out.println("\n");
		
		System.out.println("PostOrder Traversal: ");
		bt.postorderTraversal(root);
		
		System.out.println("\n");
		
		System.out.println("LevelOrder Traversal: ");
		bt.levelTraversal();
	}

}
