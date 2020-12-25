package BTTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderIterativeTraverse {

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

    public List<Integer> postorderTraversal(TreeNode root){

        if(root==null) return null;

        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.addFirst(curr.val);

            if(curr.left!=null){
                stack.push(curr.left);
            }

            if(curr.right!=null){
                stack.push(curr.right);
            }
        }

        return res;

    }

    }


