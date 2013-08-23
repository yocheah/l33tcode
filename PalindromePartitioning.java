/*
  Title: Palindrome Partitioning

  Given a string s, partition s such that every substring of the partition is a palindrome.
  
  Return all possible palindrome partitioning of s.
  
  For example, given s = "aab",
  Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]


  Solution: Use depth first search.

  Run Status: Accepted!
  Program Runtime: 588 milli secs
  Progress: 10/10 test cases passed.

  Run Status: Accepted!
  Program Runtime: 1868 milli secs
  Progress: 20/20 test cases passed.

*/

public boolean isPalindrome(String s) {
    s = s.toLowerCase().replaceAll("[^a-z0-9]","");
    char[] temp1 = s.toCharArray();
    char[] temp2 = s.toCharArray();
    int sLen = s.length();

    for(int i = 0, j = sLen-1; i < sLen/2; i++, j--) {
        if(temp1[i] != temp2[j]) return false;
    }

    return true;
}
   
public ArrayList<ArrayList<String>> dfs(String s){
    ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
    int sLen = s.length();

    if(sLen <= 1){
        results.add(new ArrayList<String>());        
        if(sLen == 1) results.get(0).add(s);
        return results;
    }

    for(int i = 1; i <= sLen; i++){
        if(isPalindrome(s.substring(0, i))) {
            ArrayList<ArrayList<String>> tmp = dfs(s.substring(i));
            for(ArrayList<String> result : tmp){
                result.add(0, s.substring(0, i));
                results.add(result);
            }
        }
    }

    return results;
}

public ArrayList<ArrayList<String>> partition(String s) {
    ArrayList<ArrayList<String>> allResults = new ArrayList<ArrayList<String>>();
    if(s == null) return allResults;
    else return this.dfs(s);    
}
