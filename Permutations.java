/*
  Title: Permutations
  
  Given a collection of numbers, return all possible permutations.

  For example,
  [1,2,3] have the following permutations:
  [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
  

  Run Status: Accepted!
  Program Runtime: 552 milli secs
  Progress: 5/5 test cases passed.

  Run Status: Accepted!
  Program Runtime: 564 milli secs
  Progress: 25/25 test cases passed.

  Solution: used a boolean array to mark.
 
 */

public ArrayList<ArrayList<Integer>> permute(int[] num) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();        
    if(num.length == 0) return res;
    int[] perm = new int[num.length];
    boolean[] used = new boolean[num.length];
    for(int i = 0; i < num.length; i++) used[i] = false;
    helper(num,0, perm, used, res);
        
    return res;
}
    
public void helper(int[] num, int level, int[] perm, 
		   boolean[] used, ArrayList<ArrayList<Integer>> res) {
    if(num.length == level) {
	ArrayList<Integer> x = new ArrayList<Integer>();
	for(int i = 0; i < perm.length; i++) x.add(perm[i]);
	res.add(x);
	return;
    }
        
    for(int i = 0; i < num.length; i++) {
	if(!used[i]) {
	    used[i] = true;
	    perm[level] = num[i];
	    helper(num, level+1, perm, used, res);
	    used[i] = false;
	}        
    }       
}
