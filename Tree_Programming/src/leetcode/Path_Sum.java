package leetcode;

import architect.TreeNode;

public class Path_Sum {
	public static void main(String[] args) {

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		int currentsum = 0;
		return helper(root, sum, currentsum);
	}

	public static boolean helper(TreeNode root, int sum, int currentsum) {

		if (root == null)
			return false;
		currentsum += root.val;

		if (root.left == null && root.right == null && currentsum != sum)
			return false;
		if (root.left == null && root.right == null && currentsum == sum)
			return true;

		return helper(root.left, sum, currentsum)
				|| helper(root.right, sum, currentsum);

	}
}
