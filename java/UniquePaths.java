/*
  Title: Unique Paths
  

  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
  
  The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
  
  How many possible unique paths are there?


  Above is a 3 x 7 grid. How many possible unique paths are there?
  
  Note: m and n will be at most 100.

  Run Status: Accepted!
  Program Runtime: 472 milli secs
  Progress: 13/13 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 580 milli secs
  Progress: 61/61 test cases passed.

  Use an example of 3x7 grid and observe pattern. Diagonals add up.

 */

public int uniquePaths(int m, int n) {
    int M_MAX = 100;
    int N_MAX = 100;
        
    int[][] mat = new int[M_MAX+1][N_MAX+1]; // initialize over to create fake initialize boxes
    mat[m-1][n] = 1; // or mat[m+1][n] to initialize
        
        
    for(int i = m-1; i >= 0; i--)
	for(int j = n-1; j >= 0; j--)
	    mat[i][j] = mat[i+1][j] + mat[i][j+1];
        
    return mat[0][0];
}
