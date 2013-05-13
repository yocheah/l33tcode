/*
  Title: Length of Last Word

  Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
  return the length of last word in the string.
  
  If the last word does not exist, return 0.
  
  Note: A word is defined as a character sequence consists of non-space characters only.
  
  For example,
  Given s = "Hello World",
  return 5.
  
  // Loop from beginning of string.
  Run Status: Accepted!
  Program Runtime: 524 milli secs
  Progress: 19/19 test cases passed.
  
  Run Status: Accepted!
  Program Runtime: 492 milli secs
  Progress: 59/59 test cases passed.
  

  // Loop from end of string.
  Run Status: Accepted!
  Program Runtime: 544 milli secs
  Progress: 19/19 test cases passed.

  Run Status: Accepted!
  Program Runtime: 532 milli secs
  Progress: 59/59 test cases passed.
  
 */

// Loop from beginning of string.
public int lengthOfLastWord(String s) {
    char[] cArray = s.trim().toCharArray();
    int countLastWord = 0;

    for(int i = 0; i < cArray.length; i++) {
        if(cArray[i] != ' ') {
            countLastWord++;
        } else {
            countLastWord = 0;
        }
    }

    return countLastWord;
}

// Loop from end of string.
public int lengthOfLastWord(String s) {
    char[] cArray = s.toCharArray();
    int sLen = s.length();
    int countLastWord = 0;

    for(int i = sLen-1; i >= 0; i--) {
        if(cArray[i] != ' ') {
            countLastWord++;
        } else if(cArray[i] == ' ' && countLastWord > 0){
            break;
        } else {
            countLastWord = 0;
        }
    }

    return countLastWord;
}
