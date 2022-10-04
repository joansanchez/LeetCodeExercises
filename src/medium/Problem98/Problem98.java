package medium.Problem98;

import java.util.Stack;

public class Problem98 {
    private boolean isValidBSTNonWorking(TreeNode root) {
        Stack<TreeNode> dfs = new Stack<TreeNode>();
        dfs.push(root);
        return recursive(dfs);
    }

    private boolean recursive(Stack<TreeNode> dfs) {
        TreeNode actual = dfs.pop();
        boolean leftRecursive = true;
        boolean rightRecursive = true;
        if(actual.left == null && actual.right == null) return true;
        else {
            if(actual.left != null) {
                if (actual.left.val >= actual.val) return false;
                else {
                    dfs.push(actual.left);
                    leftRecursive = recursive(dfs);
                }
            }
            if(actual.right != null){
                if (actual.right.val <= actual.val) return false;
                else {
                    dfs.push(actual.right);
                    rightRecursive = recursive(dfs);
                }
            }
        }
        return rightRecursive && leftRecursive;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}

