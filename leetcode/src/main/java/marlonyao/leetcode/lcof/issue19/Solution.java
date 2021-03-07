package marlonyao.leetcode.lcof.issue19;

class Solution {
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }

    private boolean match(String s, int sIndex, String p, int pIndex) {
        if (sIndex >= s.length() && pIndex >= p.length()) {
            return true;
        }
        if (pIndex >= p.length()) {
            return false;
        }

        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            // * 号匹配，可以匹配 0 到 多次
            do {
                if (match(s, sIndex, p, pIndex + 2)) {
                    return true;
                }
            } while (sIndex < s.length() && matchChar(s.charAt(sIndex++), p.charAt(pIndex)));
            return false;
        }
        if (sIndex < s.length() && matchChar(s.charAt(sIndex), p.charAt(pIndex))) {
            // 单字符一一匹配
            return match(s, sIndex + 1, p, pIndex + 1);
        }
        return false;
    }

    private boolean matchChar(char sChar, char pChar) {
        return pChar == '.' || sChar == pChar;
    }
}
