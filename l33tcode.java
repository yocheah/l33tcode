  int newLength = A.length + B.length;
        int[] AB = new int[newLength];
        double median = 0.0;
        
        if(A.length == 0) {
            // Consider B
            if((B.length % 2) == 0)
                median = (B[B.length/2] + B[(B.length/2)-1]) / 2.0;
                
            else
                median = B[B.length/2];
            
            
        } else if(B.length == 0) {
            // Consider A
            if((A.length % 2) == 0)
                median = (A[A.length/2] + A[(A.length/2)-1]) / 2.0;
                
            else
                median = A[A.length/2];            
            
        } else {
        
            if ( newLength % 2 == 0) {
                // Even number, 2 numbers needed            
            
            } else {
                // Odd number only 1 number needed 
                int medI = newLength / 2;                       
                int Aptr = 0;
                int Bptr = 0;            
            
                while ((Aptr+Bptr) <= medI) {
                
                    if(A[Aptr] < B[Bptr]) {
                    
                        median = A[Aptr];
                        Aptr+=1;
                    
                    } else {
                    
                        median = B[Bptr];
                        Bptr+=1;
                    }
                
                }
            
            }                
        }
        return median;
    }

//addTwoNumbers


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
    ListNode ptr = l1;
    ListNode ptr2 = l2;
    ListNode rptr = null;        
    ListNode result = null;        
    int add = 0;
    
    do {
	int temp = 0;
        
	if(ptr2 == null)
	    temp = ptr.val + add;
	else if(ptr == null)
	    temp = ptr2.val + add;
	else    
	    temp = ptr.val + ptr2.val + add;
	
	int newval = temp % 10;
	if (temp >= 10) 
	    add = temp / 10;
	else 
	    add = 0;
	
	if(rptr == null)
	    rptr = new ListNode(newval);
	else
	    rptr.val = newval;                  
	
	if(ptr != null)
	    ptr = ptr.next;
	if(ptr2 != null)
	    ptr2 = ptr2.next;
	
        
	if(result == null)
	    result = rptr; 
	
	if(ptr != null || ptr2 != null) {
	    rptr.next = new ListNode(0);
	    rptr = rptr.next;
	}
        
    } while (ptr != null || ptr2 != null);
    
    if (add > 0) rptr.next = new ListNode(add);
    
    return result;       
}
   


// Longest Palindromic Substring (Need to relearn O(n) time)

// Naiive O(n^3)
public static boolean isPalindrome(char[] str) {
    char[] temp1 = str;
    char[] temp2 = str;
            
    int midPoint = str.length/2;
            
    for(int i = 0, j = str.length-1; i < str.length/2; i++, j--) {
                
	if(temp1[i] != temp2[j]) {
	    return false;
	}
    }
            
    return true;
}


public String longestPalindrome(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int maxLen = 1000;
    String res = "";
        
    String newS = preProcess(s);
        
    if(isPalindrome(s.toCharArray())) return s;
        
    else {
            
	int wLen = s.length();
	int jInit = s.length()-1;
	for(int i = 0, j = jInit; wLen >= 0; i++,j++) {
	    String temp = s.substring(i,j);
	    if(isPalindrome(temp.toCharArray())) {
		res = temp;                    
	    }
                
	    if(j==s.length()) {
		if(!res.equals(""))
		    break;
		jInit--;
		i = -1;                    
		j = jInit-1;
		wLen--;                    
	    }
	}
            
    }        
        
    return res;
        
}

// O(n) time

public static String preProcess(String s) {
        
    int sLen = s.length();
        
    if(sLen == 0) return "^$";
    else {
	String newS = "^";
	for(int i = 0; i < sLen; i++) {
	    newS.concat("#").concat(s.substring(i,i+1));                
	}
	newS.concat("#$");
	return newS;
    }
}


// Valid Palindrome
public boolean isPalindrome(String s) {
    s = s.toLowerCase().replaceAll("[^a-z0-9]","");
    char[] temp1 = s.toCharArray();
    char[] temp2 = s.toCharArray();
    int sLen = s.length();
        
    for(int i = 0, j = sLen-1; i < sLen/2; i++, j--){
	if(temp1[i] != temp2[j]) return false;            
    }
        
    return true;
}


// add Binary
public String addBinary(String a, String b) {
    boolean carry = false;
    String res = "";
    String temp = "";
    int i = a.length()-1;
    int j = b.length()-1;
        
    if(a.length() == 0 || b.length() == 0) return "";
        
    while(i >= 0 || j >= 0) {
	char aChar;
	char bChar;
            
	if(i < 0 && j >= 0) {
	    aChar = '0';
	    bChar = b.charAt(j);
	} else if (j < 0 && i >= 0) {
	    aChar = a.charAt(i);
	    bChar = '0';
	} else {
	    aChar = a.charAt(i);
	    bChar = b.charAt(j);
	}
            
	if(aChar == '1' && bChar == '1') {
                
	    if(carry)
		res = temp.concat("1").concat(res);                    
	    else
		res = temp.concat("0").concat(res);
                
	    carry = true;
            
            
	} else if(aChar == '0' && bChar == '0'){

	    if(carry){
		res = temp.concat("1").concat(res);
		carry = false;
	    } else
		res = temp.concat("0").concat(res);
                                
	} else {
	    if(carry) {
		res = temp.concat("0").concat(res);
		carry = true;
	    } else {
		res = temp.concat("1").concat(res);
	    }
	}
            
	i--; j--;
    }
        
    if(carry) {
	if(i < 0 && j < 0)
	    res = temp.concat("1").concat(res);
    }
    return res;
}


// Search Insert Position
public int searchInsert(int[] A, int target) {
        
    int len = A.length;
        
    int count = A.length / 2;
    if(A[len-1] < target) return len;        
    else if(A[0] >= target) return 0;
    else {
	int prevCount = count;
	while(count >= 0 && count < A.length) {
	    if(A[count] == target) {
		return count;        
	    } else if (A[count] > target) {
		if(count > 0) {
		    if(prevCount+1 == count) return count;
		    prevCount = count;
		    count--;
		}
	    } else {
		if(count < len-1) {
		    if(prevCount-1 == count) return prevCount;
		    prevCount = count;
		    count++;
		}
	    }
	}
    }

}

// Remove Element
public int removeElement(int[] A, int elem) {
          
    int newLen = 0;
    for(int i = 0; i < A.length; i++){
	if(A[i] != elem)
	    A[newLen++] = A[i];
    }
        
    return newLen;
}

// Remove duplicates from Sorted Array
public int removeDuplicates(int[] A) {

    int prev = 0;
    int newLen = 0;
        
    for(int i = 0; i < A.length; i++){
	if(i == 0) {
	    prev = A[i];
	    A[newLen++] = A[i];
	} else if(A[i] != prev){
	    prev = A[i];
	    A[newLen++] = A[i];
	}           
    }
        
    return newLen;
}

// Remove duplicates from Sorted Array II
public int removeDuplicates(int[] A) {
    int newLen = 0;
    int prev = 0;
    boolean first = false;
    for(int i = 0; i < A.length; i++) {
	if(i == 0) {
	    prev = A[i];
	    A[newLen++] = A[i];
	    first = false;
	} else if(prev == A[i]) {
	    if(!first){
		first = true;
		A[newLen++] = A[i];
	    }
	} else {
	    A[newLen++] = A[i];
	    prev = A[i];
	    first = false;
	}
    }
    
    return newLen;
}

// Reverse Integer
public int reverse(int x) {
    boolean isNeg = false;
    int result = 0;
    if(x < 0) {
	isNeg = true;
	x*=-1;            
    }
        
    char[] xToStr = (x + "").toCharArray();
                
    int i = 0;
    int j = xToStr.length -1;
    int sIndex = 0;
    boolean firstSet = false;
    while(i < xToStr.length / 2) {
	char tempi = xToStr[i];
	char tempj = xToStr[j];            
	if(firstSet && tempj != '0') {
	    sIndex = i;
	    firstSet = true;
	}
            
	xToStr[i++] = tempj;
	xToStr[j--] = tempi;
    }
               
    result = Integer.parseInt(new String(xToStr).substring(sIndex,xToStr.length));
        
    if (isNeg) return result*-1;
    else return result;
}

// Plus One
public int[] plusOne(int[] digits) {
        
    if(digits.length == 0) {
	int[] newResult = new int[1];
	newResult[0] = 1;
	return newResult;
    }
    else {
	boolean carry = false;
	for(int i = digits.length-1; i >= 0 ; i--){
	    int temp = digits[i];
	    if(i == digits.length - 1) temp+=1;                
	    if (carry) {
		temp++;
		carry = false;
	    }
	    if(temp < 10) {
		digits[i] = temp;
	    } else {
		digits[i] = temp % 10;
		carry = true;
	    }
	}
            
	if (carry) {
	    int[] newResult = new int[digits.length+1];
	    newResult[0] = 1;
	    for(int i = 0; i < digits.length; i++) {
		newResult[i+1] = digits[i];
	    }
	    return newResult;
	}
    }
    return digits;
}



// longest valid parenthesis
public int longestValidParentheses(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int maxLen = 0;
    int cutoff = 0;
    Stack<Integer> stack = new Stack<Integer>();
        
    for(int i = 0; i < s.length(); i++){
            
	if(s.charAt(i) == '('){
	    stack.push(i);                
	} else {
	    if(stack.empty()) cutoff=i+1;
	    else{
		stack.pop();
		if(stack.empty()){
		    maxLen = Math.max(maxLen, i-cutoff+1);
		} else {
		    maxLen = Math.max(maxLen, i-stack.peek());
		}
                    
	    }
                
	}
    }
    return maxLen;
}

// Search in Rotated Sorted Array
public int search(int[] A, int target) {
    int index = -1;
    for(int i = 0; i < A.length; i++) {
	if(A[i] == target) return i;
    }
        
    return index;
}

// Pascal's Triangle
public ArrayList<ArrayList<Integer>> generate(int numRows) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
    Integer[] prevRow = new Integer[0];
    for(int i = 0; i < numRows; i++) {
	ArrayList<Integer> rowArray = new ArrayList<Integer>();
            
	if(i == 0) rowArray.add(1);
            
	if(i > 0) {                
	    rowArray.add(1);    
	    for(int j = 0; j < prevRow.length-1; j++) {
		rowArray.add(prevRow[j]+prevRow[j+1]);
	    }
	    rowArray.add(1);
	    prevRow = rowArray.toArray(new Integer[0]);
	}
            
	result.add(rowArray);
    }
    return result;
}


// Pascal's Triangle II

public ArrayList<Integer> getRow(int rowIndex) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i = 0; i <= rowIndex; i++) {
	if(i == 0) result.add(1);
	else if(i > 0) {
	    Integer[] intArray = result.toArray(new Integer[0]);
	    result = new ArrayList<Integer>();
	    result.add(1);
	    if(i > 1) {
		for(int j = 0; j < intArray.length-1; j++) {
		    result.add(intArray[j]+intArray[j+1]);                        
		}                    
	    }
	    result.add(1);
	}            
    }
        
    return result;
}

// Note: Optimized O(k) space

public ArrayList<Integer> getRow(int rowIndex) {
    ArrayList<Integer> result = new ArrayList<Integer>();
        
    if(rowIndex == 0) {
	result.add(1);                        
	return result;
    }       
            
    result.add(1);
    result.add(1);
    for(int i = 2; i <= rowIndex; i++) {                
	result.add(1, result.get(0)+result.get(1));
	for(int j = 2; j < result.size()-1; j++) {
	    result.set(j, result.get(j)+result.get(j+1));
	}
    }            
                
    return result;
}

// First Missing Positive
public int firstMissingPositive(int[] A) {        
    int i = 0;
    while (i < A.length) {
	int v = A[i];
            
	if(v <= 0 ||  // if (A[i] is negative
	   v > A.length || // if A[i] is larger than length, so invalid
	   v == i+1 ||  // if i == A[i] move on (e.g., i=1, v=2 (v is 2nd e)
	   A[v-1] == v) // No need for swap
	    i++;    
	else {
	    A[i] = A[v-1]; // swap A[v-1] with A[i] 
	    A[v-1] = v;  // swap A[i] with A[v-1]
	}
    }
        
    for (i = 0; i < A.length && A[i] == i+1; i++);
        
    return i+1;
}

// Maximum Depth of Binary Tree
public int maxDepth(TreeNode root) {
    int left = 0;
    int right = 0;        
        
    if(root == null) return 0;
        
    if(root.left != null)
	left+=maxDepth(root.left);
    if(root.right != null)
	right+=maxDepth(root.right);
            
    return (left > right) ? (left+=1) : (right+=1);
}

// Minimum Depth of Binary Tree
public int minDepth(TreeNode root) {
    if( root == null ) return 0;
        
    int right = 0;
    int left = 0;
    if( root.left != null)
	left+=minDepth(root.left);
    if(root.right!= null)
	right+=minDepth(root.right);
        
    if(left == 0 && right == 0) return 1; // leaf node
    else if(left > 0 && right == 0) return left+=1;
    else if(right > 0 && left == 0) return right+=1;
    else return (left < right) ? (left+=1) : (right+=1);
        
}

// Same Tree
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    else if(p == null && q != null) return false;
    else if(p != null && q == null) return false;
    else if(p.val != q.val) return false;
        
    boolean left = isSameTree(p.left, q.left);
    boolean right = isSameTree(p.right, q.right);
            
    if(left && right) return true;
    else return false;
}

// Validate Binary Search Tree

public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
        
    boolean leftSubTree = true;
    boolean rightSubTree = true;        
    if(root.left != null) {
	if(root.left.val >= root.val) return false;
	else leftSubTree = isValidBSTHelper(root.left, null, root.val+"");
    }
        
    if(root.right != null) {
	if(root.right.val <= root.val) return false;
	else rightSubTree = isValidBSTHelper(root.right, root.val+"", null);	
    }

    if(leftSubTree && rightSubTree) return true;
    else return false;   
}
    
public static boolean isValidBSTHelper(TreeNode root, String min, String max) {
    if(root == null) return true;
        
    boolean leftSubTree = true;
    boolean rightSubTree = true;
                    
    if(root.left != null){            
                
	if(root.left.val >= root.val) return false;
	else if(min != null && root.left.val <= Integer.parseInt(min)) return false; 
	else leftSubTree = isValidBSTHelper(root.left, min, root.val+"");	
    }
        
    if(root.right != null) {
	if(root.right.val <= root.val) return false;
	else if(max != null && root.right.val >= Integer.parseInt(max)) return false;
	else rightSubTree = isValidBSTHelper(root.right, root.val+"", max);	
    }
        
    if(rightSubTree && leftSubTree) return true;
    else return false;
}

// Path Sum
public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null) return false;            
        
    if(root.val == sum && (root.left == null && root.right == null)) 
	return true;
        
    boolean left = false;
    boolean right = false;
    if(root.left != null)
	left = hasPathSum(root.left, sum-root.val);        
            
    if(root.right != null)
	right = hasPathSum(root.right, sum-root.val);        
        
    return (left || right) ? true : false;
} 

// Path Sum II
public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    
    if(root == null)  return res;
        
    if(root.val == sum && (root.left == null && root.right == null)) {
	ArrayList<Integer> a = new ArrayList<Integer>();
	a.add(root.val);
	res.add(a);
	return res;
    }
        
    ArrayList<ArrayList<Integer>> left = null;
    ArrayList<ArrayList<Integer>> right = null;
        
    if(root.left != null)
	left = pathSum(root.left, sum-root.val);

    if(root.right != null)
	right = pathSum(root.right, sum-root.val);
         
    if(left != null) {
	for(int i = 0; i < left.size(); i++) {
	    ArrayList<Integer> temp = left.get(i);
	    temp.add(0, root.val);
	    res.add(temp);
	}
    }
        
    if(right != null) {
	for(int i = 0; i < right.size(); i++) {
	    ArrayList<Integer> temp = right.get(i);
	    temp.add(0, root.val);
	    res.add(temp);
	}
    }

    return res;
}


// Valid Number
public  boolean isNumber(String s) {      
       
    s = s.trim();        
        
    // Integers
    try {
	Integer.parseInt(s);
	return true;
    } catch (Exception e) {}
               
    // Handle e functions        
    String[] sa = s.split("e", 1);
        
    if(sa.length == 2) {
            
	if(!sa[0].contains(" ") && !sa[1].contains(" "))
	    try {
		Integer.parseInt(sa[0]);
		Integer.parseInt(sa[1]);
		return true;
	    } catch (Exception e) {}
    }
       
     
    // Doubles
    try {
            
	// prevent hex
	if(s.charAt(s.length()-1) <= 122 && s.charAt(s.length()-1) >= 65) {
                
	} else {
            
	    Double.parseDouble(s);
	    return true;
	}
    } catch (Exception e) {}
                
       
    return false;
}

// Rotate List
public ListNode rotateRight(ListNode head, int n) {
 
   ListNode ptr = head;   
    if(head == null || n == 0 || head.next == null) return head;
        
    // calculate length first;
    int length = 0;
    while(ptr != null) {
	ptr = ptr.next;
	length++;
    }
       
    ListNode newhead = head;        
    int rem = n % length; // handle loops
        
    if(rem == 0) return newhead;
    else {
        
	ListNode newtails = null;
	ListNode newtailsptr = null;
	ListNode newheadsptr = null;            
	int border = length-rem;

	ptr = head;

	for(int i = 0; i < border; i++) { // loop and create tail first
        
	    if(i == 0) {           
		newtails = new ListNode(ptr.val);
		newtailsptr = newtails;
	    } else
		newtails.next = new ListNode(ptr.val);                             
	    ptr = ptr.next;                      
	} 
            
	for(int i = border; i < length; i++) { // loop and create head then
	    if(i == border) {
		newhead = new ListNode(ptr.val);
		newheadsptr = newhead;
		if(i+1 == length) 
		    newhead.next = newtailsptr;
	    } else {
		newhead.next = new ListNode(ptr.val);
		if(i+1 == length) {
		    newhead = newhead.next;
		    newhead.next = newtailsptr;
		}                    
		newhead = newhead.next;
	    }
                
	    ptr = ptr.next;
	}
            
	return newheadsptr;
    }
}

// Rotate Image
public void rotate(int[][] matrix) {
                
    int bound = matrix.length-1;
    int i = 0, j = 0;
    int k = 0, l = bound;
    int m = bound, n = bound;
    int o = bound, p = 0;
        
    while(j < bound && i < bound) {
	int temp = matrix[i][j];
	matrix[i][j] = matrix[o][p];
	matrix[o][p] = matrix[m][n];
	matrix[m][n] = matrix[k][l];
	matrix[k][l] = temp; 
            
	if(j+1 == bound){
	    bound--;
	    i++; j=i;
	    k=i; l=bound;
	    m=bound; n=bound;
	    o=bound; p=i;
	} else {
	    j++; k++; n--; o--;
	}
    }
}

// Valid Sudoku
public boolean isValidSudoku(char[][] board) {        
        
    java.util.Vector v = new java.util.Vector();
        
    // Row scan
    for(int i = 0; i < board.length; i++) {
	for(int j = 0; j < board.length; j++) {
	    if(board[i][j] == '.') continue;
	    if(v.isEmpty())
		v.add(board[i][j]);
	    else {
		if(v.contains(board[i][j])) return false;
		else v.add(board[i][j]);
	    }       
	}
	v.clear();
    }          
        
    // Column scan
    v.clear();
    for(int i = 0; i < board.length; i++) {
	for(int j = 0; j < board.length; j++) {
	    if(board[j][i] == '.') continue;
	    if(i == 0 && j == 0)
		v.add(board[j][i]);
	    else {
		if(v.contains(board[j][i])) return false;
		else v.add(board[j][i]);
	    }       
	}
	v.clear();
    }          
        
    //9x9 scan
    for(int i = 0; i < board.length; i+=3) {
	for(int j = 0; j < board.length; j+=3) {
	    if(!scan(i,j,i+3,j+3, board)) return false;
	}
    }
       
    return true;
}
    
public static boolean scan(int starti, int startj, int ib, int jb, char[][] board) {
    java.util.Vector v = new java.util.Vector();

    for(int i = starti; i < ib; i++) {
	for(int j = startj; j < jb; j++) {
	    if(board[i][j] == '.') continue;
	    if(v.isEmpty())
		v.add(board[i][j]);
	    else {
		if(v.contains(board[i][j])) return false;
		else v.add(board[i][j]);
	    }       
	}
    } 
        
    return true;
}

public ArrayList<String> letterCombinations(String digits) {
    
    String two = "abc";
    String three = "def";
    String four = "ghi";
    String five = "jkl";
    String six = "mno";
    String seven = "pqrs";
    String eight = "tuv";
    String nine = "wxyz";

    ArrayList<String> res = new ArrayList<String>();

    if(digits.length() == 0) {
        res.add("");
        return res;
    } else {
        //array for storing number of alphabets mapped to digit
        int nelem[] = new int[digits.length()];
        int arrayListLen = 1;
        int div = 0;

        // store mappings in array
        for(int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);

            if(c == '7' || c == '9') nelem[i] = 4;
            else nelem[i] = 3;
            
            if(i > 0) arrayListLen*=nelem[i];
        }
        
        // iterate over array        
	for(int i = 0; i < nelem.length; i++) {
	    char c = digits.charAt(i);
	    String chars = "";
	    
	    if(i > 0) div = div/nelem[i-1];

	    switch (c) {
	    case '2': chars = two; break;
	    case '3': chars = three; break;
	    case '4': chars = four; break;
	    case '5': chars = five; break;
	    case '6': chars = six; break;
	    case '7': chars = seven; break;
	    case '8': chars = eight; break;
	    case '9': chars = nine; break;
            }
	    
            if(i == 0) {
                for(int j = 0; j < chars.length(); j++)
                    for(int count = 0; count < arrayListLen; count++)
                        res.add(chars.charAt(j)+"");
                arrayListLen = arrayListLen*chars.length();
                div = arrayListLen;
            } else{
		int bound = div/chars.length();				
                for(int j = 0, count = 0; j < arrayListLen;)
                    for(int k = 0; k < chars.length(); j++) {
			res.set(j, res.get(j) + chars.charAt(k));
			if(count+1 < bound) count++;
			else {
			    k++;
			    count = 0;
			}
                    }   
            }
        }
    }
    
    return res;
}


// Remove duplicates from sorted list
public ListNode deleteDuplicates(ListNode head) {
    if(head != null && head.next != null) {
	ListNode p1 = head;
	ListNode p2 = head.next;
            
	while(p2 != null) {
	    if(p2.val == p1.val) {
		//relink
		p2 = p2.next;
		p1.next = p2;
	    } else {
		// Advance pointers
		p1 = p2;
		p2 = p2.next;                
	    }
	}            
    }
        
    return head;    
}

// Remove duplicates from sorted list II
public ListNode deleteDuplicates(ListNode head) {
    ListNode newhead = new ListNode(0);
    newhead.next = head;
        
    ListNode cur = head; // cursor
    ListNode prev = newhead; // prev cursor
    while(cur != null) {
	boolean dup = false;
	while(cur.next != null && cur.next.val == cur.val) {
	    dup = true;
	    cur = cur.next;
	} // skip all duplicates
	if(dup) prev.next = cur.next;
	else prev = cur;            
            
	cur = cur.next;
    }
    return newhead.next;
}

// Combinations
public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
    if(k == 0) return res;
    else if(k == 1) {
	for(int i = 1; i <= n; i++) {
	    ArrayList<Integer> a = new ArrayList<Integer>();
	    a.add(i);
	    res.add(a);
	}
    } else{
	ArrayList<ArrayList<Integer>> part = combine(n, k-1); 
            
	for(ArrayList a : part) {
	    int e = (Integer) a.get(a.size()-1);
	    for(int i = e+1; i <= n; i++) {
		ArrayList<Integer> copy = (ArrayList<Integer>) a.clone();
		if(copy.size() < k) {
		    copy.add(i);
		    res.add(copy);
		}
	    }
	}
    }
        
    return res;
}


// Divide Two Integers
// Solution:
public static int divide(int dividend, int divisor) {
                
    boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);        
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
        
    if(divisor == 0) return Integer.MAX_VALUE; // return exception
    else if(divisor == Integer.MIN_VALUE) {
	if(dividend == Integer.MIN_VALUE) return 1;
	else return 0;
    } else if(dividend == Integer.MIN_VALUE) {                         
	int res = divide(dividend + divisor, divisor);
	return neg ? res-1 : 1-res;            
    }
        
    int product = divisor;
    int result = 0;
        
    while(dividend >= product) {
	int q = 1;
	while(dividend - product >= product) {
	    q = q << 1;
	    product = product << 1;
	}
            
	dividend = dividend - product;
	product = divisor;
	result += q;            
    }
        
    return neg ? -result : result;        
}

// Second solution: More elegant
/* Comment: Use log(a/b) = log(a) - log(b)
   so, a/b = exp(log(a) - log(b)).

   Overflow conditions: Math.abs of Integer.MIN = Integer.MIN.
   Solution: manually set to Integer.MAX.

   Special case: 
   1) Integer.MIN / 2 = -1073741824, but 
      Integer.MAX / 2 = 1073741823

   2) Integer.MAX/Integer.MIN = 0 (not -1).

   3) Right shift if divisor = 2.

*/
public int divide(int dividend, int divisor) {
    if(divisor == 0) return Integer.MAX_VALUE;
    else if(divisor == 1) return dividend;
    else if(divisor == 2) return dividend >> 1;
    else if(dividend == divisor) return 1;        
    else if(dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE) return 0;
    else {
	boolean neg = (dividend > 0 && divisor < 0) || (divisor > 0 && dividend < 0);
            
	dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);
	divisor = divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(divisor);
	int result = (int) Math.floor(Math.pow(Math.E, Math.log(dividend)-Math.log(divisor)));
            
	return neg ? -result : result;        
    }   
}
