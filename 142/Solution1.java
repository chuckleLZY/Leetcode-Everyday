/**
 * difficulty:medium
 * use hashset to find like No.141
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
        HashSet<ListNode> table = new HashSet<ListNode>();
        while(head!=null){
            if(table.contains(head)){
                return head;
            }
            table.add(head);
            head=head.next;
        }
        return null;
    }
}