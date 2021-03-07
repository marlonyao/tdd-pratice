package marlonyao.leetcode.lcof.issue21;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void exchange() {
        Solution solution = new Solution();
        assertThat(solution.exchange(new int[] {})).isEmpty();
        assertThat(solution.exchange(new int[]{1})).containsExactly(1);
        assertThat(solution.exchange(new int[]{2, 1})).containsExactly(1, 2);

        int[] result = solution.exchange(new int[]{1, 2, 3, 4});
        assertThat(Arrays.copyOfRange(result, 0, 2)).containsExactlyInAnyOrder(1, 3);
        assertThat(Arrays.copyOfRange(result, 2, 4)).containsExactlyInAnyOrder(2, 4);
    }

    private void assertResult(int[] array) {
        boolean meetEven = false;
        for (int i = 0; i < array.length; i++) {
            if (meetEven && array[i] % 2 == 1) {
                fail("not even after odd");
            }
            if (array[i] % 2 == 0) {
                meetEven = true;
            }
        }
    }
}