/*
  Title: Simplify Path

  Given an absolute path for a file (Unix-style), simplify it.
  
  For example,
  path = "/home/", => "/home"
  path = "/a/./b/../../c/", => "/c"
  Corner Cases:
  
  Did you consider the case where path = "/../"?
  In this case, you should return "/".
  Another corner case is the path might contain multiple slashes '/' together, 
  such as "/home//foo/".
  In this case, you should ignore redundant slashes and return "/home/foo".

  Run Status: Accepted!
  Program Runtime: 488 milli secs
  Progress: 23/23 test cases passed.
 
  Run Status: Accepted!
  Program Runtime: 712 milli secs
  Progress: 243/243 test cases passed.
 
  Solution: Split and identify corner cases.
 */

public String simplifyPath(String path) {
    String res = "/";
    Stack<String> s = new Stack<String>();
    String[] dirs = path.split("/+");
        
    for(String d : dirs) {
	if(d.equals("..")) {
	    if(!s.empty()) s.pop();
	} else if(!d.equals(".") && !d.equals("")) s.push(d);
    }
        
    while(!s.empty()) res = "/" + s.pop() + res;        
    return res.length() > 1 ? res.substring(0,res.length()-1) : res;
}
