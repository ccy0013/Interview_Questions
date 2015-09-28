/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Mon Sep 28 10:28:18 2015
 ************************************************************************/

public class Solution {
	public static Node leftmostRightChild(Node root) {
		if(root.left==null && root.right==null)
			return root;

		Node result = null;

		result = leftmostRightChild(root.left);

		if(result==null)
			result = root;

		return result;
	}

	public static Node findSuccessor(Node root) {
		if(root==null)	return null;

		if(root.right==null) {
			while(root.parent!=null && root.parent.right==root)
				root = root.parent;
			return root.parent;
		} else
			return leftmostRightChild(root.right);
	}

	public static void main(String[] args) {
		Node result;

		Node tree = new Node();

		Node[] nodes = new Node[6];
		for( int i=0; i<nodes.length; i++ )
			nodes[i] = new Node( i+1 );
		
		tree.left = nodes[0];
		nodes[0].parent = tree;
		tree.right = nodes[1];
		nodes[1].parent = tree;

		tree.print();
		result = findSuccessor(tree);
		System.out.println( "Next node of root is: " + ((null==result) ? "null" : result.data) );
		
		nodes[0].left = nodes[2];
		nodes[2].parent = nodes[0];
		nodes[2].right = nodes[3];
		nodes[3].parent = nodes[2];

		tree.print();
		result = findSuccessor(nodes[2]);
		System.out.println( "Next node of 3 is: " + ((null==result) ? "null" : result.data) );

		tree.print();
		result = findSuccessor(nodes[3]);
		System.out.println( "Next node of 4 is: " + ((null==result) ? "null" : result.data) );

		nodes[1].left = nodes[4];
		nodes[4].parent = nodes[1];
		nodes[1].right = nodes[5];
		nodes[5].parent = nodes[1];

		tree.print();
		result = findSuccessor(nodes[4]);
		System.out.println( "Next node of 5 is: " + ((null==result) ? "null" : result.data) );

		tree.print();
		result = findSuccessor(tree);
		System.out.println( "Next node of root is: " + ((null==result) ? "null" : result.data) );

		tree.print();
		result = findSuccessor(nodes[1]);
		System.out.println( "Next node of 2 is: " + ((null==result) ? "null" : result.data) );
		
		tree.print();
		result = findSuccessor(nodes[5]);
		System.out.println( "Next node of 6 is: " + ((null==result) ? "null" : result.data) );
	}
}

class Node {
	public int data;
	Node parent;
	Node left;
	Node right;

	public Node() {
		data = 0;
		parent = left = right = null;
	}

	public Node(int i) {
		data = i;
		parent = left = right = null;
	}

	public void print() {
		System.out.print("[Tree]: ");
		printHelper(this);
		System.out.println("");
	}

	private void printHelper(Node root) {
		if(root==null) {
			System.out.print("# ");
			return;
		}

		printHelper(root.left);
		System.out.print(root.data + " ");
		printHelper(root.right);
	}
}
