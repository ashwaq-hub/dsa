/**
 * Logic / Strategy : curr.next = prev dance
 * Time: O(n)
 * Space: O(1)
 *
 * Strategy: Iterative three-pointer swap (prev, curr, next).
 */

class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void main(String args[]){
        
    }
}