/*
  Title: Trapping Rain Water
  
   Given n non-negative integers representing an elevation map where the width of each 
   bar is 1, compute how much water it is able to trap after raining.

   For example,
   Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

   Solution: Calculate max height from the left for each index, then do the same for the right. 
   Take the minimal of the two (this yields the highest level) and subtract the value at that index.
   Analysis, this requires two passes and can be done linearly so, O(N).

   Run Status: Accepted!
   Program Runtime: 524 milli secs
   Progress: 13/13 test cases passed.

   Run Status: Accepted!
   Program Runtime: 560 milli secs
   Progress: 314/314 test cases passed.
 */

public int trap(int[] A) {
    int amount = 0;
        
    if(A.length < 2) return amount;
    else {
	int[] maxLeft = new int[A.length];
	int[] maxRight = new int[A.length];
	int maxHeight = A[0];
            
	for(int i = 1; i < A.length; i++) {
	    maxLeft[i] = maxHeight;
	    maxHeight = Math.max(maxHeight,A[i]);
	}
            
	maxHeight = A[A.length-1];            
	for(int i = A.length-2; i >= 0; i--) {
	    maxRight[i] = maxHeight;
	    maxHeight = Math.max(maxHeight,A[i]);
                
                
	    int container = Math.min(maxLeft[i], maxRight[i]);
	    if(container > A[i]) {
		amount += container - A[i];
	    }                
	}            
            
    }
    return amount;
}
