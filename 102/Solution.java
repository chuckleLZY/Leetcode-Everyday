/**
 * difficulty: Medium
 * a BFS to search the binary tree
 */
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
    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            BFS(root,0,ans);
            return ans;
        }
    
        private void BFS(TreeNode root, int level,List<List<Integer>> ans){
            if(root==null){
                return;
            }
            //if the root is this level's first node, create the new List
            if(ans.size()==level){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(root.val);
                ans.add(temp);
            }else{
                ans.get(level).add(root.val);
            }
            //BFS to the deep nodes
            BFS(root.left,level+1,ans);
            BFS(root.right,level+1,ans);
        }
    }