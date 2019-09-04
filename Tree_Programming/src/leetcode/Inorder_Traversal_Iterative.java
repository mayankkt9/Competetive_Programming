package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import architect.TreeNode;

public class Inorder_Traversal_Iterative {
	public static void main(String[] args) {

	}

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stck = new Stack<>();

		TreeNode current = root;

		while (current != null || !stck.empty()) {
			while (current != null) {
				stck.push(current);
				current = current.left;
			}
			current = stck.pop();
			res.add(current.val);
			current = current.right;

		}

		return res;
	}
}
