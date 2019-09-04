package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import architect.TreeNode;

public class PostOrder_Traversal_Iterative {
	public static void main(String[] args) {

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stck = new Stack<>();
		stck.push(root);

		while (!stck.empty()) {
			TreeNode temp = stck.pop();
			res.addFirst(temp.val);
			if (temp.left != null)
				stck.push(temp.left);
			if (temp.right != null)
				stck.push(temp.right);

		}
		return res;

	}
}
