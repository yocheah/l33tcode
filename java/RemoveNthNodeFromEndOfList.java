/*

  Title: Remove Nth Node From End of List

  Given a linked list, remove the nth node from the end of list and return its head.
  
  For example,
  
  Given linked list: 1->2->3->4->5, and n = 2.
  
  After removing the second node from the end, the linked list becomes 1->2->3->5.
  
  Note:
  Given n will always be valid.
  Try to do this in one pass. 


  
  Solution: Create fake head and traverse n. Next, use two pointers and stop when pointer
  from n approaches end. Relink 2nd pointer.

  Run Status: Accepted!
  Program Runtime: 568 milli secs
  Progress: 7/7 test cases passed.

  Run Status: Accepted!
  Program Runtime: 704 milli secs
  Progress: 207/207 test cases passed.

 */

public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head.next == null) return null;
       
    ListNode tail = head; // First pointer
    for(int i = n; i > 0; i--){
	tail = tail.next;
    }
       
    ListNode newhead = new ListNode(0); // rogue head
    ListNode prev = newhead; // pointer to prev element
    ListNode target = head;  // target to remove
    newhead.next = head; // point to actual head
       
    while(tail != null) {
	tail = tail.next;
	prev = prev.next;
	target = target.next;
    }
       
    prev.next = target.next;
       
    return newhead.next;       
}
