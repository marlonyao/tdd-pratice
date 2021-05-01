package marlonyao.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeapTest {
    @Test
    public void buildHeap() {
        Heap heap = new Heap(new int[]{1, 2, 3});
        assertThat(heap.getMin()).isEqualTo(1);

        heap = new Heap(new int[]{2, 1, 3});
        assertThat(heap.getMin()).isEqualTo(1);

        heap = new Heap(new int[]{2, 3, 1});
        assertThat(heap.getMin()).isEqualTo(1);
    }
    
    @Test
    public void popMin() {
        Heap heap = new Heap(new int[]{2, 3, 1});
        assertThat(heap.popMin()).isEqualTo(1);
        assertThat(heap.popMin()).isEqualTo(2);
        assertThat(heap.popMin()).isEqualTo(3);
    }

    @Test
    public void popMinWithEmpty() {
        Heap heap = new Heap(new int[0]);
        assertThatThrownBy(() -> heap.popMin())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("empty heap");

        assertThatThrownBy(() -> heap.getMin())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("empty heap");
    }
}