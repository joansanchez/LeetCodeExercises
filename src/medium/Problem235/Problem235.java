package medium.Problem235;

public class Problem235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lower = p.val < q.val ? p : q;
        TreeNode higher = p.val > q.val ? p : q;
        return recursive(root, lower, higher);
    }

    private TreeNode recursive(TreeNode root, TreeNode lower, TreeNode higher){
        if(root.val < lower.val && root.val < higher.val) return recursive(root.right, lower, higher);
        if(root.val > lower.val && root.val > higher.val) return recursive(root.left, lower, higher);
        return root;
    }
}
