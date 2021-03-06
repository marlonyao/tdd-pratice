package marlonyao.leetcode.lcof.issue11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minArray() {
        Solution solution = new Solution();
        assertThat(solution.minArray(new int[]{1})).isEqualTo(1);
        assertThat(solution.minArray(new int[]{1, 2})).isEqualTo(1);
        assertThat(solution.minArray(new int[]{2, 1})).isEqualTo(1);
        assertThat(solution.minArray(new int[]{3, 1, 2})).isEqualTo(1);
        assertThat(solution.minArray(new int[]{3, 4, 5, 1, 2})).isEqualTo(1);
        assertThat(solution.minArray(new int[]{2, 2, 2, 0, 1})).isEqualTo(0);
    }
}