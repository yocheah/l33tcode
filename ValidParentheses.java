/*
  Title: Valid Parentheses

  Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
  determine if the input string is valid.

  The brackets must close in the correct order, "()" and "()[]{}" are all valid 
  but "(]" and "([)]" are not.

  Run Status: Accepted!
  Program Runtime: 520 milli secs
  Progress: 12/12 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 520 milli secs
  Progress: 61/61 test cases passed.
*/

public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
       
    for(int i = 0; i < s.length(); i++) {
	char c = s.charAt(i);
	if(c == '(' || c == '{' || c == '[') stack.push(c);
	else {
	    if((c == ']' && !stack.empty() && stack.peek() == '[') ||
	       (c == '}' && !stack.empty() && stack.peek() == '{') ||
	       (c == ')' && !stack.empty() && stack.peek() == '('))
		stack.pop();
	    else return false;
	}
    }
       
    if(!stack.empty()) return false;       
    return true;
}
