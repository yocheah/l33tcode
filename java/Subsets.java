/*
  Title: Subsets
  Given a set of distinct integers, S, return all possible subsets.
  
  Note:
  
  Elements in a subset must be in non-descending order.
  The solution set must not contain duplicate subsets.
  
  For example,
  If S = [1,2,3], a solution is:
  
  [
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
  ]
  
  Solution: Sort first and then combination problem.
  
  Run Status: Accepted!
  Program Runtime: 544 milli secs
  Progress: 6/6 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 604 milli secs
  Progress: 10/10 test cases passed.
  
*/

public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    if(S == null) return null;
    Arrays.sort(S);
    return subsets(S,S.length);    
}
    
public ArrayList<ArrayList<Integer>> subsets(int[] S, int l) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(l == 0) {
	res.add(new ArrayList<Integer>());
    } else {            
	for(ArrayList<Integer> s : subsets(S,l-1)) {
	    res.add((ArrayList<Integer>) s.clone());
	    s.add(S[l-1]);
	    res.add(s);
	}
    }
    return res;
}
