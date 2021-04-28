/**
 * Difficulty: Medium
 * This is a binary tree using the DFS algorithm.
 * DFS:
 * find p return p;
 * find q return q;
 * find p^q return root;
 */

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
        if(root==p||root==q){
            return root;
        }
        if(root!=null){
            TreeNode temp_left = lowestCommonAncestor(root.left,p,q);
            TreeNode temp_right = lowestCommonAncestor(root.right,p,q);
            if(temp_left!=null || temp_right!=null){
                if(temp_left==null){
                    return temp_right;
                }
                if(temp_right==null){
                    return temp_left;
                }
                return root;
            }
            return null;
        }
        return null;
    }
    
}