/*
  Title: 4Sum

  Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
  Find all unique quadruplets in the array which gives the sum of target.

  Note:

  Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
  The solution set must not contain duplicate quadruplets.
  
  For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
  
  A solution set is:
  (-1,  0, 0, 1)
  (-2, -1, 1, 2)
  (-2,  0, 0, 2)
  
  Run Status: Accepted!
  Program Runtime: 536 milli secs
  Progress: 15/15 test cases passed.

  Run Status: Accepted!
  Program Runtime: 792 milli secs
  Progress: 282/282 test cases passed.

  Solution: Use 3Sum and add outer loop. Naiive O(n^3).

 */
public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    Set<ArrayList<Integer>> hash = new HashSet<ArrayList<Integer>>();
        
    if(num.length < 4) return res;
    else {            
	Arrays.sort(num);
	for(int i = 0; i < num.length-3; i++) {
	    int inum=num[i];
                
	    for(int l = i+1; l < num.length-2; l++) {
		int lnum=num[l];                    
		for(int c = l+1, r=num.length-1; c<r; ) {          
		    int cnum = num[c];
		    int rnum = num[r];
		    int sum = lnum+cnum+rnum+inum;
		    if(sum == target) {                            
			hash.add(new ArrayList<Integer>(Arrays.asList(inum,lnum,cnum,rnum)));                                
			while(c+1 < r && num[c] == num[c+1]) c++; c++;
			while(r-1 > c && num[r] == num[r-1]) r--; r--;
		    } else if(sum < target) c++;
		    else r--;                    
		}
		while(l+1 < num.length-2 && num[l]==num[l+1]) l++;
	    }                                
	    while(i+1 < num.length-3 && num[i]==num[i+1]) i++;
	}
            
            
	return new ArrayList<ArrayList<Integer>>(hash);
    }        
}
