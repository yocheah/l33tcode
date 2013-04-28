/*
   Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

   For example,
   Given:
   s1 = "aabcc",
   s2 = "dbbca",
   
   When s3 = "aadbbcbcac", return true.
   When s3 = "aadbbbaccc", return false. 
   
  Run Status: Accepted!
  Program Runtime: 664 milli secs
  Progress: 48/48 test cases passed.

  Run Status: Accepted!
  Program Runtime: 668 milli secs
  Progress: 99/99 test cases passed.

  Solution: recursively check. Tricky case when same character present in both strings.
 */

public boolean isInterleave(String s1, String s2, String s3) {
    int l1 = s1.length();
    int l2 = s2.length();
    int l3 = s3.length();
        
    if(l1+l2 != l3) return false;
    if(s1.equals("") || s2.equals("")) {
	if(s3.equals(s2) || s3.equals(s1)) return true;
	else return false;
    }
        
    char c1 = s1.charAt(l1-1);
    char c2 = s2.charAt(l2-1);
    char c3 = s3.charAt(l3-1);
    if(c3 == c1) {
	if(c3 == c2) {
	    return (isInterleave(s1.substring(0,l1-1), s2, s3.substring(0,l3-1)) ||
		    isInterleave(s1, s2.substring(0,l2-1), s3.substring(0,l3-1)));
	} else return isInterleave(s1.substring(0,l1-1), s2, s3.substring(0,l3-1));
            
    } else if(c3 == c2) return isInterleave(s1, s2.substring(0,l2-1), s3.substring(0,l3-1));
    else return false;        
}
