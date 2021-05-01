package marlonyao.leetcode.main.issue006;

class Solution {
    public String convert(String s, int numRows) {
        /*
        0     6      12
        1   5 7   11 13
        2 4   8 10   14
        3     9      15

        每一行对应索引如下，其中 X = 2 * n - 2
        - 第0行：0 X 2X
        ...
        - 第i行: i X-i X+i 2X-i 2X+i
        ...
        - 第n-1行：n-1 X+n-1 2X+n-1

        分别按次序遍历所有行即可
         */
        if (numRows <= 1) { // 必须特殊处理
            return s;
        }

        int x = 2 * numRows - 2;
        StringBuilder result = new StringBuilder(s.length());
        outputHeadOrTail(result, s, x, 0);
        for (int i = 1; i < numRows - 1; i++) {
            outputMiddle(result, s, x, i);
        }
        outputHeadOrTail(result, s, x, numRows - 1);
        return result.toString();
    }

    private void outputHeadOrTail(StringBuilder result, String s, int x, int i) {
        for (int index = i; index < s.length(); index += x) {
            result.append(s.charAt(index));
        }
    }

    private void outputMiddle(StringBuilder result, String s, int x, int i) {
        // 第i行: i X-i X+i 2X-i 2X+i
        if (i < s.length()) {
            result.append(s.charAt(i));
        }
        for (int base = x; ; base += x) {
            if (base - i < s.length()) {
                result.append(s.charAt(base - i));
            }
            if (base + i < s.length()) {
                result.append(s.charAt(base + i));
            } else {
                break;
            }
        }
    }
}

