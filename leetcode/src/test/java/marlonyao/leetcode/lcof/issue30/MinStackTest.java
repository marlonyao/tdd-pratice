package marlonyao.leetcode.lcof.issue30;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinStackTest {
    @Test
    public void minstack() {
        MinStack stack = new MinStack();

        stack.push(-2);
        assertThat(stack.top()).isEqualTo(-2);
        assertThat(stack.min()).isEqualTo(-2);

        stack.push(0);
        assertThat(stack.top()).isEqualTo(0);
        assertThat(stack.min()).isEqualTo(-2);

        stack.push(-3);
        assertThat(stack.top()).isEqualTo(-3);
        assertThat(stack.min()).isEqualTo(-3);

        stack.pop();
        assertThat(stack.top()).isEqualTo(0);
        assertThat(stack.min()).isEqualTo(-2);

        stack.pop();
        assertThat(stack.top()).isEqualTo(-2);
        assertThat(stack.min()).isEqualTo(-2);
    }
}