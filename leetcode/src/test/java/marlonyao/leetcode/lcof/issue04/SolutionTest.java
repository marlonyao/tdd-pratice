package marlonyao.leetcode.lcof.issue04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                { 1 },
                { 2 }
        };

        assertThat(solution.findNumberIn2DArray(matrix, 2)).isTrue();
        assertThat(solution.findNumberIn2DArray(matrix, 1)).isTrue();
        assertThat(solution.findNumberIn2DArray(matrix, 3)).isFalse();
    }
}