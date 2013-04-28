/*
  Find the contiguous subarray within an array (containing at least one number) 
  which has the largest sum.
  
  For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
  the contiguous subarray [4,−1,2,1] has the largest sum = 6.
  More practice:
  
  If you have figured out the O(n) solution, try coding another solution using the 
  divide and conquer approach, which is more subtle.



Run Status: Accepted!
Program Runtime: 544 milli secs
Progress: 15/15 test cases passed.

Run Status: Accepted!
Program Runtime: 560 milli secs
Progress: 200/200 test cases passed.

*/

public int maxSubArray(int[] A) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for(int i = 0; i < A.length; i++) {
	sum += A[i];
	max = sum > max ? sum : max;                        
	if(sum < 0) sum = 0;
    }
       
    return max;
}
