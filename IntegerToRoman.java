/*
  Title: Integer to Roman

  Given an integer, convert it to a roman numeral.
  
  Input is guaranteed to be within the range from 1 to 3999.

  Run Status: Accepted!
  Program Runtime: 524 milli secs
  Progress: 30/30 test cases passed.

  Run Status: Accepted!
  Program Runtime: 1032 milli secs
  Progress: 3999/3999 test cases passed.
  
  Solution: HashMap add and then iteratively generate string.
 */

public String intToRoman(int num) {
    if(num == 0) return "";
    else {
	StringBuilder res = new StringBuilder();
	
	int[] indexes = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	setup(map);
	
	for(int i : indexes) {
	    while(num - i >= 0) {
		res.append(map.get(i));
		num -= i;
	    }
	}
	
	return res.toString();
    }
}

public static void setup(HashMap<Integer, String> map) {
    map.put(1, "I");
    map.put(4, "IV");
    map.put(5, "V");
    map.put(9, "IX");
    map.put(10, "X");
    map.put(40, "XL");
    map.put(50, "L");
    map.put(90, "XC");
    map.put(100, "C");
    map.put(400, "CD");
    map.put(500, "D");
    map.put(900, "CM");
    map.put(1000, "M");
}

