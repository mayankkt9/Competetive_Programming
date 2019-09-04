package leetcode;

import java.util.ArrayList;
import java.util.List;

import architect.TreeNode;

public class Preorder_Traversal_Recursion {
	public static void main(String[] args) {

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}

	public static void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		helper(root.left, res);
		helper(root.right, res);
	}
}
