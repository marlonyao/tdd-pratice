package marlonyao.leetcode.lcof.issue18;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void deleteNode() {
        Solution solution = new Solution();
        assertThat(solution.deleteNode(null, 3)).isEqualTo(null);
        assertThat(solution.deleteNode(makeLink(1), 1)).isEqualTo(null);
        assertThat(solution.deleteNode(makeLink(1), 3)).isEqualTo(makeLink(1));
        assertThat(solution.deleteNode(makeLink(4, 5, 1, 9), 5)).isEqualTo(makeLink(4, 1, 9));
        assertThat(solution.deleteNode(makeLink(4, 5, 1, 9), 1)).isEqualTo(makeLink(4, 5, 9));
    }

    private ListNode makeLink(int... values) {
        return makeLink(values, 0, values.length);
    }

    private ListNode makeLink(int[] values, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return null;
        }
        ListNode head = new ListNode(values[startIndex]);
        head.next = makeLink(values, startIndex + 1, endIndex);
        return head;
    }
}