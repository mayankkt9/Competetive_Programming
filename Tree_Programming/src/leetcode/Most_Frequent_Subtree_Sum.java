package leetcode;

import architect.Serialize_Deserialize;
import architect.TreeNode;

public class Most_Frequent_Subtree_Sum {
	public static void main(String[] args) {

		String data = "1,2,3,4,5,6,7";
		TreeNode root = Serialize_Deserialize.deserialize(data);
		System.out.println(solve(root));
	}

	private static int solve(TreeNode root) {
		// TODO Auto-generated method stub
		int max = Integer.MAX_VALUE;
		return helper(root, max);

	}

	private static int helper(TreeNode root, int max) {
		// TODO Auto-generated method stub

		if (root == null)
			return 0;
		int sum = root.val + helper(root.left, max) + helper(root.right, max);
		if (sum > max){
			
			max = sum;
			}

		return sum;

	}

}
