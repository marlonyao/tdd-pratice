package marlonyao.leetcode.lcof.issue29;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void spiralOrder() {
        Solution solution = new Solution();
        assertThat(solution.spiralOrder(new int[][]{})).containsExactly();
        assertThat(solution.spiralOrder(new int[][]{{1, 2, 3}})).containsExactly(1, 2, 3);
        assertThat(solution.spiralOrder(new int[][]{{1}, {2}, {3}})).containsExactly(1, 2, 3);
        assertThat(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}})).containsExactly(1, 2, 3, 6, 5, 4);
        assertThat(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}))
                .containsExactly(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertThat(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}))
                .containsExactly(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
    }
}