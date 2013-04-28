/*
  Title: ZigZag Conversion

  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of 
  rows like this: (you may want to display this pattern in a fixed font for better legibility)
  
  P   A   H   N
  A P L S I I G
  Y   I   R

  And then read line by line: "PAHNAPLSIIGYIR"
  
  Write the code that will take a string and make this conversion given a number of rows:
  
  string convert(string text, int nRows);
  
  convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
  
  Solution: Find zigsize. Recur.
 */

public String convert(String s, int nRows) {
    if(nRows <= 1) return s;
    int zigSize = nRows*2-2;
    String res = "";
    
    for(int i = 0; i < nRows; i++)
	for(int base = i; base < s.length(); base+=zigSize) {
	    res+=s.charAt(base);
	    if(i > 0 && i < nRows-1) {// Off side rows
		int offset = base + zigSize - 2*i;
		if(offset < s.length()) res+=s.charAt(offset);
	    }
	}
	 
    return res;
}
