package marlonyao.leetcode.lcof.issue20;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isNumber() {
        Solution solution = new Solution();
        assertThat(solution.isNumber("")).isFalse();
        assertThat(solution.isNumber("123")).isTrue();
        assertThat(solution.isNumber("a123")).isFalse();
        assertThat(solution.isNumber("-123")).isTrue();
        assertThat(solution.isNumber("123.45")).isTrue();
        assertThat(solution.isNumber(".123")).isTrue();
        assertThat(solution.isNumber("1.2.3")).isFalse();
        assertThat(solution.isNumber("5e2")).isTrue();
        assertThat(solution.isNumber("5ee2")).isFalse();
        assertThat(solution.isNumber("5e2.0")).isFalse();
        assertThat(solution.isNumber("5e")).isFalse();
        assertThat(solution.isNumber("5e-2")).isTrue();
        assertThat(solution.isNumber("5e+2")).isTrue();
        assertThat(solution.isNumber("5e1+2")).isFalse();
        assertThat(solution.isNumber("+-5")).isFalse();
        assertThat(solution.isNumber("+")).isFalse();
        assertThat(solution.isNumber("e1")).isFalse();

        assertThat(solution.isNumber("-1E-16")).isTrue();
        assertThat(solution.isNumber("0123")).isTrue();
        assertThat(solution.isNumber("1a3.14")).isFalse();
        assertThat(solution.isNumber("12e+5.4")).isFalse();
        assertThat(solution.isNumber(".")).isFalse();
        assertThat(solution.isNumber("1e+")).isFalse();

        assertThat(solution.isNumber("1")).isTrue();

        assertThat(solution.isNumber(" 1")).isTrue();
        assertThat(solution.isNumber(" 1 ")).isTrue();
        assertThat(solution.isNumber(" . ")).isFalse();
        assertThat(solution.isNumber(" 3. ")).isTrue();
        assertThat(solution.isNumber(" .e1 ")).isFalse();
    }
}