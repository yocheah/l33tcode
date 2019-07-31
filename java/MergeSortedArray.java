/*
  Title: Merge Sorted Array
  Given two sorted integer arrays A and B, merge B into A as one sorted array.
  
  Note:
  You may assume that A has enough space to hold additional elements from B. 
  The number of elements initialized in A and B are m and n respectively.  
  
  Run Status: Accepted!
  Program Runtime: 508 milli secs
  Progress: 13/13 test cases passed.

  Run Status: Accepted!
  Program Runtime: 556 milli secs
  Progress: 59/59 test cases passed.

  Solution: Start from rear of array that holds merged results.
 */

public void merge(int A[], int m, int B[], int n) {
    if(n < 1) return;
    for(int i = m+n-1, Ai = m-1, Bi = n-1; i >=0; i--) {            
	if(get(A, Ai) > get(B, Bi)) A[i] = A[Ai--];
	else A[i] = B[Bi--];
    }
      
}
    
public int get(int[] array, int i) {
    if(i < array.length && i >= 0) return array[i];
    else return Integer.MIN_VALUE;        
}
