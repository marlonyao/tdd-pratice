package marlonyao.algorithm.sort;

// 最小堆实现
public class Heap {
    private int[] array;
    private int size;

    public Heap(int[] array) {
        this.array = array;
        this.size = array.length;
        buildHeap();
    }

    private void buildHeap() {
        // 自底向上构建堆，最后一个元素的parent开始，一直到根节点
        for (int i = parent(size - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        // 对以 i 为根的子树变成堆，假定它的两个子树都是堆。
        // 比较 array[i]、array[left(i)] 和 array[right(i)] 谁最小
        // 1. 如果 array[i] 最小，完成。
        // 2. 如果 array[left(i)] 最小，交换 array[left(i)] 和 array[i]，并 heapify(left(i))
        // 3. 如果 array[right(i)] 最小，交换 array[right(i)] 和 array[i]，并 heapify(right(i))
        int left = left(i), right = right(i);
        int smallest = findSmallest(i, left, right);

        if (smallest == i) {
            return;
        } else {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private int findSmallest(int i, int left, int right) {
        int smallest = i;
        if (left < size && array[left] < array[i]) {
            smallest = left;
        }
        if (right < size && array[right] < array[smallest]) {
            smallest = right;
        }
        return smallest;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("empty heap");
        }
        return array[0];
    }

    public int popMin() {
        if (size == 0) {
            throw new IllegalStateException("empty heap");
        }
        // 交换 root 和 最后一个元素，将 size 减一，然后 heapify(0)
        int result = array[0];
        swap(0, --size);
        heapify(0);
        return result;
    }

    public int size() {
        return size;
    }
}
