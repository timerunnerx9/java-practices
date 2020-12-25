package BTTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderIterativeTraverse {
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

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> result = new ArrayList<>();
            int queueSize = queue.size();
            for(int i = 0; i< queueSize; i++){
                TreeNode curr = queue.poll();
                result.add(curr.val);

                if(curr.left!=null){
                    queue.add(curr.left);
                }

                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            res.add(result);
        }
        return res;

    }
}
