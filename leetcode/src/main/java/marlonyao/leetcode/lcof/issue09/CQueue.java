package marlonyao.leetcode.lcof.issue09;

import java.util.Stack;

class CQueue {
    private Stack<Integer> putStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        putStack.push(value);
    }

    public int deleteHead() {
        if (popStack.isEmpty()) {
            while (!putStack.isEmpty()) {
                popStack.push(putStack.pop());
            }
        }
        if (popStack.isEmpty()) {
            return -1;
        }
        return popStack.pop();
    }
}