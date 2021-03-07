package marlonyao.leetcode.lcof.issue29;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        IntArray result = new IntArray(matrix.length * matrix[0].length);
        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            outMost(result, matrix, startRow, endRow, startCol, endCol);
            startRow += 1; endRow -= 1;
            startCol += 1; endCol -= 1;
        }
        return result.array;
    }

    public void outMost(IntArray result, int[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        for (int j = startCol; j <= endCol; j++) { // first row
            result.add(matrix[startRow][j]);
        }
        for (int i = startRow + 1; i <= endRow; i++) { // last column
            result.add(matrix[i][endCol]);
        }
        if (endRow > startRow) {    // 至少有两行
            for (int j = endCol - 1; j >= startCol; j--) {   // last row
                result.add(matrix[endRow][j]);
            }
        }
        if (endCol > startCol) {    // 至少有两列
            for (int i = endRow - 1; i >= startRow + 1; i--) {   // first column
                result.add(matrix[i][startCol]);
            }
        }
    }

    static class IntArray {
        int[] array;
        int index;

        public IntArray(int size) {
            this.array = new int[size];
        }

        public void add(int value) {
            array[index++] = value;
        }
    }
}
