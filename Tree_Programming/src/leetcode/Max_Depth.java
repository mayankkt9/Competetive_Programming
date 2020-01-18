package leetcode;

import architect.TreeNode;

public class Max_Depth {
	public static void main(String[] args) {

	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		return Math.max(l, r) + 1;
	}
}
