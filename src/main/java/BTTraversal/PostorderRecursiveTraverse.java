package BTTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderRecursiveTraverse {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void postorderTraversal(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, answer);   // traverse left subtree
        postorderTraversal(root.right, answer);  // traverse right subtree
        answer.add(root.val);                    // visit the root
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postorderTraversal(root, answer);
        return answer;
    }
}

