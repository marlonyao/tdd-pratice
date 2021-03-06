package marlonyao.leetcode.lcof.issue10_1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void fib() {
        Solution solution = new Solution();
        assertThat(solution.fib(0)).isEqualTo(0);
        assertThat(solution.fib(1)).isEqualTo(1);
        assertThat(solution.fib(2)).isEqualTo(1);
        assertThat(solution.fib(3)).isEqualTo(2);
        assertThat(solution.fib(4)).isEqualTo(3);
        assertThat(solution.fib(5)).isEqualTo(5);
        assertThat(solution.fib(6)).isEqualTo(8);
        assertThat(solution.fib(100)).isGreaterThan(0);
    }
}