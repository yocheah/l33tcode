/*
  Title: Symmetric Tree
  
  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

  Note:
  Bonus points if you could solve it both recursively and iteratively.

  Run Status: Accepted!
  Program Runtime: 560 milli secs
  Progress: 28/28 test cases passed.

  Run Status: Accepted!
  Program Runtime: 624 milli secs
  Progress: 190/190 test cases passed.

 */

// Recursive Solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
        
    }
    
    public boolean helper(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.val != b.val) return false;
        return helper(a.left, b.right) && helper(a.right, b.left);        
    }
}
