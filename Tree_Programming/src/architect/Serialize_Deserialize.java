package architect;

import java.lang.Character.Subset;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_Deserialize {
	public static void main(String[] args) {

		TreeNode root = deserialize("1,2,3,null,null,4,5");
		System.out.println(serialize(root));
	}

	public static String serialize(TreeNode root) {
	    if (root == null) return "";
	    StringBuilder sb = new StringBuilder();
	    Queue<TreeNode> q = new LinkedList<TreeNode>();
	    TreeNode nullNode = new TreeNode(0); // notice that you cannot push a null value into a queue in java, so we invent a sentry
	    q.offer(root);
	    TreeNode cur = null;
	    while (q.size() > 0) {
	        cur = q.poll();
	        if (cur != nullNode) {
	            sb.append(cur.val + ",");
	            q.offer(cur.left != null ? cur.left : nullNode);
	            q.offer(cur.right != null ? cur.right : nullNode);
	        } else
	            sb.append("null,");
	    }
	    return sb.toString();
	}
	public static TreeNode deserialize(String data) {
	    if (data.equals("")) return null;
	    String[] strs = data.split(",");
	    TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
	    Queue<TreeNode> q = new LinkedList<TreeNode>();
	    q.offer(root);
	    Boolean left = true;
	    TreeNode cur = null;
	    for (int i = 1;i < strs.length;++i) {
	        if (left)
	            cur = q.poll();
	        if (!strs[i].equals("null")) {
	            if (left) {
	                cur.left = new TreeNode(Integer.parseInt(strs[i]));
	                q.offer(cur.left);
	            } else {
	                cur.right = new TreeNode(Integer.parseInt(strs[i]));
	                q.offer(cur.right);
	            }
	        }
	        left = !left;
	    }
	    return root;
	}
}
