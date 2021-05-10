package marlonyao.leetcode.main.issue015;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})).isEqualTo(ImmutableList.of(
                ImmutableList.of(-1, 0, 1),
                ImmutableList.of(-1, -1, 2)
        ));
        assertThat(solution.threeSum(new int[]{})).isEqualTo(ImmutableList.of());
        assertThat(solution.threeSum(new int[]{0})).isEqualTo(ImmutableList.of());
        assertThat(solution.threeSum(new int[]{-2, 1, 3})).isEqualTo(ImmutableList.of());
        assertThat(solution.threeSum(new int[]{3,0,-2,-1,1,2})).isEqualTo(ImmutableList.of());
    }
}