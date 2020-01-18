package architect;

import java.awt.PrintGraphics;

import drawTreeTest.BinaryTree;

import bTreePrintTest.BTreePrinter;
import bTreePrintTest.BTreePrinterTest;

public class Run_all_architect_function {

	public static void printGUITree() {
		TreeNode root = Example_Tree_Input.completeTree();
		BTreePrinter.printNode(root);
	}

	public static void printInorderTraversal() {
		TreeNode root = Example_Tree_Input.completeTree();
		BtreBSTree_Common_func.inorderTraversal(root);
		System.out.println();
	}

	public static void printPreorderTraversal() {
		TreeNode root = Example_Tree_Input.completeTree();
		BtreBSTree_Common_func.preorderTraversal(root);
		System.out.println();
	}

	public static void printPostorderTraversal() {
		TreeNode root = Example_Tree_Input.completeTree();
		BtreBSTree_Common_func.postorderTraversal(root);
		System.out.println();
	}

	public static TreeNode insertBtree() {
		TreeNode root = Example_Tree_Input.completeTree();
		Binary_tree_basic_functions.insert(root, 7);
		Binary_tree_basic_functions.insert(root, 8);
		Binary_tree_basic_functions.insert(root, 9);
		Binary_tree_basic_functions.insert(root, 1);
		Binary_tree_basic_functions.insert(root, 2);
		Binary_tree_basic_functions.insert(root, 3);
		Binary_tree_basic_functions.insert(root, 4);
		Binary_tree_basic_functions.insert(root, 5);
		Binary_tree_basic_functions.insert(root, 6);
		return root;
	}

	public static TreeNode insertBSTtree() {
		TreeNode root = Example_Tree_Input.bstTree();
		return root;
	}

	public static TreeNode searchBSTtree() {
		TreeNode root = new TreeNode(20);
		BST_basic_function.insert(root, 10);
		BST_basic_function.insert(root, 30);
		BST_basic_function.insert(root, 15);
		BST_basic_function.insert(root, 25);
		BST_basic_function.insert(root, 5);
		BST_basic_function.insert(root, 35);

		TreeNode search = BST_basic_function.search(root, 35);

		return search;
	}

	public static TreeNode deleteBSTtree() {
		TreeNode root = 
				Example_Tree_Input.bstTree();
		TreeNode delete = BST_basic_function.delete(root, 30);

		return root;
	}

	public static TreeNode leetCodeInput(String str) {
			TreeNode root = Example_Tree_Input.leetCodeInputTree(str); 
			return root;
	}

	public static void main(String[] args) {
		//printGUITree();
		//printInorderTraversal();
		//printPreorderTraversal();
		//printPostorderTraversal();

		//TreeNode root = insertBtree();
		//BTreePrinter.printNode(root);

		//TreeNode root1 = insertBSTtree();
		//BTreePrinter.printNode(root1);

		//TreeNode root2 = searchBSTtree();
		//System.out.println(root2.toString());

		//TreeNode root3 = deleteBSTtree();
		//BTreePrinter.printNode(root3);
		
		TreeNode root4 = leetCodeInput("[1,null,2,3]");
		BTreePrinter.printNode(root4);
		
		
	}

}
