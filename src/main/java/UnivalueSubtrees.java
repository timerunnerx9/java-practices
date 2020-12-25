import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnivalueSubtrees {

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

    class Solution {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        public int countUnivalSubtrees(TreeNode root) {

            int result = Collections.max(map.values());
            return result;

        }

        public void helper(TreeNode node){

            if(node.left!=null){
                helper(node.left);
            }

            if(node.right!=null){
                helper(node.right);
            }

            map.put(node.val,map.getOrDefault(node.val,0)+1);
        }
    }
}
