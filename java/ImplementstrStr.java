/*
  Title: Implement strStr()

 Implement strStr().

 Returns a pointer to the first occurrence of needle in haystack, or null 
 if needle is not part of haystack. 

  Run Status: Accepted!
  Program Runtime: 576 milli secs
  Progress: 16/16 test cases passed.

  Run Status: Accepted!
  Program Runtime: 652 milli secs
  Progress: 67/67 test cases passed.

*/
public String strStr(String haystack, String needle) {
    int np = 0;
    int start = 0;
    boolean isPart = false;
    if(needle.length() == 0 || needle.equals(haystack)) return haystack;

    for(int i = 0; i < haystack.length(); i++) {
        if(np == needle.length()) return haystack.substring(start);
        else if(isPart) {
            if(haystack.charAt(i) != needle.charAt(np++)){
                isPart = false;
                np = 0;
                i = start;
                start = 0;
            }
        } else {
            if(haystack.charAt(i) == needle.charAt(np)) {
                isPart = true;
                start = i;
                np++;
            }
        }
    }
    return null;
}
