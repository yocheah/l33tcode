/*

  Title: 3Sum Closest

  Given an array S of n integers, find three integers in S such that the sum is closest to a 
  given number, target. Return the sum of the three integers. You may assume that each input 
  would have exactly one solution.
  
  For example, given array S = {-1 2 1 -4}, and target = 1.
  
  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

  Run Status: Accepted!
  Program Runtime: 516 milli secs
  Progress: 20/20 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 584 milli secs
  Progress: 119/119 test cases passed.

  Solution: Use 3Sum solution and modify O(n^2)
 */
public int threeSumClosest(int[] num, int target) {
    if(num.length < 3) return 0;
    else {
	Arrays.sort(num);
	int closest = 0;        
	int diff = Integer.MAX_VALUE;            
	for(int l = 0; l < num.length-2; l++) {
	    int lnum = num[l];
                
	    if(l > 0 && num[l-1] == lnum) continue;
                
	    int c = l+1;
	    int r = num.length-1;
                
	    while(c < r) {
		int cnum = num[c];
		int rnum = num[r];
		int sum = cnum+rnum+lnum;
                    
		if(sum == target) return sum;
		else if(sum > target) r--;
		else c++;
                    
		int tempdiff = Math.abs(sum-target);
		if(tempdiff < diff) {
		    diff = tempdiff;
		    closest = sum;
		}
	    }
	}
         
	return closest;
    }        
}
