class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode mid = fmid(head);
        ListNode startSecond = reverse(mid.next);
        ListNode firstHalf = head;
        while(startSecond != null){
            if(firstHalf.val != startSecond.val){
                return false;
            }
            firstHalf=firstHalf.next;
            startSecond=startSecond.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public ListNode fmid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
         }
        return slow;
    }
}
