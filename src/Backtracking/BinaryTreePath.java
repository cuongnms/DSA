package backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public static class TreeNode {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        backtracking(root, result, root.val + "");
        return result;
    }

    private void backtracking(TreeNode root, List<String> result, String path) {
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {
//         path = path + "->" + root.left.val;
            backtracking(root.left, result, path + "->" + root.left.val);
//         path = path.replace("->" + root.left.val, "");
        }
        if (root.right != null) {
//         path = path +"->" + root.right.val;
            backtracking(root.right, result, path + "->" + root.right.val);
//         path = path.replace("->" + root.right.val, "");
        }
    }

    public static void main(String[] args) {
        BinaryTreePath b = new BinaryTreePath();
        BinaryTreePath.TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.right = new TreeNode(3);
        tree.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);
        tree.left.left = new TreeNode(6);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(8);

        List<String> result = b.binaryTreePaths(tree);
        for (String record : result) {
            System.out.println(record);
        }
    }

}
