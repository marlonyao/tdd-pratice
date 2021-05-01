package marlonyao.algorithm.sort;

public class QuickSorter {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        int index = split(array, startIndex, endIndex);
        sort(array, startIndex, index - 1);
        sort(array, index + 1, endIndex);
    }

    // 对 array 进行分割，在左边的部分, pivot, 右边的部分；左边部分 < pivot <= 右边部分；
    // 返回 pivot 的index。
    private int split(int[] array, int startIndex, int endIndex) {
        // 以第一个元素pivot = array[startIndex]作为分割，小于它的放在左边，>=它的放在右边。
        // init：i = j = startIndex; swap(startIndex, endIndex);
        // INV：array[startIndex, i) < pivot， array[i, j) >= pivot
        // step:
        // 1. 如果 array[j] >= pivot：j++。
        // 2. 否则，swap(i, j), i++, j++。
        // 直到 j = endIndex；swap(i, endIndex)，返回 i。
        int i = startIndex, j = startIndex;
        int pivot = array[startIndex];
        swap(array, startIndex, endIndex);
        while (j < endIndex) {
            if (array[j] >= pivot) {
                j++;
            } else {
                swap(array, i++, j++);
            }
        }
        swap(array, i, endIndex);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
