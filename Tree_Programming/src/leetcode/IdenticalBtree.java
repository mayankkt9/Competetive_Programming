package leetcode;

import architect.Example_Tree_Input;
import architect.TreeNode;

public class IdenticalBtree {
	public static void main(String args[]) {
		TreeNode root1 = Example_Tree_Input.leetCodeInputTree("[1,2,3]");
		TreeNode root2 = Example_Tree_Input.leetCodeInputTree("[1,2,3]");
		
		System.out.println(solve(root1, root2));
	}

	public static boolean solve(TreeNode node1, TreeNode node2) {

		if(node1==null && node2==null) return true;
		
		if(node1!=null && node2!=null)
		{
			return (node1.val==node2.val &&
					solve(node1.left,node2.left)&&
					solve(node1.right,node2.right));
		}
		return false;
	}
}
