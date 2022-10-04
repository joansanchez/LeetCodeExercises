package easy;

import java.util.Stack;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
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
}

