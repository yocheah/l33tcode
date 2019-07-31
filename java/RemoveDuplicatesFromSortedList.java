/*

  Title: Remove Duplicates from Sorted List

  Given a sorted linked list, delete all duplicates such that each element appear only once.
  
  For example,
  Given 1->1->2, return 1->2.
  Given 1->1->2->3->3, return 1->2->3.

  Solution: Traverse and relink using two pointers
*/

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
