/*
  Title: Permutations II
  
   Given a collection of numbers that might contain duplicates, 
   return all possible unique permutations.
   
   For example,
   [1,1,2] have the following unique permutations:
   [1,1,2], [1,2,1], and [2,1,1]. 


   Run Status: Accepted!
   Program Runtime: 576 milli secs
   Progress: 10/10 test cases passed.
 
   Run Status: Accepted!
   Program Runtime: 728 milli secs
   Progress: 30/30 test cases passed.

   Solution: sort and then avoid duplicates.

*/
public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(num.length == 0) return res;
    int[] perm = new int[num.length];
    boolean[] used = new boolean[num.length];
        
    Arrays.sort(num);
    helper(num,0,perm,used,res);
    return res;        
}
    
public void helper(int[] num, int level, int[] perm, boolean[] used,
		   ArrayList<ArrayList<Integer>> res) {
    if(num.length == level) {
	ArrayList<Integer> x = new ArrayList<Integer>();
	for(int i = 0; i < perm.length; i++) x.add(perm[i]);
	res.add(x);
	return;
    }
            
    for(int i = 0; i < num.length; i++) {
	if(!used[i]) {
	    used[i] = true;
	    perm[level]=num[i];
	    helper(num,level+1,perm,used,res);
	    used[i] = false;
	    while(i+1 < num.length && num[i]==num[i+1]) i++;

	}          
    }
}
