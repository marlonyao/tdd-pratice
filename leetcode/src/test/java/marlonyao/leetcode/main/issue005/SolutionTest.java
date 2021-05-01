package marlonyao.leetcode.main.issue005;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.longestPalindrome("babad")).isEqualTo("bab");
        assertThat(solution.longestPalindrome("cbbd")).isEqualTo("bb");
        assertThat(solution.longestPalindrome("a")).isEqualTo("a");
    }
}