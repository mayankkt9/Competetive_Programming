package architect;

public class BST_basic_function {

	public static TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}

		if (root.val < key)
			root.right = insert(root.right, key);
		if (root.val > key)
			root.left = insert(root.left, key);

		return root;
	}

	public static TreeNode search(TreeNode root, int key) {
		if (root == null || root.val == key)
			return root;

		if (root.val > key)
			return search(root.left, key);
		return search(root.right, key);

	}

	public static TreeNode delete(TreeNode root, int key) {
		if (root == null)
			return root;

		if (root.val > key){
			root.left = delete(root.left, key);
			return root;
		}
		
		if (root.val < key){
			root.right = delete(root.right, key);
			return root;
		}
		else {
			if (root.right == null)
				return root.left;
			else if (root.left == null)
				return root.right;
			else {

				TreeNode succParent=root.right;
				TreeNode succ=root.right;
				while(succ.left!=null)
				{
					succParent=succ;
					succ=succ.left;
				}
				succParent.left=succ.right;
				root.val=succ.val;
				
				return root;
			}

		}

	}

}
