package marlonyao.leetcode.main.issue137;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.singleNumber(new int[]{2, 2, 3, 2})).isEqualTo(3);
        assertThat(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99})).isEqualTo(99);
    }
}