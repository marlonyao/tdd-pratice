package marlonyao.leetcode.lcof.issue29;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        spiralOrder(result, matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        return toIntArray(result);
    }

    public void spiralOrder(List<Integer> result, int[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }
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

        spiralOrder(result, matrix, startRow + 1, endRow - 1, startCol + 1, endCol - 1);
    }

    private int[] toIntArray(List<Integer> list) {
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer value : list) {
            result[i++] = value;
        }
        return result;
    }
}
