/*

  Title: Binary Tree Level Order Traversal

  Given a binary tree, return the level order traversal of its nodes' values. 
  (ie, from left to right, level by level).

  For example:
  Given binary tree {3,9,20,#,#,15,7},
  
    3
   / \
  9  20
    /  \
   15   7

   return its level order traversal as:
   
   [
    [3],
    [9,20],
    [15,7]
   ]
   
   Solution: Direct bfs traversal.

   Run Status: Accepted!
   Program Runtime: 596 milli secs
   Progress: 11/11 test cases passed.

   Run Status: Accepted!
   Program Runtime: 624 milli secs
   Progress: 33/33 test cases passed.
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

public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(root == null) return res;

    int nElementsInLevel = 1; // n elements in queue for this level
    Queue<TreeNode> treeList = new LinkedList<TreeNode>(); // bfs needs queue to track

    treeList.add(root);
    
    while(treeList.size() != 0) {
	int temp = 0; 
	ArrayList<Integer> levelNodes = new ArrayList<Integer>();
	
	for(int i = 0; i < nElementsInLevel; i++) {
	    TreeNode ptr = treeList.poll();
	    levelNodes.add(ptr.val);

	    if(ptr.left != null) {
		treeList.add(ptr.left);
		temp++;
	    }

	    if(ptr.right != null) {
		treeList.add(ptr.right);
		temp++;
	    }
	    
	}

	res.add(levelNodes);
	nElementsInLevel = temp;
    }
        
    return res;
}
