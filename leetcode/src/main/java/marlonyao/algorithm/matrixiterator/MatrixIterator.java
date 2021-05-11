package marlonyao.algorithm.matrixiterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Integer> {
    private int[][] nums2d;
    private int rowIdx;
    private int colIdx;

    public MatrixIterator(int[][] nums2d) {
        this.nums2d = nums2d;
    }

    @Override
    public boolean hasNext() {
        return rowIdx < nums2d.length;
    }

    @Override
    public Integer next() {
        if (rowIdx >= nums2d.length) {
            return null;
        }

        Integer result = nums2d[rowIdx][colIdx];
        if (colIdx + 1 < nums2d[rowIdx].length) {
            colIdx++;
        } else {
            do {
                rowIdx++;
            } while (rowIdx < nums2d.length && nums2d[rowIdx].length == 0);
            colIdx = 0;
        }
        return result;
    }
}