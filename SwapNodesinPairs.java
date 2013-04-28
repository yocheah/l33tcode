/*

  Title: Swap Nodes in Pairs
  Given a linked list, swap every two adjacent nodes and return its head.
  
  For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
  
  Your algorithm should use only constant space. You may not modify the values in 
  the list, only nodes itself can be changed. 

  Run Status: Accepted!
  Program Runtime: 528 milli secs
  Progress: 6/6 test cases passed.

  Run Status: Accepted!
  Program Runtime: 608 milli secs
  Progress: 55/55 test cases passed.

  Solution: Use two pointers. Swap if both pointers are not null.

*/

public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) return head;
        
    ListNode p1 = head, p2 = head.next;
        
    while(p1 != null || p2 != null) {
	int temp = p2.val;
	p2.val = p1.val;
	p1.val = temp;
            
	if(p2.next != null) p1=p2.next;
	else break;
	if(p1.next != null) p2=p1.next;
	else break;
    }
        
    return head;
}
