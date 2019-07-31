/*
  Title: Combination Sum

  Given a set of candidate numbers (C) and a target number (T), find all unique 
  combinations in C where the candidate numbers sums to T.
  
  The same repeated number may be chosen from C unlimited number of times.

  Note:
  
  All numbers (including target) will be positive integers.
  Elements in a combination (a1, a2, � , ak) must be in non-descending order. 
  (ie, a1 ? a2 ? � ? ak).
  The solution set must not contain duplicate combinations.
  
  For example, given candidate set 2,3,6,7 and target 7,
  A solution set is:
  [7]
  [2, 2, 3] 
  
  Solution: Recursion

  Run Status: Accepted!
  Program Runtime: 536 milli secs
  Progress: 17/17 test cases passed.

  Run Status: Accepted!
  Program Runtime: 728 milli secs
  Progress: 168/168 test cases passed.


  Solution II:
  We should use recursion combined with backtracking. We try to add one more 
  element to the partial solution each time, if we have reached the sum, we add 
  that partial solution to the solution list. If we have exceed the sum, we 
  disregard that partial solution. If we have not reached the sum, we recursively 
  add more elements to the partial solution.

  Run Status: Accepted!
  Program Runtime: 572 milli secs
  Progress: 17/17 test cases passed.

  Run Status: Accepted!
  Program Runtime: 1068 milli secs
  Progress: 168/168 test cases passed.

 */


public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    // This is not necessary except to pass the Online Judge
    Arrays.sort(candidates);
    //reverse the array
    for (int i = 0; i < candidates.length/2; i++) {
	int temp = candidates[i];
	candidates[i] = candidates[candidates.length-1-i];
	candidates[candidates.length-1-i] = temp;
    }
    return cs (candidates, target, 0);
}

// Real algorithm is done here:
public ArrayList<ArrayList<Integer>> cs (int[] candidates, int target, int index) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if (target == 0) {
	res.add(new ArrayList<Integer>());
	return res;
    }
    if (index >= candidates.length) return null;
        
    for (int i = 0; candidates[index] * i <= target; i++) {
	ArrayList<ArrayList<Integer>> r = cs (candidates, target-candidates[index] * i, index + 1);
	if (r != null) {
	    //add i candidates[index] to all of the arraylists
	    for (int j = 0; j < r.size(); j++)
		for (int k = 0; k < i; k++)
		    r.get(j).add(candidates[index]);                                    
	    res.addAll(r);
	}
    }

    return res;
}



//////////////////////////////////////////////////

public static ArrayList<ArrayList<Integer>>
     combinationSum2(int[] candidates, int target) {
     ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
     Arrays.sort(candidates);
     combSumRec(candidates, target, new ArrayList<Integer>(), sol);
     return sol;
}
     
private static void combSumRec(int[] candidates, int target,
			       ArrayList<Integer> partial,
			       ArrayList<ArrayList<Integer>> sol) {
    int sum = 0;
    for(int i : partial) sum += i; // sum partial
    if(sum == target) {
	if(!sol.contains(partial)) sol.add(partial);
	return;
    }
    if(sum < target) {
	for(int i = 0; i < candidates.length; ++i) {
	    ArrayList<Integer> partial_sol = new ArrayList<Integer>();
               
	    int[] remaining = new int[candidates.length-i];
	    System.arraycopy(candidates, i, remaining, 0, remaining.length);
	    partial_sol.addAll(partial);
	    partial_sol.add(candidates[i]);
	    combSumRec(remaining, target, partial_sol, sol);
	}
    }
}
