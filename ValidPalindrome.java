/*
  Title: Valid Palindrome
  
  Given a string, determine if it is a palindrome, 
  considering only alphanumeric characters and ignoring cases.
  
  For example,
  "A man, a plan, a canal: Panama" is a palindrome.
  "race a car" is not a palindrome.
  
  Note:
  Have you consider that the string might be empty? This is a 
  good question to ask during an interview.
  
  For the purpose of this problem, we define empty string as valid palindrome.

  Run Status: Accepted!
  Program Runtime: 544 milli secs
  Progress: 27/27 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 728 milli secs
  Progress: 475/475 test cases passed.
  
 */

public boolean isPalindrome(String s) {
    s = s.toLowerCase().replaceAll("[^a-z0-9]","");
    char[] temp1 = s.toCharArray();
    char[] temp2 = s.toCharArray();
    int sLen = s.length();
        
    for(int i = 0, j = sLen-1; i < sLen/2; i++, j--){
	if(temp1[i] != temp2[j]) return false;            
    }
        
    return true;
}
