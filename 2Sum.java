/*

  Title: Two Sum
  
  Given an array of integers, find two numbers such that they add up to a specific target number.
  
  The function twoSum should return indices of the two numbers such that they add up to the 
  target, where index1 must be less than index2. Please note that your returned answers 
  (both index1 and index2) are not zero-based.

  You may assume that each input would have exactly one solution.
  
  Input: numbers={2, 7, 11, 15}, target=9
  Output: index1=1, index2=2 
  
  Run Status: Accepted!
  Program Runtime: 600 milli secs
  Progress: 10/10 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 536 milli secs
  Progress: 10/10 test cases passed.

  Run Status: Accepted!
  Program Runtime: 592 milli secs
  Progress: 10/10 test cases passed

  Run Status: Accepted!
  Program Runtime: 556 milli secs
  Progress: 10/10 test cases passed..

 */
//First attempt O(n^2)
public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    for(int i = 0 ; i < numbers.length; i++) {
	for(int j = 0; j < numbers.length; j++) {
	    if(i != j) {
		if(numbers[i] + numbers[j] == target){                        
		    res[0] = j+1;
		    res[1] = i+1;
		    break;
		}
	    }
	}
    }
    return res;
}

// Alternate solution using Hash Map
public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];        
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0 ; i < numbers.length; i++) {
	map.put(numbers[i],i);
    }
        
    for(int j = 0; j < numbers.length; j++) {
	int rem = target - numbers[j];
	if(map.containsKey(rem)) {
	    int i = map.get(rem)+1;
	    j++;
	    if(j > i) {res[0] = i; res[1] = j;}
	    else {res[0] = j; res[1] = i;}
	    break;
	}
    }
    return res;
}

