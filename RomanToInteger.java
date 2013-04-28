/*

  Title: Roman to Integer

  Given a roman numeral, convert it to an integer.
  
  Input is guaranteed to be within the range from 1 to 3999.
  
  Run Status: Accepted!
  Program Runtime: 492 milli secs
  Progress: 16/16 test cases passed.

  Run Status: Accepted!
  Program Runtime: 976 milli secs
  Progress: 3999/3999 test cases passed.

  Solution: Setup map first and then build iteratively.
  
  
 */
public int romanToInt(String s) {
    int res = 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    setup(map);
        
    for(int i = 0; i < s.length(); i++) {
	int p1 = map.get(s.charAt(i));
	if(i+1 < s.length()) {                
	    int p2 = map.get(s.charAt(i+1));

	    if(p1 < p2) {
		res+=(p2-p1);
		i++;
	    } else res+=p1;
	} else res+=p1;            
    }
        
    return res;
}
    
public void setup(HashMap<Character, Integer> map) {
    map.put('I', 1);        
    map.put('V', 5);        
    map.put('X', 10);        
    map.put('L', 50);        
    map.put('C', 100);        
    map.put('D', 500);        
    map.put('M', 1000);
}
