/*
  Title: Combinations

  Given two integers n and k, return all possible combinations of k numbers 
  out of 1 ... n.
  
  For example,
  If n = 4 and k = 2, a solution is:
  
  [
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
  ]
  
  Solution:
  
  * Recursion Logic.
  *  
  * Let input = {1,2,3,4,5}, k = {3}
  *
  *  Result = Append '1' to all Combainations of k-1 = 2 numbers from set {2,3,4,5}  (Which will be { {2,3},{2,4},{2,5},{3,4},{3,5},{3,6},{4,5}})
  *                 + Append '2' to all Combinations of k-1 = 2 numbers from set {3,4,5} (Which will be { {3,4}, {3,5}, {3,6}, {4,5} }) 
  *                 + Append '3' to all Combinations of k-1 = 2 numbers from set {4,5} (Which will be {4,5}) 
  *                 // No need to consider '4' here because there will not be no combinations of k-1=2 numbers from set {5}
  * To find the results for k -1 , we just recurse.

*/
  
// Combinations
public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
    if(k == 0) return res;
    else if(k == 1) {
	for(int i = 1; i <= n; i++) {
	    ArrayList<Integer> a = new ArrayList<Integer>();
	    a.add(i);
	    res.add(a);
	}
    } else{
	ArrayList<ArrayList<Integer>> part = combine(n, k-1); 
            
	for(ArrayList a : part) {
	    int e = (Integer) a.get(a.size()-1);
	    for(int i = e+1; i <= n; i++) {
		ArrayList<Integer> copy = (ArrayList<Integer>) a.clone();
		if(copy.size() < k) {
		    copy.add(i);
		    res.add(copy);
		}
	    }
	}
    }
        
    return res;
}


