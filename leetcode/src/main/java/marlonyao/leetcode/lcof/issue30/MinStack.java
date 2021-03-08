package marlonyao.leetcode.lcof.issue30;

import java.util.Stack;

class MinStack {
    private Stack<Node> stack;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x, x));
        } else {
            Node lastNode = stack.peek();
            stack.push(new Node(x, Math.min(lastNode.min, x)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int min() {
        return stack.peek().min;
    }

    static class Node {
        int value;
        int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
