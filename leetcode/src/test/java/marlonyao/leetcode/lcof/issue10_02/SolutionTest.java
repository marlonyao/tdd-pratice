package marlonyao.leetcode.lcof.issue10_02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void numWays() {
        Solution solution = new Solution();

        assertThat(solution.numWays(0)).isEqualTo(1);
        assertThat(solution.numWays(1)).isEqualTo(1);
        assertThat(solution.numWays(2)).isEqualTo(2);
        assertThat(solution.numWays(3)).isEqualTo(3);
        assertThat(solution.numWays(7)).isEqualTo(21);
    }
}