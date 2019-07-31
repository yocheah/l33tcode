/*
  Title: Sqrt(x)
  Implement int sqrt(int x).

  Compute and return the square root of x.

  Run Status: Accepted!
  Program Runtime: 488 milli secs
  Progress: 16/16 test cases passed.

  Run Status: Accepted!
  Program Runtime: 736 milli secs
  Progress: 1016/1016 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 496 milli secs
  Progress: 16/16 test cases passed.

  Run Status: Accepted!
  Program Runtime: 652 milli secs
  Progress: 1016/1016 test cases passed.

  Run Status: Accepted!
  Program Runtime: 536 milli secs
  Progress: 16/16 test cases passed.

  Run Status: Accepted!
  Program Runtime: 756 milli secs
  Progress: 1016/1016 test cases passed.
 */

//Newton-Rhapson
public static int sqrt(int x) {
    double ans = x;        
    while(Math.abs(ans * ans - x) > 0.0001) ans = (ans + x / ans) / 2;         
    return (int) ans;
}
      
// Binary search
public int sqrt(int x) {        
    double pivot = x/2;
    int hi = (int) pivot;
    int lo = 0;
    while (lo <= hi){
	if (pivot * pivot > x){
	    if((pivot - 1) * (pivot -1) <= x) return (int) pivot - 1;
	    hi = (int) pivot;
	    pivot = (hi - lo )/2;
	}
	else if (pivot * pivot < x){
	    if((pivot + 1) * (pivot + 1) > x) return (int) pivot;                
	    if((pivot + 1) * (pivot + 1) == x) return (int) pivot + 1;                
	    lo = (int) pivot;
	    pivot += (hi - lo)/2;
	}
	else return (int) pivot;
    }
    return lo;
}


public static int sqrt(int x) {
    long lo = 0; long hi = x;
     
    while (lo < hi) {
	long mid = lo + (hi - lo) / 2;           
	//This is to avoid another potential rounding bug: in the first case, 
	//we want the division to always round down, towards the lower bound. 
	//But division truncates, so when lo+hi would be negative, it would start rounding towards the higher bound.
	if (mid * mid <= x && (mid + 1) * (mid + 1) >= x)
	    if ((mid + 1) * (mid + 1) == x) return (int) mid + 1;
	    else return (int) mid;
	else if (mid * mid < x) lo = mid;
	else hi = mid;
    }
    return 0;
}

public static float sqrt(float x) {
    float lo = 0; float hi = x;
    float guess = lo + (hi-lo)/2;
    float precision = 0.001;
    while(Math.abs(guess*guess-x) > precision) {
	if(guess * guess < x) lo = guess;
	else hi = guess;
	guess = lo + (hi-lo) / 2;	
    }
    return guess;
}
