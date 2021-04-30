package marlonyao.leetcode.lcof.issue33;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.verifyPostorder(new int[]{})).isEqualTo(true);
        assertThat(solution.verifyPostorder(new int[]{1, 2})).isEqualTo(true);
        assertThat(solution.verifyPostorder(new int[]{2, 1})).isEqualTo(true);
        assertThat(solution.verifyPostorder(new int[]{4, 3, 2})).isEqualTo(true);
        assertThat(solution.verifyPostorder(new int[]{4, 3, 2, 1})).isEqualTo(true);
        assertThat(solution.verifyPostorder(new int[]{1, 6, 3, 2, 5})).isEqualTo(false);
        assertThat(solution.verifyPostorder(new int[]{1, 3, 2, 6, 5})).isEqualTo(true);
        assertThat(solution.verifyPostorder(new int[]{5, 4, 3, 2, 1})).isEqualTo(true);
    }
}
