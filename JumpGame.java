/*
  Title: Jump Game
 Given an array of non-negative integers, you are initially positioned at 
 the first index of the array.

 Each element in the array represents your maximum jump length at that 
 position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.
 
 A = [3,2,1,0,4], return false. 
 
 Run Status: Accepted!
 Program Runtime: 552 milli secs
 Progress: 29/29 test cases passed.

 Run Status: Accepted!
 Program Runtime: 528 milli secs
 Progress: 66/66 test cases passed.

 Solution: Idea is to start from last index and trace a path to index 0. 
           Evaluation begins at 2nd-to-last index. If the element is able
	   to reach the final index, we mark it and find the next element
	   that is able to jump to that element. If the final element is
	   the 0th element, we have found a solution.   
*/

public boolean canJump(int A[]) {
    if(A.length < 1) return false;
    int marker = A.length-1; // last index
    for(int i = marker-1; i >= 0; i--)
	if(A[i] >= marker-i) marker = i; // marker-i (n steps to next index)
    return marker == 0;
}
