/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
**************************************************************/


//  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int length = 0;
        ListNode temp = head;
        ListNode current = head;
        ListNode previous = null;
        while (temp != null){
            length += 1;
            temp = temp.next; 
        }
        length -= n;
        if (length == 0){
            temp = head.next;
            head.next = null;
            head = null;
            return temp;
        } 
        while (length > 0){
            previous = current;
            current = current.next;
            length -= 1;
        }
        previous.next = current.next;
        current.next = null;
        current = null;
            return head;
    }
}
