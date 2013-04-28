/*
  Title: Count and Say

  The count-and-say sequence is the sequence of integers beginning as follows:
  1, 11, 21, 1211, 111221, ...
  
  1 is read off as "one 1" or 11.
  11 is read off as "two 1s" or 21.
  21 is read off as "one 2, then one 1" or 1211.
  
  Given an integer n, generate the nth sequence.
  
  Note: The sequence of integers will be represented as a string. 


  Run Status: Accepted!
  Program Runtime: 480 milli secs
  Progress: 5/5 test cases passed.

  Run Status: Accepted!
  Program Runtime: 508 milli secs
  Progress: 18/18 test cases passed.

 */

public String countAndSay(int n) {
    String result = "1";
    for(int i = 0; i < n-1; i++) result = sayIt(result);
    return result;
}

public String sayIt(String s) {
    StringBuilder buf = new StringBuilder();
    for(int i = 0 ; i < s.length(); i++) {
	int count = 1;
	while(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
	    i++; count++;
	}
	buf.append(count+""+s.charAt(i));
    }

    return buf.toString();
}
