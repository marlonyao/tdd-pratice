package marlonyao.leetcode.main.issue005;

class Solution {
    public String longestPalindrome(String s) {
        // 以第i个位置向外扩展找最大回文：
        //    [i-j, i+j] 是回文：
        //      如果 s[i-j-1] == s[i+j+1]，则继续 j+1
        //      否则 回文串为 s[i-j, i+j]
        // 如果: s[i] = s[i+1]
        //    [i-j, i+1+j] 是回文
        //      如果 s[i-j-1] == s[i+j+2]，则继续 j+1
        //      否则 回文串为 s[i-j, i+1+j]
        Range longest = Range.ZERO_LEN;
        for (int i = 0; i < s.length(); i++) {
            Range range = findLongestPalindromeWithCenter(s, i);
            if (range.length() > longest.length()) {
                longest = range;
            }
        }
        return s.substring(longest.startIndex, longest.endIndex + 1);
    }

    private Range findLongestPalindromeWithCenter(String s, int i) {
        Range range1 = doFind(s, i, i);
        if (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
            Range range2 = doFind(s, i, i + 1);
            if (range2.length() > range1.length()) {
                return range2;
            }
        }
        return range1;
    }

    private Range doFind(String s, int i0, int i1) {
        //    s[i0-j, i1+j] 是回文
        //      如果 s[i0-j-1] == s[i1+j+1]，则继续 j+1
        //      否则 回文串为 s[i0-j, i1+j]
        int j = 0;
        for (; i0 - j - 1 >= 0 && i1 + j + 1 < s.length()
                && s.charAt(i0 - j - 1) == s.charAt(i1 + j + 1); j++) {
        }
        return new Range(i0 - j, i1 + j);
    }

    static class Range {
        int startIndex, endIndex;

        static Range ZERO_LEN = new Range(0, -1);

        public Range(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public int length() {
            return endIndex - startIndex + 1;
        }
    }
}
