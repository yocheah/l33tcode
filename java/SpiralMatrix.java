/*
  Title: Spiral Matrix

  Given a matrix of m x n elements (m rows, n columns), return all elements 
  of the matrix in spiral order.
  
  For example,
  Given the following matrix:
  
  [
  [ 1, 2, 3 ],
  [ 4, 5, 6 ],
  [ 7, 8, 9 ]
  ]
  
  You should return [1,2,3,6,9,8,7,4,5].
  
  Run Status: Accepted!
  Program Runtime: 556 milli secs
  Progress: 10/10 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 552 milli secs
  Progress: 21/21 test cases passed.

 */


public ArrayList<Integer> spiralOrder(int[][] matrix) {
    // Start typing your Java solution below
    ArrayList<Integer> result = new ArrayList<Integer>();

    if(matrix.length == 0) return result;

    if(matrix.length >= 1) {
	int col = 0;
	int row = 0;
	int cub = matrix[0].length;
	int rub = matrix.length;
	int clb = -1;
	int rlb = -1;
	int expectedN = cub * rub;
	int n = 0;

	boolean addCol = true;
	boolean addRow = false;
	boolean subCol = false;
	boolean subRow = false;
            
            
	while(n != expectedN) {
	    result.add(matrix[row][col]);
	    n++;

	    if (addCol) {
		if (col < cub) col++;
		if (col == cub) {
		    addCol = false;
		    addRow = true;
		    col--;
		    if (row < rub) row++;
		    rlb++;
		}
	    } else if (addRow) {
		if (row < rub) row++;
		if (row == rub) {
		    addRow = false;
		    subCol = true;
		    row--;
		    if (col > clb) col--;
		    cub--;
		}
	    } else if (subCol) {
		if (col > clb) col--;
		if (col == clb) {
		    subCol = false;
		    subRow = true;
		    col++;
		    if (row > rlb) row--;
		    rub--;
		}
	    } else if (subRow) {
		if (row > rlb) row--;
		if (row == rlb) {
		    subRow = false;
		    addCol = true;
		    row++;
		    if (col < cub) col++;
		    clb++;
		}
	    }
	}
    }
    return result;
}
