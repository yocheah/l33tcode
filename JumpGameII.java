/*
  Title: Jump Game II

  Given an array of non-negative integers, you are initially positioned at the first 
  index of the array.
  
  Each element in the array represents your maximum jump length at that position.
  
  Your goal is to reach the last index in the minimum number of jumps.
  
  For example:
  Given array A = [2,3,1,1,4]
  
  The minimum number of jumps to reach the last index is 2. 
  (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 


  Run Status: Accepted!
  Program Runtime: 528 milli secs
  Progress: 40/40 test cases passed.  

  Run Status: Accepted!
  Program Runtime: 540 milli secs
  Progress: 88/88 test cases passed.

  Solution:
  Start from slot i, we use max to track the farthest slot we can reach within one jump from i 
  and use next to track the next position where we need to jump. It is possible that the 
  endpoint is unreachable (e.g. 3 2 1 0 0 0 0 0 0 1). In that case, at some jump point, 
  we will find out that we are jumping back.

 */

public int jump(int[] A) {
    if(A.length <=1 ) return 0;
    int steps = 0;
    for(int i = 0, max = A[0], next = 0; i < A.length; i++) {
	if(i > next) {
	    next = max;
	    steps++;
	}
	max = Math.max(A[i]+i, max);
    }
    return steps;
}

