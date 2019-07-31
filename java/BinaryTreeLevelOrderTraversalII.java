public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(root != null) {
	Queue<TreeNode> treeList = new LinkedList<TreeNode>();
	treeList.add(root);
	int nElementsInLevel = 1;
            
	while(!treeList.isEmpty()) {
	    int temp = 0;
                
	    ArrayList<Integer> level = new ArrayList<Integer>();
                
	    for(int i = 0; i < nElementsInLevel; i++) {
                
		TreeNode ptr = treeList.poll();    
		level.add(ptr.val);
		if(ptr.left != null) {
		    treeList.add(ptr.left);
		    temp++;
		}
		if(ptr.right != null) {
		    treeList.add(ptr.right);
		    temp++;
		}                    
	    }
             
	    res.add(level);
	    nElementsInLevel = temp;
	}
         
	for(int i = 0, j = res.size()-1; i < res.size()/2;i++,j--) {
	    ArrayList<Integer> temp = (ArrayList<Integer>) res.get(i);
	    res.set(i, (ArrayList<Integer>) res.get(j));
	    res.set(j,temp);
	}
    }
    return res;
}
