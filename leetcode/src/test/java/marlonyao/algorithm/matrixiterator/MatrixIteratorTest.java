package marlonyao.algorithm.matrixiterator;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatrixIteratorTest {
    @Test
    public void test() {
        assertThat(asList(new MatrixIterator(new int[][]{}))).isEqualTo(ImmutableList.of());
        assertThat(asList(new MatrixIterator(new int[][]{{1}}))).isEqualTo(ImmutableList.of(1));
        assertThat(asList(new MatrixIterator(new int[][]{{1},{2}}))).isEqualTo(ImmutableList.of(1, 2));
        assertThat(asList(new MatrixIterator(new int[][]{{1}, {}, {2}}))).isEqualTo(ImmutableList.of(1, 2));
        assertThat(asList(new MatrixIterator(new int[][]{{1}, {}, {2, 3}}))).isEqualTo(ImmutableList.of(1, 2, 3));
        assertThat(asList(new MatrixIterator(new int[][]{{1}, {2, 3}, {4}, {}}))).isEqualTo(ImmutableList.of(1, 2, 3, 4));
    }

    private static <E> List<E> asList(Iterator<E> itor) {
        List<E> result = new ArrayList<>();
        for (; itor.hasNext(); ) {
            result.add(itor.next());
        }
        return result;
    }
}