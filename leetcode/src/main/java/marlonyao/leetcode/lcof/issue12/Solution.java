package marlonyao.leetcode.lcof.issue12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) {
            return true;
        }
        List<Pos> startPosList = getStartPosList(board, word.charAt(0));
        for (Pos startPos : startPosList) {
            List<Pos> traversedPath = new ArrayList<>();
            traversedPath.add(startPos);

            if (exists(board, traversedPath, word, 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean exists(char[][] board, List<Pos> traversedPath, String word, int nextCharIndex) {
        if (nextCharIndex == word.length()) {
            return true;
        }

        Pos currentPos = traversedPath.get(traversedPath.size() - 1);
        if (tryNextPos(board, currentPos, traversedPath, word, nextCharIndex, 0, 1)) {
            return true;
        }
        if (tryNextPos(board, currentPos, traversedPath, word, nextCharIndex, 0, -1)) {
            return true;
        }
        if (tryNextPos(board, currentPos, traversedPath, word, nextCharIndex, 1, 0)) {
            return true;
        }
        if (tryNextPos(board, currentPos, traversedPath, word, nextCharIndex, -1, 0)) {
            return true;
        }
        return false;
    }

    private boolean tryNextPos(char[][] board, Pos currentPos, List<Pos> traversedPath, String word, int nextCharIndex, int i, int j) {
        Pos nextPos = new Pos(currentPos.i + i, currentPos.j + j);
        if (nextPos.i < 0 || nextPos.i >= board.length) {
            return false;
        }
        if (nextPos.j < 0 || nextPos.j >= board[nextPos.i].length) {
            return false;
        }

        char nextChar = word.charAt(nextCharIndex);
        if (nextChar != board[nextPos.i][nextPos.j] || traversedPath.contains(nextPos)) {
            return false;
        }

        traversedPath.add(nextPos);
        if (exists(board, traversedPath, word, nextCharIndex + 1)) {
            return true;
        }
        traversedPath.remove(nextPos);
        return false;
    }

    private List<Pos> getStartPosList(char[][] board, char c) {
        List<Pos> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == c) {
                    result.add(new Pos(i, j));
                }
            }
        }
        return result;
    }

    private static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pos)) return false;
            Pos pos = (Pos) o;
            return i == pos.i &&
                    j == pos.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
