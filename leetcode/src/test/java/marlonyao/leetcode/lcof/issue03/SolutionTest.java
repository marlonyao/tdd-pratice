package marlonyao.leetcode.lcof.issue03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    public void should_return_negative_given_no_duplicate() {
        int result = solution.findRepeatNumber(new int[]{0, 1});
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void should_return_one_duplicate() {
        int result = solution.findRepeatNumber(new int[]{1, 1});
        assertThat(result).isEqualTo(1);
    }
}