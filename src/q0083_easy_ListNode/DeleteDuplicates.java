package q0083_easy_ListNode;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}

public class DeleteDuplicates {
	/**
	给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
	输入: 1->1->2
	输出: 1->2
	
	输入: 1->1->2->3->3
	输出: 1->2->3
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while(cur != null && cur.next != null){
			if(cur.val == cur.next.val){
				cur.next = cur.next.next;
			}else{
				cur = cur.next;
			}
		}
		return head;
    }
	
	public static ListNode deleteDuplicates1(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy.next;
		while(cur!=null && cur.next!=null){
			if(cur.val == cur.next.val){
				cur.next = cur.next.next;
			}else{
				cur = cur.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(2);
		l2.next.next.next= new ListNode(3);
		
		ListNode result = deleteDuplicates1(l2);
		System.out.println(result);
	}
}
