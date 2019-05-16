package leetcode;

import architect.TreeNode;

public class Validate_BST {
	public static boolean solve(TreeNode root) {
		return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

	}

	public static boolean isBST(TreeNode node, long min, long max) {

		if (node == null)
			return true;
		if (node.val >= max || node.val <= min)
			return false;

		return (isBST(node.left, min, node.val) && isBST(node.right, node.val,
				max));

	}

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		TreeNode root = null;
		solve(root);
	}

}
