package marlonyao.leetcode.main.issue003;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(solution.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(solution.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }
}