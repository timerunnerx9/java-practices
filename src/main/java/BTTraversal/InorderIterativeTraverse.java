package BTTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterativeTraverse {

  public class TreeNode {
      int val;
      TreeNode right;
      TreeNode left;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<Integer> inorderTraversal(TreeNode root){

        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}
