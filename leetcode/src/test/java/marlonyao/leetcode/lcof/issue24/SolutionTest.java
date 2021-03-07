package marlonyao.leetcode.lcof.issue24;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void reverseList() {
        Solution solution = new Solution();
        assertThat(solution.reverseList(null)).isEqualTo(null);
        assertThat(solution.reverseList(makeList(1))).isEqualTo(makeList(1));
        assertThat(solution.reverseList(makeList(1, 2))).isEqualTo(makeList(2, 1));
        assertThat(solution.reverseList(makeList(1, 2, 3, 4)))
                .isEqualTo(makeList(4, 3, 2, 1));
    }

    private ListNode makeList(int... values) {
        return makeList(values, 0, values.length);
    }

    private ListNode makeList(int[] values, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return null;
        }
        ListNode head = new ListNode(values[startIndex]);
        head.next = makeList(values, startIndex + 1, endIndex);
        return head;
    }
}