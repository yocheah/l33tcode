/*

  Titel: Divide Two Integers
  
  Divide two integers without using multiplication, division and mod operator.

  Comment: Use log(a/b) = log(a) - log(b)
  so, a/b = exp(log(a) - log(b)).
  
  Overflow conditions: Math.abs of Integer.MIN = Integer.MIN.
  Solution: manually set to Integer.MAX.
  
  Special case: 
  1) Integer.MIN / 2 = -1073741824, but 
  Integer.MAX / 2 = 1073741823
  
  2) Integer.MAX/Integer.MIN = 0 (not -1).
  
  3) Right shift if divisor = 2.
  
*/



// Solution:
public static int divide(int dividend, int divisor) {
                
    boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
    
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
        
    if(divisor == 0) return Integer.MAX_VALUE; // return exception
    else if(divisor == Integer.MIN_VALUE) {
	if(dividend == Integer.MIN_VALUE) return 1;
	else return 0;
    } else if(dividend == Integer.MIN_VALUE) {                         
	int res = divide(dividend + divisor, divisor);
	return neg ? res-1 : 1-res;            
    }
        
    int product = divisor;
    int result = 0;
        
    while(dividend >= product) {
	int q = 1;
	while(dividend - product >= product) {
	    q = q << 1;
	    product = product << 1;
	}
            
	dividend = dividend - product;
	product = divisor;
	result += q;            
    }
        
    return neg ? -result : result;        
}



// Second solution: More elegant
public int divide(int dividend, int divisor) {
    if(divisor == 0) return Integer.MAX_VALUE;
    else if(divisor == 1) return dividend;
    else if(divisor == 2) return dividend >> 1;
    else if(dividend == divisor) return 1;        
    else if(dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE) return 0;
    else {
	boolean neg = (dividend > 0 && divisor < 0) || (divisor > 0 && dividend < 0);
            
	dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);
	divisor = divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(divisor);
	int result = (int) Math.floor(Math.pow(Math.E, Math.log(dividend)-Math.log(divisor)));
            
	return neg ? -result : result;        
    }   
}

