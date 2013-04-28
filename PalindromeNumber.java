/*
  Title: Palindrome Number

  Determine whether an integer is a palindrome. Do this without extra space.
  Some hints:

  Could negative integers be palindromes? (ie, -1)

  If you are thinking of converting the integer to string, note the restriction 
  of using extra space.

  You could also try reversing an integer. However, if you have solved the 
  problem "Reverse Integer", you know that the reversed integer might overflow. 
  How would you handle such case?

  There is a more generic way of solving this problem.

  Solution: Find divisor to get largest left-most digit and reiterate by changing
  divisor by 100.
*/

public boolean isPalindrome(int x) {
    if(x < 0) return false;
    int div = 1;
    while(x / div >= 10) div *= 10; // Find largest divisor to get left-most digit
        
    while(x != 0) {            
	if(x / div != x % 10) return false;
	x = (x % div) / 10;
	div /= 100;
    }
        
    return true;
}
