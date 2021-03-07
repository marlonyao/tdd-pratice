package marlonyao.leetcode.lcof.issue18;

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        for (ListNode prev = null, cur = head; cur != null; prev = cur, cur = cur.next) {
            if (cur.val != val) {
                continue;
            }
            if (prev == null) {
                return cur.next;
            }
            prev.next = cur.next;
            return head;
        }
        return head;
    }
}
