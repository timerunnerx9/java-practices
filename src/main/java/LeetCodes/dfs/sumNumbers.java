package LeetCodes.dfs;

import java.util.ArrayList;
import java.util.List;

public class sumNumbers {


//      Definition for a binary tree node.
     public static class TreeNode {
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

        public static int sumNumbers(TreeNode root) {

            List<Integer> currList = new ArrayList<>();

            int globalSum = 0;

            return dfs(root, currList, 0, globalSum);


        }

        public static int dfs(TreeNode node, List<Integer> currList, int currSum, int globalSum){

            if(node == null) return globalSum;

            currList.add(0, node.val);

            if(node.left == null && node.right == null){


                for(int i = 0; i < currList.size(); i++){

                    currSum += currList.get(i) * Math.pow(10,i);
                }

                globalSum += currSum;

            }

            globalSum = dfs(node.left, currList,currSum,globalSum);
            globalSum = dfs(node.right, currList, currSum,globalSum);

            currList.remove(0);

            return globalSum;

        }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(0);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(1);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Total Sum of Path Numbers: " + sumNumbers(root));

    }
}

