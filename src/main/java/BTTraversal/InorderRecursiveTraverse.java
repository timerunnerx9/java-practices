package BTTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderRecursiveTraverse {

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

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;

    }
    public void helper(TreeNode node, List res){
      if(node!=null){
          if(node.left!=null){
              helper(node.left,res);
          }
          res.add(node.val);

          if(node.right!=null){
              helper(node.right,res);
          }
      }
    }
}
