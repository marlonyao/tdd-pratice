package marlonyao.leetcode.main.issue006;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR");
        assertThat(solution.convert("PAYPALISHIRING", 4)).isEqualTo("PINALSIGYAHRPI");
        assertThat(solution.convert("A", 1)).isEqualTo("A");
    }

}