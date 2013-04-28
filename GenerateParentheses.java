/*
  Title: Generate Parentheses

  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
  
  For example, given n = 3, a solution set is:
  
  "((()))", "(()())", "(())()", "()(())", "()()()" 

  Run Status: Accepted!
  Program Runtime: 508 milli secs
  Progress: 3/3 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 676 milli secs
  Progress: 8/8 test cases passed.
  
  Solution: Depth First search
 */

public ArrayList<String> generateParenthesis(int n) {
    assert(n >= 0);
    
    ArrayList<String> res = new ArrayList<String>();
    if(n == 0) return res;
    else return recursiveHelper(n, 0, 0, new StringBuffer());
}

public ArrayList<String> recursiveHelper(int n, int l, int r, StringBuffer buf) {
    ArrayList<String> res = new ArrayList<String>();
    if(l > n || r > n) return res;
    if(r == n) {
	res.add(buf.toString());
	return res;
    }
    if(l < n) {
	StringBuffer newbuf = new StringBuffer(buf);
	res.addAll(recursiveHelper(n, l+1, r, newbuf.append("(")));	
    }
    if(r < l) {
	StringBuffer newbuf = new StringBuffer(buf);
	res.addAll(recursiveHelper(n, l, r+1, newbuf.append(")")));
    }
    return res;
}
