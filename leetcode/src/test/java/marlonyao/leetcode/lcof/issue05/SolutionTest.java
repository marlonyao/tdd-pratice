package marlonyao.leetcode.lcof.issue05;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void replaceSpace() {
        Solution solution = new Solution();
        assertThat(solution.replaceSpace("")).isEqualTo("");
        assertThat(solution.replaceSpace(" ")).isEqualTo("%20");
        assertThat(solution.replaceSpace("We are happy.")).isEqualTo("We%20are%20happy.");
    }
}