package binaryTree;

public class BinaryTreeHeight {
	
	static class Node{
		int data;
		Node left;
		Node right;
	}
	
	static Node createNode(int key) {
		Node node = new Node();
		node.data = key;
		node.left = node.right = null;
		
		return node;
	}
	
	static int getBinaryTreeHeight(Node node) {
		if(node == null) {
			return -1;
		}
		
		return max(getBinaryTreeHeight(node.left),getBinaryTreeHeight(node.right)) + 1;
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BinaryTreeHeight bt = new BinaryTreeHeight();
		Node root = createNode(2);
		root.left = createNode(7);
		root.right = createNode(5);
		root.left.left = createNode(2);
		root.left.right = createNode(6);		
		root.left.right.left = createNode(5);
		root.left.right.right = createNode(11);
		root.right.right = createNode(9);
		root.right.right.left = createNode(4);
		
		System.out.println(getBinaryTreeHeight(root));
	}

}
