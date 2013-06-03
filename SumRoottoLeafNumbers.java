/*
  Title: Sum Root to Leaf Numbers

  Given a binary tree containing digits from 0-9 only, each root-to-leaf path 
  could represent a number.

  An example is the root-to-leaf path 1->2->3 which represents the number 123.
  
  Find the total sum of all root-to-leaf numbers.
  
  For example,
  
    1
   / \
  2   3

  The root-to-leaf path 1->2 represents the number 12.
  The root-to-leaf path 1->3 represents the number 13.
  
  Return the sum = 12 + 13 = 25.
  
  Run Status: Accepted!
  Program Runtime: 540 milli secs
  Progress: 10/10 test cases passed.

  Run Status: Accepted!
  Program Runtime: 624 milli secs
  Progress: 109/109 test cases passed.

 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return traverser(root, 0);
    }
    
    public int traverser(TreeNode root, int sum) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return sum+root.val;
        int res = (root.val+sum)*10;
        return traverser(root.left, res) + traverser(root.right, res);
        
    }    
}
