package BTTraversal;

import java.util.LinkedList;
import java.util.List;

public class PreorderIterativeTraverse {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root==null) return output;

        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if(root.right!=null){
                stack.add(root.right);
            }
            if(root.left!=null){
                stack.add(root.left);
            }
        }
        return output;
    }
}
