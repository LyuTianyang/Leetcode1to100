package num_0024_ListNode;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}
public class SwapNodeInPairs {
	
	/**
	 * 
	 * 给出listnode 1-2-3-4-5，得到 1-2-4-3-5
	 * 
	 * 假如只对调3-4
	 * 2.next = 4, 4.next = 3,3.next=5
	 * 
	 */
	public static ListNode swapNodeInPairs(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		while(current.next != null && current.next.next !=null){
			swap(current);
			current = current.next.next;
		}
		return dummy.next;
	}
	public static void swap(ListNode pre){
		ListNode dummy = pre.next;
		pre.next = dummy.next;
		dummy.next = dummy.next.next;
		pre.next.next = dummy;
	}
	
	public static void main(String[] args) {
			
			ListNode l1 = new ListNode(1);
			l1.next = new ListNode(2);
			l1.next.next = new ListNode(3);
			l1.next.next.next= new ListNode(4);
			l1.next.next.next.next= new ListNode(5);
			
			ListNode result = swapNodeInPairs(l1);
			System.out.println(result);
	}
}
