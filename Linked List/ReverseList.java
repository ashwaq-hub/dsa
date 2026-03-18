/**
 * Logic / Strategy : curr.next = prev dance Time: O(n) Space: O(1)
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

	public static void main(String args[]) {
		ReverseList rl = new ReverseList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode reversedHead = rl.reverseList(head);
		while (reversedHead != null) {
			System.out.print(reversedHead.val + " ");
			reversedHead = reversedHead.next;
		}
	}
}