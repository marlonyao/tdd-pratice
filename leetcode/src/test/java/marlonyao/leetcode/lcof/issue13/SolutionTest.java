package marlonyao.leetcode.lcof.issue13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void movingCount() {
        Solution solution = new Solution();
        assertThat(solution.movingCount(2, 3, 1)).isEqualTo(3);
        assertThat(solution.movingCount(3, 1, 0)).isEqualTo(1);
        assertThat(solution.movingCount(10, 10, 5)).isEqualTo(21);
        assertThat(solution.movingCount(40, 40, 18)).isEqualTo(1484);
    }

    @Test
    public void sumOfDigits() {
        Solution solution = new Solution();
        assertThat(solution.sumOfDigits(0)).isEqualTo(0);
        assertThat(solution.sumOfDigits(10)).isEqualTo(1);
        assertThat(solution.sumOfDigits(12)).isEqualTo(3);
        assertThat(solution.sumOfDigits(123)).isEqualTo(6);
    }
}