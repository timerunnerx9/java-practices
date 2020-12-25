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
            //get the last element eg, [1,2,3] this will return 3
            TreeNode node = stack.pollLast(); // or stack.pop
            output.add(node.val);

            //right first
            if(root.right!=null){
                stack.add(root.right);
            }

            //left second, the poll last will return left first
            if(root.left!=null){
                stack.add(root.left);
            }
        }
        return output;
    }
}
