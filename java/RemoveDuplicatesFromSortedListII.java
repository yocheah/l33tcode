/*
  
  Title: Remove Duplicates from Sorted List II

  Given a sorted linked list, delete all nodes that have duplicate numbers, 
  leaving only distinct numbers from the original list.
  
  For example,
  Given 1->2->3->3->4->4->5, return 1->2->5.
  Given 1->1->1->2->3, return 2->3.

  Solution: Use two pointers. Create dummy head.
*/


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
