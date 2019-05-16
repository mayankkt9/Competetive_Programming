package architect;

public class BtreBSTree_Common_func {

	public static void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}

	public static void preorderTraversal(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	public static void postorderTraversal(TreeNode root) {
		if (root == null)
			return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.val + " ");
	}
	
	public static TreeNode inorderSuccessor(TreeNode root){
		
		return null;
	}
	
}
