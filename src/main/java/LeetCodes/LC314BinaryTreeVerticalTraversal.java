package LeetCodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC314BinaryTreeVerticalTraversal {

     //Definition for a binary tree node.
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

        int min = 0;
        int max = 0;

        public List<List<Integer>> verticalOrder(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            if(root==null) return res;
            dfs(root,0);

            for(int i = min; i<=max; i++){
                res.add(new ArrayList<Integer>());
            }

            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> column = new LinkedList<>();

            queue.offer(root);
            column.offer(-min);

            while(!queue.isEmpty()){
                TreeNode curr = queue.poll();
                Integer col = column.poll();

                res.get(col).add(curr.val);

                if(curr.left!=null){
                    queue.offer(curr.left);
                    column.offer(col-1);
                }

                if(curr.right!=null){
                    queue.offer(curr.right);
                    column.offer(col+1);
                }

            }

            return res;

        }

        public void dfs(TreeNode node, int y){

            min = Math.min(min,y-1);
            max = Math.max(max,y+1);
            if(node.left!=null) dfs(node.left, y-1);
            if(node.right!=null) dfs(node.right, y+1);

        }
    }
}
