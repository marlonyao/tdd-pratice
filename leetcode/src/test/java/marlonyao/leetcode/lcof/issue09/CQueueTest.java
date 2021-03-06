package marlonyao.leetcode.lcof.issue09;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CQueueTest {
    @Test
    public void test() {
        CQueue queue = new CQueue();
        assertThat(queue.deleteHead()).isEqualTo(-1);

        queue.appendTail(1);
        assertThat(queue.deleteHead()).isEqualTo(1);
        assertThat(queue.deleteHead()).isEqualTo(-1);

        queue.appendTail(1);
        queue.appendTail(2);
        assertThat(queue.deleteHead()).isEqualTo(1);
        assertThat(queue.deleteHead()).isEqualTo(2);
    }
}