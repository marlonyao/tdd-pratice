package marlonyao.leetcode.main.issue004;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})).isEqualTo(2);
        assertThat(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})).isEqualTo(2.5);
        assertThat(solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0})).isEqualTo(0);
        assertThat(solution.findMedianSortedArrays(new int[]{}, new int[]{1})).isEqualTo(1);
        assertThat(solution.findMedianSortedArrays(new int[]{2}, new int[]{})).isEqualTo(2);
    }
}