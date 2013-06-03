/*

  Title: Populating Next Right Pointers in Each Node
  Given a binary tree
  
  struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
  }
  
  Populate each next pointer to point to its next right node. 
  If there is no next right node, the next pointer should be set to NULL.
  
  Initially, all next pointers are set to NULL.
  
  Note:

  You may only use constant extra space.
  You may assume that it is a perfect binary tree (ie, all leaves are 
  at the same level, and every parent has two children).

  For example,
  Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

    After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

    Recursive Solution:
    Run Status: Accepted!
    Program Runtime: 524 milli secs
    Progress: 5/5 test cases passed.

    Run Status: Accepted!
    Program Runtime: 672 milli secs
    Progress: 14/14 test cases passed.

    Level by Level Solution:
    Run Status: Accepted!
    Program Runtime: 568 milli secs
    Progress: 5/5 test cases passed.

    Run Status: Accepted!
    Program Runtime: 648 milli secs
    Progress: 14/14 test cases passed.    

*/


// Recursive solution
public void connect(TreeLinkNode root) {
    if(root != null) {
	if(root.right != null && root.next != null && root.next.left != null)
	    root.right.next = root.next.left;
	if(root.left != null)
	    root.left.next = root.right;
	connect(root.left);
	connect(root.right);
    }        
}

// Level by Level solution
public void connect(TreeLinkNode root) {
    if(root == null
       || root.left == null
       || root.right == null) return;
    TreeLinkNode ptr = root, right;
    while(ptr != null) {
	if(ptr.next != null)
	    right = ptr.next.left;
	else
	    right = null;                                
	ptr.left.next = ptr.right;
	ptr.right.next = right;
	ptr = ptr.next;            
    }        
    connect(root.left);
}
