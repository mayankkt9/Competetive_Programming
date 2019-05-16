package architect;

public class Example_Tree_Input {
	public static TreeNode completeTree() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		return root;
	}
}
