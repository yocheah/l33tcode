/*
  Title: Longest Common Prefix
  
  Write a function to find the longest common prefix string amongst an array of strings. 
  
  Run Status: Accepted!
  Program Runtime: 532 milli secs
  Progress: 20/20 test cases passed.
  
  Large: Exceeded

  Run Status: Accepted!
  Program Runtime: 540 milli secs
  Progress: 20/20 test cases passed.

  Run Status: Accepted!
  Program Runtime: 816 milli secs
  Progress: 117/117 test cases passed.


 */

public String longestCommonPrefix(String[] strs) {
    String prefix = "";
    if(strs.length == 0) return prefix;
    else prefix = strs[0];
                
    while(prefix.length() > 0) {
	boolean found  = true;
	for(String s : strs) {
	    if((s.length() < prefix.length()) || 
	       (!s.substring(0,prefix.length()).equals(prefix))) {                    
		prefix = prefix.substring(0,prefix.length()-1);
		found = false;
		break;
	    }
	}
            
	if(found) return prefix;            
    }
        
    return prefix;
}



// Alternate solution
public String longestCommonPrefix(String[] strs) {

    if (strs.length == 0) return "";
    
    String prefix = strs[0];
    if (strs.length == 1) return prefix;

    for (int i = 1; i < strs.length; i++){
	prefix = CommonPrefix(prefix, strs[i]);
	if (prefix == "") return prefix;
    }
    return prefix;
}
    
public String CommonPrefix(String a, String b){
    int la = a.length();
    int lb = b.length();
    int limit = (la < lb) ? la : lb;
    for (int i= 0; i < limit; i++)
	if(a.charAt(i) != b.charAt(i)) return a.substring(0, i);
	    
    return a.substring(0, limit);
}
