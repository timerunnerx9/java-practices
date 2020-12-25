package BTTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderRecursiveTraverse {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,res);
        return res;

    }

    public void helper(TreeNode node ,List res){
        if(node.left!=null){
            helper(node.left, res);
        }

        if(node.right!=null){
            helper(node.right,res);
        }

        res.add(node.val);
    }
}

