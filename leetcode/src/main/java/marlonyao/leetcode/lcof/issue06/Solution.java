package marlonyao.leetcode.lcof.issue06;

public class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        int size = 0;
        for (ListNode node = head; node != null; node = node.next) {
            size++;
        }

        int[] result = new int[size];
        for (ListNode node = head; node != null; node = node.next) {
            result[--size] = node.val;
        }

        return result;
    }
}
