package binaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
	
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
	
	static void topView(Node node) {
		
		if(node == null) {
			return;
		}
		
		//temporary node
		Node temp = null;
		
		//queue to store tree elements
		Queue<Pair> q = new LinkedList<Pair>();
		
		//map to store top view values and their vertical distance
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		q.add(new Pair(node, 0));
		
		while(!q.isEmpty()) {
			temp = q.peek().first;
			int level = q.peek().second;
			q.remove();
			
			map.put(level, temp.data);
			
			if(temp.left != null) {
				q.add(new Pair(temp.left, level - 1));
			}
			
			if(temp.right != null) {
				q.add(new Pair(temp.right, level + 1));
			}
		}
		
		for(Integer values : map.values()) {
			System.out.print(values + " ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createNode(1);
		root.left = createNode(2);
		root.right = createNode(3);
		root.left.right = createNode(4);
	    root.left.right.right = createNode(5);
	    root.left.right.right.right = createNode(6);
	    root.right.right = createNode(7);
	    root.right.right.right = createNode(8);
	    root.right.right.left = createNode(9);
	    root.left.left = createNode(10);
		
//		Node root = createNode(2);
//		root.left = createNode(7);
//		root.right = createNode(5);
//		root.left.right = createNode(6);
//		root.right.right = createNode(9);
//	    root.left.right.left = createNode(5);
//	    root.left.left = createNode(2);
//	    root.left.right.right = createNode(11);
//	    root.right.right.left = createNode(4);
	    
	    System.out.println("Top view of Binary Tree is: \n");
	    topView(root);
		
	}

}
