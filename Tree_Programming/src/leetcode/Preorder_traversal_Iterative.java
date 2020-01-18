package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import architect.TreeNode;

public class Preorder_traversal_Iterative {
	public static void main(String[] args) {

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stck = new Stack<>();
		stck.push(root);

		while (!stck.empty()) {
			TreeNode temp = stck.pop();
			res.add(temp.val);
			if (temp.right != null)
				stck.push(temp.right);
			if (temp.left != null)
				stck.push(temp.left);

		}
		return res;

	}
}
