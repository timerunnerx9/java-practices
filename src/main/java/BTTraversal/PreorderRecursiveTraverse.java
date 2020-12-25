package BTTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreorderRecursiveTraverse {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root==null) return result;

        result.add(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return result;
    }
}
