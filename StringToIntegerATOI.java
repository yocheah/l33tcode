/*
  Title: String to Integer (atoi)

  Implement atoi to convert a string to an integer.

  Hint: Carefully consider all possible input cases. If you want a challenge, 
  please do not see below and ask yourself what are the possible input cases.

  Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
  You are responsible to gather all the input requirements up front.

  Requirements for atoi:

  The function first discards as many whitespace characters as necessary until 
  the first non-whitespace character is found. Then, starting from this character, 
  takes an optional initial plus or minus sign followed by as many numerical digits 
  as possible, and interprets them as a numerical value.

  The string can contain additional characters after those that form the integral 
  number, which are ignored and have no effect on the behavior of this function.

  If the first sequence of non-whitespace characters in str is not a valid integral 
  number, or if no such sequence exists because either str is empty or it contains 
  only whitespace characters, no conversion is performed.

  If no valid conversion could be performed, a zero value is returned. If the correct 
  value is out of the range of representable values, INT_MAX (2147483647) or 
  INT_MIN (-2147483648) is returned.

  Run Status: Accepted!
  Program Runtime: 484 milli secs
  Progress: 30/30 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 752 milli secs
  Progress: 1039/1039 test cases passed.

 */

public int atoi(String str) {
    str = str.trim();
    StringBuilder temp = new StringBuilder();
    boolean needsInt = false;
    boolean isNeg = false;
    boolean hasSign = false;
        
    if(str.length() == 0) return 0;
                
    for(int i = 0; i < str.length(); i++) {
	char c = str.charAt(i);
	if(c == '+' || c == '-') {
	    if(hasSign) return 0;
	    else hasSign = true;
	    if(c == '-') isNeg = true;
	} else if(c >= '0' && c <= '9') {
	    temp.append(c);
	    needsInt = true;
	} else {
	    if(needsInt) break;
	    else return 0; 
	}                
    }

    try {
	if(isNeg) temp.insert(0,"-");
	return Integer.parseInt(temp.toString());
             
    } catch (Exception e) {
	String max = Integer.MAX_VALUE+"";
	String min = Integer.MIN_VALUE+"";            
            
	if(isNeg){
	    if(temp.toString().equals(min) ||
	       temp.toString().length() > min.length()) return Integer.MIN_VALUE;
	    for(int i = 0, j = 0; (i < temp.toString().length() || j < min.length()); i++, j++)
		if(temp.toString().charAt(i) > min.charAt(j)) return Integer.MIN_VALUE;
  
	}else {
	    if(temp.toString().equals(max) ||
	       temp.toString().length() > max.length()) return Integer.MAX_VALUE;
	    for(int i = 0, j = 0; i < temp.toString().length() || j < max.length(); i++, j++)
		if(temp.toString().charAt(i) > max.charAt(j)) return Integer.MAX_VALUE;

	}
            
	return 0;
    }    
}
