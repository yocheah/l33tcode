/*
  Title: Spiral Matrix II

  Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

  For example,
  Given n = 3,
  You should return the following matrix:
  
  [
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
  ]

  Run Status: Accepted!
  Program Runtime: 532 milli secs
  Progress: 6/6 test cases passed.

  Run Status: Accepted!
  Program Runtime: 516 milli secs
  Progress: 21/21 test cases passed.

 */

public int[][] generateMatrix(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int[][] result = new int[0][0];
        
        
    if(n < 0) {
	System.out.println("Invalid n");
    } else if(n >= 1) {
        
	result = new int[n][n];
	int col = 0;
	int row = 0;
	boolean addCol = true;
	boolean addRow = false;
	boolean subCol = false;
	boolean subRow = false;
	int nExpectedElements = n * n;
	int count = 0;
	int rub = n;
	int cub = n;
	int rlb = -1;
	int clb = -1;
        
        
	while(count < nExpectedElements){
                
	    result[row][col] = ++count;
                
                
	    if(addCol){
		if(col < cub) col++;
		if(col == cub) {
		    addCol = false;
		    addRow = true;
                        
		    // turn;
		    col--;
		    if(row < rub) row++;
		    rlb++;
		}
                    
	    } else if(addRow) {
		if(row < rub) row++;
		if(row == rub) {
		    addRow = false;
		    subCol = true;
                        
		    // turn;
		    row--;
		    if(col > clb) col--;
		    cub--;
		}
                    
	    } else if(subCol) {
		if(col > clb) col--;
		if(col == clb) {
		    subCol = false;
		    subRow = true;
                        
		    // turn;
		    col++;
		    if(row > rlb) row--;
		    rub--;
                        
		}
                    
	    } else if(subRow) {
		if(row > rlb) row--;
		if(row == rlb) {
		    subRow = false;
		    addCol = true;
                        
		    // turn;
		    row++;
		    if(col < cub) col++;
		    clb++;
		}
	    } else {
		// Invalid case, should never end here
		System.err.println("Error");
	    }            
	}                              
    } 
        
    return result;
                
}
