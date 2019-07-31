/*
  Title: Surrounded Regions
  
  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
  
  A region is captured by flipping all 'O's into 'X's in that surrounded region .
  
  For example,

  X X X X
  X O O X
  X X O X
  X O X X
  
  After running your function, the board should be:
  
  X X X X
  X X X X
  X X X X
  X O X X

  Solution: Can solve using both bfs/dfs. Only bfs implementation is able to pass large test.
  General idea is to scan all border 'O' cases, and mark adjacent 'O' values with 
  a sentinel value. After marking is done, mark all other values as 'X' and reset
  sentinel values to 'O'.

  Run Status: Accepted!
  Program Runtime: 612 milli secs
  Progress: 16/16 test cases passed.

  Run Status: Accepted!
  Program Runtime: 780 milli secs
  Progress: 56/56 test cases passed.
 */


public void dfs(char[][] board, int x, int y) {
    if(x < 0 || y < 0 || x >= board.length || y >= board.length || board[x][y] != 'O') return;
    board[x][y] = '#';
    dfs(board, x-1, y);
    dfs(board, x+1, y);
    dfs(board, x, y-1);
    dfs(board, x, y+1);
}
    

    
void fill(char[][] board, Queue<Integer> q, int x, int y){
    if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y]!='O') 
	return;
    q.offer(x * board.length + y); // store index
    board[x][y]='#';
}
    
void bfs(char[][] board, int x, int y){
    Queue<Integer> q = new LinkedList<Integer>();
    fill(board, q, x, y);
        
    while(!q.isEmpty()){
	int curr = q.poll();
	int i = curr / board[0].length;
	int j = curr % board[0].length;
            
	fill(board, q, i-1, j);
	fill(board, q, i+1, j);
	fill(board, q, i, j-1);
	fill(board, q, i, j+1);
    }
}
    
public void solve(char[][] board) {
    if(board == null || board.length == 0) return;
    int m = board.length; //row 
    int n = board[0].length; //column
         
        
    for(int j = 0; j < n; j++) {
	if(board[0][j] == 'O') {
	    bfs(board, 0, j); //top most line
	}
	if(board[m-1][j] == 'O') {
	    bfs(board, m-1, j); // bottom most line
	}            
    }
        
        
    for(int i = 1; i < m-1; i++) {
	if(board[i][0] == 'O') {
	    bfs(board, i, 0); //left most line                
	}   
	if(board[i][n-1] == 'O') {
	    bfs(board, i, n-1); // right most line;            
	}
    }        
        
    for(int i = 0; i < m; i++) {
	for(int j = 0; j < n; j++) {
	    if(board[i][j] == '#') board[i][j] = 'O';
            else board[i][j] = 'X';	    
	}
    }
        
}
