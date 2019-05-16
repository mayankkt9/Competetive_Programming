package architect;

import drawTreeTest.BinaryTree;

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
	
	public static TreeNode bstTree(){
		TreeNode root = new TreeNode(20);
		BST_basic_function.insert(root, 10);
		BST_basic_function.insert(root, 30);
		BST_basic_function.insert(root, 15);
		BST_basic_function.insert(root, 25);
		BST_basic_function.insert(root, 5);
		BST_basic_function.insert(root, 35);
		BST_basic_function.insert(root, 4);
		BST_basic_function.insert(root, 7);
		BST_basic_function.insert(root, 13);
		BST_basic_function.insert(root, 17);
		BST_basic_function.insert(root, 23);
		BST_basic_function.insert(root, 27);
		BST_basic_function.insert(root, 33);
		BST_basic_function.insert(root, 37);
		
		return root;
	}
	
	public static TreeNode leetCodeInputTree(String str)
	{
		str=str.substring(1,str.length()-1);
		System.out.println(str);
		
		String arr[]=str.split(",");
		TreeNode node = new TreeNode(Integer.parseInt(arr[0]));
		for(int i=1;i<arr.length;i++)
		{
			Binary_tree_basic_functions.insert(node, Integer.parseInt(arr[i]));
		}
		return node;
	}
	
}
