package com.grade.project.Q2;

import java.util.Arrays;

public class Main {
	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public Node root;

	int[] treeArray;
	int index = 0;

	public Main() {
		root = null;
	}

	public Node rightSkewed(Node node) {
		int treeSize = calculateSize(node);
		treeArray = new int[treeSize];
		
		convertRightSkewedtoArray(node);
		Arrays.sort(treeArray);

		Node d = createRightSkewed(0, treeArray.length - 1);
		return d;
	}
	
	public int calculateSize(Node node) {
		int size = 0;
		if (node == null)
			return 0;
		else {
			size = calculateSize(node.left) + calculateSize(node.right) + 1;
			return size;
		}
	}
	public void convertRightSkewedtoArray(Node node) {	
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			if (node.left != null)
				convertRightSkewedtoArray(node.left);
			treeArray[index] = node.data;
			index++;
			if (node.right != null)
				convertRightSkewedtoArray(node.right);
		}
	}
	
	public Node createRightSkewed(int start, int end) {		
		if (start > end) {
			return null;
		}	
		int mid = (start + end) / 2;
		Node node = new Node(treeArray[mid]);
		node.left = createRightSkewed(start, mid - 1);
		node.right = createRightSkewed(mid + 1, end);
		return node;
	}
	
	public void inorderTraversal(Node node) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {

			if (node.left != null)
				inorderTraversal(node.left);
			System.out.print(node.data + " ");
			if (node.right != null)
				inorderTraversal(node.right);
		}
	}

	public static void main(String[] args) {

		Main tree = new Main();
		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.right = new Node(60);
		tree.root.left.left = new Node(10);
		tree.root.right.left = new Node(55);
		
		Node rs = tree.rightSkewed(tree.root);

		System.out.println("Right Skewed tree : ");
		tree.inorderTraversal(rs);
	}

}
