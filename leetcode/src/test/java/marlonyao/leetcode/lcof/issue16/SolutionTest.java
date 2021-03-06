package marlonyao.leetcode.lcof.issue16;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void myPow() {
        Solution solution = new Solution();
        assertThat(solution.myPow(2.0, 0)).isEqualTo(1.0);
        assertThat(solution.myPow(2.0, 1)).isEqualTo(2.0);
        assertThat(solution.myPow(2.0, 2)).isEqualTo(4.0);
        assertThat(solution.myPow(2.0, 10)).isEqualTo(1024.0);
        assertThat(solution.myPow(2.1, 3)).isCloseTo(9.261, Offset.offset(1E-6));
        assertThat(solution.myPow(2.0, -2)).isCloseTo(0.25, Offset.offset(1E-6));
    }
}