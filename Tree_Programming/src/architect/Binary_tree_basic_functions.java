package architect;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_tree_basic_functions {

	public static void insert(TreeNode node, int key) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		TreeNode temp;
		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.left == null) {
				temp.left = new TreeNode(key);
				break;
			} else {
				q.add(temp.left);
			}
			if (temp.right == null) {
				temp.right = new TreeNode(key);
				break;
			} else {
				q.add(temp.right);
			}
		}
	}
}
