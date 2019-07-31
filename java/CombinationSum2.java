/*

  Title: Combination Sum II

  Given a collection of candidate numbers (C) and a target number (T), 
  find all unique combinations in C where the candidate numbers sums to T.

  Each number in C may only be used once in the combination.

  Note:

  All numbers (including target) will be positive integers.
  Elements in a combination (a1, a2, � , ak) must be in non-descending order. 
  (ie, a1 ? a2 ? � ? ak).
  The solution set must not contain duplicate combinations.

  For example, given candidate set 10,1,2,7,6,1,5 and target 8,
  A solution set is:
  [1, 7]
  [1, 2, 5]
  [2, 6]
  [1, 1, 6]

  Run Status: Accepted!
  Program Runtime: 560 milli secs
  Progress: 22/22 test cases passed.



  Solution:
  We should use recursion combined with backtracking. We try to add one more 
  element to the partial solution each time, if we have reached the sum, we add 
  that partial solution to the solution list. If we have exceed the sum, we 
  disregard that partial solution. If we have not reached the sum, we recursively 
  add more elements to the partial solution. Start from the next element in the recursion.

  Run Status: Accepted!
  Program Runtime: 540 milli secs
  Progress: 22/22 test cases passed.

  Run Status: Accepted!
  Program Runtime: 672 milli secs
  Progress: 172/172 test cases passed.
 */

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
               
	    int[] remaining = new int[candidates.length-1-i];
	    System.arraycopy(candidates, i+1, remaining, 0, remaining.length);
	    partial_sol.addAll(partial);
	    partial_sol.add(candidates[i]);
	    combSumRec(remaining, target, partial_sol, sol);
	}
    }
}

////////////////////////////////////

public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    Arrays.sort(num);
    int[] backtrack = new int[num.length+1];
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    backtrack[0] = -1;
    solve (num, 0, target, backtrack, result, 0);
    return result;
}
 
public void solve(int[] num, int sum, int target, int[] backtrack, ArrayList<ArrayList<Integer>> result, int n){
    //backtrack records the indexes in num array
    //what is my next number's index? start trying from backtrack[n] + 1 to num's end
    if (target == sum) {
	//add everything in backtrack to result
	ArrayList<Integer> ret = new ArrayList<Integer>();
	for (int i = 1; i <= n; i++) ret.add(num[backtrack[i]]);	
	result.add(ret);
    }
    if (target < sum) return;    
    for (int i = backtrack[n] + 1; i < num.length; i++) {
	backtrack[n+1] = i;
	solve(num, sum+num[i], target, backtrack, result, n+1);
 
	while (i+1 < num.length && num[i+1] == num[i]) i++;	
    }
}
