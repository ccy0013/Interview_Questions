/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Fri Nov 20 17:25:02 2015
 ************************************************************************/

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
		val = 0;
		left = right = null;
	}

	public TreeNode( int v ) {
		val = v;
		left = right = null;
	}

	public void print() {
		System.out.print("[Tree]: ");
		printHelper(this);
		System.out.println("");
	}

	private void printHelper(TreeNode root) {
		if(root==null) {
			System.out.print("# ");
			return;
		}

		System.out.print(root.val + " ");

		printHelper(root.left);
		printHelper(root.right);
	}
}

public class Solution {
	public static int findAmplitudeHelper(TreeNode root, int maxVal, int curAmp) {
		if(root==null)	return curAmp;

		curAmp = Math.max(Math.abs(maxVal-root.val), curAmp);

		maxVal = Math.max(root.val, maxVal);

		return Math.max(findAmplitudeHelper(root.left, maxVal, curAmp), findAmplitudeHelper(root.right, maxVal, curAmp)); 

	}

	public static int findAmplitude(TreeNode root) {
		return root==null ? 0 : findAmplitudeHelper(root, root.val, 0);
	}

	public static void main(String[] args) {
		TreeNode[] nodes = new TreeNode[9];
		for(int i=0; i<nodes.length; i++)
			nodes[i] = new TreeNode();

		nodes[0].val = 5;
		nodes[1].val = 8;
		nodes[2].val = 9;
		nodes[3].val = 12;
		nodes[4].val = 2;
		nodes[5].val = 8;
		nodes[6].val = 4;
		nodes[7].val = 2;
		nodes[8].val = 5;

		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];

		nodes[1].left = nodes[3];
		nodes[1].right = nodes[4];

		nodes[2].left = nodes[5];
		nodes[2].right = nodes[6];

		nodes[5].left = nodes[7];

		nodes[6].left = nodes[8];

		nodes[0].print();
		System.out.println("Tree Amplitude: " + findAmplitude(nodes[0]));
	}
}
