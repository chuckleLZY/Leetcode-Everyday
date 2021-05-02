/**
 * Difficulty: Easy
 * Use fast and slow pointers to find the repeat node
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
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while(temp1!=temp2){
            if(temp2==null||temp2.next==null){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        return true;
    }
}