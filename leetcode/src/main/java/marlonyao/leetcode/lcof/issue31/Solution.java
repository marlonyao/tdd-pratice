package marlonyao.leetcode.lcof.issue31;

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushedArr, int[] poppedArr) {
        IntArrayIterator pushed = new IntArrayIterator(pushedArr);
        IntArrayIterator popped = new IntArrayIterator(poppedArr);

        Stack<Integer> stack = new Stack<>();
        while (popped.hasNext()) {
            int nextPopped = popped.next();
            while (stack.isEmpty() || (stack.peek() != nextPopped)) {
                if (!pushed.hasNext()) {
                    return false;
                }
                stack.push(pushed.next());
            }
            stack.pop();
        }
        return true;
    }

    static class IntArrayIterator {
        int[] array;
        int pos;

        public IntArrayIterator(int[] array) {
            this.array = array;
        }

        public int next() {
            return array[pos++];
        }

        public boolean hasNext() {
            return pos < array.length;
        }
    }
}