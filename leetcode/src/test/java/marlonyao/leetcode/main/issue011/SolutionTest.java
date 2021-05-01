package marlonyao.leetcode.main.issue011;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})).isEqualTo(49);
        assertThat(solution.maxArea(new int[]{1, 1})).isEqualTo(1);
        assertThat(solution.maxArea(new int[]{4, 3, 2, 1, 4})).isEqualTo(16);
        assertThat(solution.maxArea(new int[]{1, 2, 1})).isEqualTo(2);
    }
}