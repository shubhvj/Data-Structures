package binaryTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrder {
	
	//binary tree structure
	static class Node{
		int data;
		Node left;
		Node right;
	};
	
	//pair structure
	static class Pair{
		Node first;
		int second;
		
		Pair(Node n, int a){
			first = n;
			second = a;
		}
	}
	
	//function to create node
	static Node createNode(int key) {
		Node newNode = new Node();
		newNode.left = newNode.right = null;
		newNode.data = key;
		
		return newNode;
	}
	
static void printVerticalOrder(Node node) {
		
		if(node == null) {
			return;
		}
		
		int height = 0;
		
		TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<Integer, ArrayList<Integer>>();
		getVerticalOrder(node, height, tm);
		
		for(Map.Entry<Integer, ArrayList<Integer>> cm : tm.entrySet()) {
			System.out.println("Level -> " + cm.getKey());
			System.out.println(cm.getValue());
			System.out.println("\n");
		}
		
		
}
	
	static void getVerticalOrder(Node node, int height, TreeMap<Integer, ArrayList<Integer>> tm) {
		
		if(node == null) {
			return;
		}
		
		if(tm.get(height) == null) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(node.data);
			tm.put(height, list);
		}else {
			ArrayList<Integer> list = tm.get(height);
			list.add(node.data);			
		}
		
		getVerticalOrder(node.left, height - 1, tm);
		getVerticalOrder(node.right, height + 1, tm);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createNode(2);
		root.left = createNode(7);
		root.right = createNode(5);
		root.left.right = createNode(6);
	    root.left.right.left = createNode(5);
	    root.left.right.right = createNode(11);
	    root.right.right = createNode(9);
	    root.right.right.left = createNode(4);
	    root.left.left = createNode(2);
	    
	    System.out.println("Top view of Binary Tree is: \n");
	    printVerticalOrder(root);
		
	}

}
