package marlonyao.leetcode.lcof.issue19;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void isMatch() {
        Solution solution = new Solution();
        assertThat(solution.isMatch("", "")).isTrue();
        assertThat(solution.isMatch("aa", "aa")).isTrue();
        assertThat(solution.isMatch("aa", "a")).isFalse();
        assertThat(solution.isMatch("aa", ".a")).isTrue();
        assertThat(solution.isMatch("", "a*")).isTrue();
        assertThat(solution.isMatch("a", "a*")).isTrue();
        assertThat(solution.isMatch("aa", "a*")).isTrue();
        assertThat(solution.isMatch("aab", "a*")).isFalse();
        assertThat(solution.isMatch("a", ".*")).isTrue();
        assertThat(solution.isMatch("", "a")).isFalse();
        assertThat(solution.isMatch("ab", "a.")).isTrue();
        assertThat(solution.isMatch("aab", "c*a*b")).isTrue();
        assertThat(solution.isMatch("mississippi", "mis*is*p*.")).isFalse();
        assertThat(solution.isMatch("ab", ".*c")).isFalse();
    }
}