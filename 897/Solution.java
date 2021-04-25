/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> resList = new ArrayList<Integer>();
        Midorder(root,resList);

        TreeNode ans = new TreeNode(-1);
        TreeNode temp = ans;
        TreeNode current;
        for(Integer vals :resList){
            current = new TreeNode(vals);
            ans.right = current;
            ans = ans.right;
        }
        return temp.right;
    }

    public void Midorder(TreeNode root,List<Integer>res){
        if(root == null){
            return;
        }
        Midorder(root.left,res);
        res.add(root.val);
        Midorder(root.right,res);
    }

}