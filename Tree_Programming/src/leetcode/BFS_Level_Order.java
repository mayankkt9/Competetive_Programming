package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import architect.TreeNode;

public class BFS_Level_Order {
	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			int nodecount = queue.size();
			List<Integer> res = null;
			res = new LinkedList<>();
			while (nodecount > 0) {
				TreeNode temp = queue.poll();

				res.add(temp.val);
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
				nodecount--;
			}
			ans.add(res);
		}

		return ans;
	}
}
