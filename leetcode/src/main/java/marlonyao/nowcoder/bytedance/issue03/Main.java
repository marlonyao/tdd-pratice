package marlonyao.nowcoder.bytedance.issue03;

import java.util.Scanner;

public class Main {
    static int maxSize(char[] str, int m) {
        // left, right；
        // 维持区间[left, right]内的'a'的数量 an，'b'的数量 bn。
        // - 当 an 或 bn 数量都大于m时，最大连续串长度为 right-left，更新max。
        // - 当 an 或 bn <= m 时，right++，否则 left++，right++（注意调整 an, bn）。
        int left = 0, right = 0;
        int an = 0, bn = 0;
        int max = 0;
        while (right < str.length) {
            if (str[right] == 'a') {
                an++;
            } else {
                bn++;
            }
            // invariant
            if (an <= m || bn <= m) {
                right++;
                continue;
            }
            if ((right - left) > max) {
                max = right - left;
            }
            if (str[left++] == 'a') {
                an--;
            } else {
                bn--;
            }
            right++;
        }
        if ((right - left) > max) {
            max = right - left;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String str = scanner.next();
        System.out.println(maxSize(str.toCharArray(), m));
    }
}
