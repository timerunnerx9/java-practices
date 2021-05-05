package LeetCodes;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC987BinaryTreeVerticalTraversal {


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
        public List<List<Integer>> verticalTraversal(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();

            if(root == null) return res;

            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

            dfs(root,0,0,map);

            for(TreeMap<Integer, PriorityQueue<Integer>> y : map.values()){
                res.add(new ArrayList<Integer>());
                for(PriorityQueue<Integer> queue : y.values()){
                    while(!queue.isEmpty()){
                        res.get(res.size()-1).add(queue.poll());
                    }
                }
            }


            return res;
        }

        public void dfs(TreeNode node, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){

            if(node == null) return;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<Integer, PriorityQueue<Integer>>());
            }

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<Integer>());
            }

            map.get(x).get(y).offer(node.val);

            if(node.left!=null){
                dfs(node.left, x-1, y+1,map);
            }

            if(node.right!=null){
                dfs(node.right,x+1,y+1,map);
            }


        }
    }
}
