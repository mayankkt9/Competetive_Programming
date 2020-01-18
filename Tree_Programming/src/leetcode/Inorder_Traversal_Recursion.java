package leetcode;

import java.util.ArrayList;
import java.util.List;

import architect.TreeNode;

public class Inorder_Traversal_Recursion {
	public static void main(String[] args) {

	}

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;

	}

	public static void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;

		helper(root.left, res);
		res.add(root.val);
		helper(root.right, res);
	}
}
