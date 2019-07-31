/*
  Title: Subsets II
  Given a collection of integers that might contain duplicates, 
  S, return all possible subsets.
  
  Note:
  
  Elements in a subset must be in non-descending order.
  The solution set must not contain duplicate subsets.
  
  For example,
  If S = [1,2,2], a solution is:
  
  [
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
  ]
  
  Solution: Like Subset I, but check for duplicates when adding single elements.

  Run Status: Accepted!
  Program Runtime: 500 milli secs
  Progress: 13/13 test cases passed.

  Run Status: Accepted!
  Program Runtime: 1008 milli secs
  Progress: 19/19 test cases passed.

*/

public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    if(num == null) return null;
    Arrays.sort(num);
    return subsetsWithDup(num, num.length);        
}
    
public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num, int l) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(l == 0) {
	res.add(new ArrayList<Integer>());            
    } else {
	for(ArrayList<Integer> a : subsetsWithDup(num, l-1)) {
	    if(!res.contains(a))
		res.add((ArrayList<Integer>) a.clone());
	    a.add(num[l-1]);
	    res.add(a);
	}            
    }
        
    return res;
}

