/*

  Title: 3Sum

  Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
  Find all unique triplets in the array which gives the sum of zero.
  
  Note:
  
  Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
  The solution set must not contain duplicate triplets.
  
  For example, given array S = {-1 0 1 2 -1 -4},
  
  A solution set is:
  (-1, 0, 1)
  (-1, -1, 2)

  Run Status: Accepted!
  Program Runtime: 560 milli secs
  Progress: 28/28 test cases passed.

  Run Status: Accepted!
  Program Runtime: 824 milli secs
  Progress: 311/311 test cases passed.
  
  Solution: First sort and advance middle pointer based on whether bigger or smaller.  
 */

public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();        
        
    if(num.length < 3) return res;
    else {
	Arrays.sort(num); //sort first
            
	for(int l = 0; l < num.length-2; l++) {
	    if(l > 0 && num[l] == num[l-1]) continue; //avoid duplicates
	 
	    int lnum = num[l];
	    int c = l+1;
	    int r = num.length-1;
                   
	    while(c < r) {
		int cnum = num[c];
		int rnum = num[r];
		int sum = lnum+cnum+rnum;
                    
		if (sum == 0) {
		    res.add(new ArrayList<Integer>(Arrays.asList(lnum,cnum,rnum)));
		    while (c + 1 < r && num[c+1] == num[c]) c++; c++; //avoid duplicates
		    while (r - 1 > c && num[r-1] == num[r]) r--; r--; //avoid duplicates

		} else if (sum > 0) r--;
		else c++;
	    }                
	}           
    }
    return res;
}

