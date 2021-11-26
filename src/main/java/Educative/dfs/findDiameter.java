package Educative.dfs;

public class findDiameter {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

     static int left = 0,  right = 0;
        public static int findDiameter(TreeNode root) {
            // TODO: Write your code here

                if(root == null) return 0;
                dfs(root,0);

                 findDiameter(root.left);

                findDiameter(root.right);


                return right - left;

            }

            public static void dfs(TreeNode node, int currPosition){

                if(node == null) return;

                if(node.left == null && node.right == null){

                    if(currPosition < 0){
                        left = Math.min(left, currPosition);
                    }else if(currPosition > 0){
                        right = Math.max(right, currPosition);
                    }
                }

                if(node.left != null) dfs(node.left, currPosition - 1);

                if(node.right != null) dfs(node.right, currPosition + 1);


        }

        public static void main(String[] args) {

            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(1);
            root.right = null;
            root.left.left = new TreeNode(2);
            root.left.left.left = null;
            root.left.left.right = null;
           System.out.println("Tree Diameter: " + findDiameter(root));

//            TreeNode root = new TreeNode(1);
//            root.left = new TreeNode(2);
//            root.right = new TreeNode(3);
//            root.left.left = new TreeNode(4);
//            root.right.left = new TreeNode(5);
//            root.right.right = new TreeNode(6);
//            System.out.println("Tree Diameter: " + findDiameter(root));
//            root.left.left = null;
//            root.right.left.left = new TreeNode(7);
//            root.right.left.right = new TreeNode(8);
//            root.right.right.left = new TreeNode(9);
//            root.right.left.right.left = new TreeNode(10);
//            root.right.right.left.left = new TreeNode(11);
//            System.out.println("Tree Diameter: " + findDiameter(root));
        }
    }


