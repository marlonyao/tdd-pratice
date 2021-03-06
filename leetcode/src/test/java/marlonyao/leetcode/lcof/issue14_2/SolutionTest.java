package marlonyao.leetcode.lcof.issue14_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void cuttingRope() {
        Solution solution = new Solution();
        assertThat(solution.cuttingRope(2)).isEqualTo(1);
        assertThat(solution.cuttingRope(10)).isEqualTo(36);
        assertThat(solution.cuttingRope(1000)).isEqualTo(620946522);
    }
}