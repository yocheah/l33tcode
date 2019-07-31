/*
  Title: Binary Tree Zigzag Level Order Traversal
  
  Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
  
  For example:
  Given binary tree {3,9,20,#,#,15,7},
  
    3
   / \
  9  20
    /  \
   15   7

   return its zigzag level order traversal as:
   
   [
   [3],
   [20,9],
   [15,7]
   ]
   
   
   Run Status: Accepted!
   Program Runtime: 548 milli secs
   Progress: 11/11 test cases passed.

   Run Status: Accepted!
   Program Runtime: 740 milli secs
   Progress: 33/33 test cases passed.
 */

public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                
    if(root != null) {
	ArrayList<TreeNode> levelList = new ArrayList<TreeNode>();
            
	levelList.add(root);
	boolean left2right = false;    
	while(!levelList.isEmpty()) {
                
	    ArrayList<TreeNode> nextLevelList = new ArrayList<TreeNode>();
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    for(TreeNode node : levelList){
		temp.add(node.val);
	    }
                
	    res.add(temp);
                
	    for(int i = levelList.size()-1; i>= 0 ;i--) {
		TreeNode node = levelList.get(i);
		if(left2right) {
		    if(node.left != null) nextLevelList.add(node.left);
		    if(node.right != null) nextLevelList.add(node.right);
                       
		} else {
		    if(node.right != null) nextLevelList.add(node.right);
		    if(node.left != null) nextLevelList.add(node.left);     
		}
	    }
                
	    levelList = new ArrayList<TreeNode>(nextLevelList);
	    left2right = left2right ? false :  true;                                        
                
	}            
    }
        
    return res;
}
