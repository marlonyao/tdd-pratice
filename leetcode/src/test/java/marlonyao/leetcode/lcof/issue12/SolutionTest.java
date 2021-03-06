package marlonyao.leetcode.lcof.issue12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void exist() {
        Solution solution = new Solution();

        char[][] board = makeBoard("abce", "sfcs", "adee");
        assertThat(solution.exist(board, "")).isTrue();
        assertThat(solution.exist(board, "b")).isTrue();
        assertThat(solution.exist(board, "bf")).isTrue();
        assertThat(solution.exist(board, "bfc")).isTrue();
        assertThat(solution.exist(board, "bfce")).isTrue();
        assertThat(solution.exist(board, "abfb")).isFalse();

        board = makeBoard("ABCE", "SFCS", "ADEE");
        assertThat(solution.exist(board, "ABCCED")).isTrue();

        board = makeBoard("ab", "cd");
        assertThat(solution.exist(board, "abcd")).isFalse();
    }

    private char[][] makeBoard(String... strings) {
        char[][] result = new char[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            result[i] = strings[i].toCharArray();
        }
        return result;
    }
}