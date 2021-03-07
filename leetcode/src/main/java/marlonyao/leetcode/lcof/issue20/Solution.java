package marlonyao.leetcode.lcof.issue20;

class Solution {
    public boolean isNumber(String s) {
        int startIndex = 0;
        for (; startIndex < s.length() && Character.isWhitespace(s.charAt(startIndex)); ) {
            startIndex++;
        }
        if (startIndex < s.length() && isPosNeg(s.charAt(startIndex))) {
            startIndex++;
        }
        if (startIndex >= s.length()) {
            return false;
        }

        boolean meetDigit = false;
        boolean meetDigitAfterE = false;
        boolean meetDot = false;
        int eIndex = -1;
        int i = startIndex;
        for (; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                break;
            }
            if (eIndex < 0 && !meetDot && s.charAt(i) == '.') {
                meetDot = true;
                continue;
            }
            if (eIndex < 0 && meetDigit && isE(s.charAt(i))) {
                eIndex = i;
                continue;
            }
            if (eIndex >= 0 && i == eIndex + 1 && isPosNeg(s.charAt(i))) {
                continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
            meetDigit = true;
            if (eIndex >= 0) {
                meetDigitAfterE = true;
            }
        }
        if (!meetDigit || (eIndex >= 0 && !meetDigitAfterE)) {
            return false;
        }
        for (; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isE(char c) {
        return c == 'e' || c == 'E';
    }

    private boolean isPosNeg(char c) {
        return c == '-' || c == '+';
    }
}
