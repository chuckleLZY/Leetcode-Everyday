/**
 * difficulty:medium
 * use fast and slow pointers to find
 * think about the math problem, the fast and slow movements relate the cycle of turn-in point
 * the length of head to ans-node is equals of the length slow pointer to ans-node
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode low = head.next;
        while(fast!=low){
            if(fast==null||fast.next==null){
                return null;
            }
            fast = fast.next.next;
            low = low.next;
        }
        //find the ans-node, see the upper explanation
        ListNode temp = head;
        while(temp!=low){
            temp=temp.next;
            low=low.next;
        }
        return low;
    }
}