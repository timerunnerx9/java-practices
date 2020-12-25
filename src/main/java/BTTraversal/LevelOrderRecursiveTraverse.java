package BTTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderRecursiveTraverse {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level){
        if(res.size() == level){
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(node.val);

        if(node.left!=null){
            helper(node.left, level+1);
        }

        if(node.right!=null){
            helper(node.right, level +1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) return res;
        helper(root,0);
        return res;
    }
}
