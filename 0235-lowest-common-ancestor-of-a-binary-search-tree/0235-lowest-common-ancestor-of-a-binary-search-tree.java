/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // If both nodes are smaller, go left
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both nodes are greater, go right
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // Split point found → this is the LCA
            else {
                return root;
            }
        }
        return null; // Should never happen since p and q exist in the BST
    
    }
}