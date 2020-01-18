package leetcode;

import architect.TreeNode;

public class Symmetric_Recursive {
	public static void main(String[] args) {

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return helper(root.left, root.right);
	}

	public static boolean helper(TreeNode l, TreeNode r) {

		if (l == null && r == null)
			return true;
		if (l == null || r == null)
			return false;
		return (l.val == r.val) && helper(l.left, r.right)
				&& helper(l.right, r.left);
	}

}
