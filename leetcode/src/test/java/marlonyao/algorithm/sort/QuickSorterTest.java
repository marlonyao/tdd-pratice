package marlonyao.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSorterTest {
    @Test
    public void test() {
        assertThat(sort(1, 2, 3)).isEqualTo(new int[]{1, 2, 3});
        assertThat(sort(2, 1, 3)).isEqualTo(new int[]{1, 2, 3});
        assertThat(sort(3, 1, 2)).isEqualTo(new int[]{1, 2, 3});
    }

    private int[] sort(int... array) {
        new QuickSorter().sort(array);
        return array;
    }
}