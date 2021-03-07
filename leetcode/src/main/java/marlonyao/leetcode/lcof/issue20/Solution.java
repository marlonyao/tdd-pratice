package marlonyao.leetcode.lcof.issue20;

import static java.lang.Character.isDigit;
import static java.lang.Character.isWhitespace;

class Solution {
    public boolean isNumber(String s) {
        try {
            Lexer lexer = new Lexer(s);
            lexer.realNumber();
            return lexer.isEnd();
        } catch (ParseException e) {
            return false;
        }
    }

    static class ParseException extends RuntimeException {
        public ParseException(String message) {
            super(message);
        }
    }

    static class Lexer {
        char[] s;
        int pos;

        public Lexer(String s) {
            this.s = s.toCharArray();
            this.pos = 0;
        }

        public void realNumber() {
            whitespaces();
            coreRealNumber();
            whitespaces();
        }

        public boolean isEnd() {
            return pos == s.length;
        }

        private void coreRealNumber() {
            decimalPart();
            if (isE(peekChar())) {
                nextChar();
                integer();
            }
        }

        private void decimalPart() {
            if (isSign(peekChar())) {
                nextChar();
            }
            if (isDigit(peekChar())) {
                posInteger();
                if (isDot(peekChar())) {
                    nextChar();
                    if (isDigit(peekChar())) {
                        posInteger();
                    }
                }
            } else if (isDot(peekChar())) {
                nextChar();
                posInteger();
            } else {
                throw new ParseException("expect [0..9] or dot or +/-");
            }
        }

        private void integer() {
            if (isSign(peekChar())) {
                nextChar();
            }
            posInteger();
        }

        private void posInteger() {
            if (!isDigit(peekChar())) {
                throw new ParseException("expect [0-9]");
            }
            while (isDigit(peekChar())) {
                nextChar();
            }
        }

        public void whitespaces() {
            while (isWhitespace(peekChar())) {
                nextChar();
            }
        }

        private int peekChar() {
            if (pos < s.length) {
                return s[pos];
            }
            return -1;
        }

        private char nextChar() {
            if (pos >= s.length) {
                throw new ParseException("EOF");
            }
            return s[pos++];
        }
    }

    private static boolean isE(int c) {
        return c == 'e' || c == 'E';
    }

    private static boolean isSign(int c) {
        return c == '-' || c == '+';
    }

    private static boolean isDot(int c) {
        return c == '.';
    }
}
