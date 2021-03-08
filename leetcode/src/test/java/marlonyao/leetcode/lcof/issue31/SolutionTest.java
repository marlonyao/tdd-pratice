package marlonyao.leetcode.lcof.issue31;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void validateStackSequences() {
        Solution solution = new Solution();
        assertThat(solution.validateStackSequences(new int[]{}, new int[]{})).isTrue();
        assertThat(solution.validateStackSequences(new int[]{1}, new int[]{1})).isTrue();
        assertThat(solution.validateStackSequences(new int[]{1, 2}, new int[]{1, 2})).isTrue();
        assertThat(solution.validateStackSequences(new int[]{1, 2}, new int[]{2, 1})).isTrue();

        assertThat(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1})).isTrue();
        assertThat(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2})).isFalse();
    }
}