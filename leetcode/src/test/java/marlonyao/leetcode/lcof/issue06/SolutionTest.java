package marlonyao.leetcode.lcof.issue06;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void reversePrint() {
        Solution solution = new Solution();
        ListNode head = makeNode(1);

        assertThat(solution.reversePrint(null)).isEqualTo(new int[]{});
        assertThat(solution.reversePrint(head)).isEqualTo(new int[]{1});

        head = makeNode(1, 2);
        assertThat(solution.reversePrint(head)).isEqualTo(new int[]{2, 1});
    }

    private ListNode makeNode(int... x) {
        if (x.length == 0) {
            return null;
        }
        ListNode result = new ListNode(x[0]);

        int[] remain = new int[x.length - 1];
        System.arraycopy(x, 1, remain, 0, remain.length);

        result.next = makeNode(remain);
        return result;
    }
}