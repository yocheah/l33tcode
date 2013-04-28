/*
  Title: Climbing Stairs
  You are climbing a stair case. It takes n steps to reach to the top.
  
  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 

  Run Status: Accepted!
  Program Runtime: 508 milli secs
  Progress: 10/10 test cases passed.

  Run Status: Accepted!
  Program Runtime: 484 milli secs
  Progress: 45/45 test cases passed.

  Solution: Problem is Fibonacci.
*/

public int climbStairs(int[] n) {
    int s1=0;
    int s2=1;
    int result=s2;

    for(int i = 0; i < n; i++) {
	result=s1+s2;
	s1=s2;
	s2 = result;
    }
    return result;
}

public int climbStairs(int[] n) {
    if(n == 0 || n == 1) return 1;
    return climbStairs(n-1) + climbStairs(n-2);
}
