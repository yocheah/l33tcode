/*
  Title: Pow(x,n)

  Implement pow(x, n).
  

  Solution: Uses O(log (n). Exponentiation by squaring.
*/

public double pow(double x, int n) {
    if(n == 0) return 1;
    if(n == 1) return x;
        
    boolean isNeg = false;
    if(n < 0) {
	isNeg = true;
	n = -n;
    }
        
    double result = 1;
        
    while(n > 0) {
	if(n % 2 == 1) result *= x;
	x*=x;
	n >>= 1;            
    }
        
    return isNeg ? 1/result : result;
}
