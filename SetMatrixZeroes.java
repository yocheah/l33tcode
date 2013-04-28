/*
  Title: Set Matrix Zeroes
   Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
   Follow up:
   
   Did you use extra space?
   A straight forward solution using O(mn) space is probably a bad idea.
   A simple improvement uses O(m + n) space, but still not the best solution.
   Could you devise a constant space solution?

   Run Status: Accepted!
   Program Runtime: 500 milli secs
   Progress: 20/20 test cases passed.

   Run Status: Accepted!
   Program Runtime: 688 milli secs
   Progress: 154/154 test cases passed.

   Solution : Use first col and row for storage.
 */

public void setZeroes(int[][] matrix) {
    assert(matrix.length > 0);
    boolean zeroFRow = false;
    boolean zeroFCol = false;
    int rLen = matrix.length;
    int cLen = matrix[0].length;

    for(int r = 0; r < rLen; r++)
	if(matrix[r][0] == 0) {
	    zeroFCol = true;
	    break;
	}

    for(int c = 0; c < cLen; c++)
	if(matrix[0][c] == 0) {
	    zeroFRow = true;
	    break;
	}

    // Mark using first row and col
    for(int r = 1; r < rLen; r++)
	for(int c = 1; c < cLen; c++)
	    if(matrix[r][c] == 0) {
		matrix[r][0] = 0;
		matrix[0][c] = 0;
	    }

    // Zero out corresponding rows and cols
    for(int r = 1; r < rLen; r++)
	for(int c = 1; c < cLen; c++)
	    if(matrix[r][0] == 0 || matrix[0][c] == 0)
		matrix[r][c] = 0;

    if(zeroFRow)
	for(int c = 0; c < cLen; c++)
	    matrix[0][c] = 0;

    if(zeroFCol)
	for(int r = 0; r < rLen; r++)
	    matrix[r][0] = 0;
}
