package marlonyao.leetcode.lcof.issue13;

class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];    // visit 后设为 1
        int[][] seeds = new int[m][n];      // 待搜索集合，为 1 时表示未搜索，为 2 表示已经搜索过，防止重复搜索

        visited[0][0] = 1;
        seeds[0][0] = 1;

        int seedsCount;
        do {
            seedsCount = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (seeds[i][j] == 1) {
                        seedsCount++;
                        seeds[i][j] = 2;
                        visitNext(m, n, k, visited, seeds, i + 1, j);
                        visitNext(m, n, k, visited, seeds, i - 1, j);
                        visitNext(m, n, k, visited, seeds, i, j + 1);
                        visitNext(m, n, k, visited, seeds, i, j - 1);
                    }
                }
            }
        } while (seedsCount > 0);

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private void visitNext(int m, int n, int k, int[][] visited, int[][] seeds, int i, int j) {
        if (legal(m, n, k, i, j)) {
            visited[i][j] = 1;
            if (seeds[i][j] == 0) {
                seeds[i][j] = 1;
            }
        }
    }

    private boolean legal(int m, int n, int k, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (sumOfDigits(i) + sumOfDigits(j) > k) {
            return false;
        }
        return true;
    }

    int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
