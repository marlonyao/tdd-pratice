package marlonyao.nowcoder.bytedance.issue02;

import java.util.Scanner;

public class Main {
    static boolean possibleFair(long n, long k, long d1, long d2) {
        if (n % 3 != 0) {
            return false;
        }
        return doPossibleFair(n, k, d1, d2)
                || doPossibleFair(n, k, d1, -d2)
                || doPossibleFair(n, k, -d1, d2)
                || doPossibleFair(n, k, -d1, -d2);
    }

    private static boolean doPossibleFair(long n, long k, long d1, long d2) {
        if ((k - 2 * d1 - d2) % 3 != 0) {
            return false;
        }
        long first = (k - 2 * d1 - d2) / 3;
        long second = first + d1;
        long third = second + d2;
        if (first < 0 || second < 0 || third < 0) {
            return false;
        }
        return first <= n / 3 && second <= n / 3 && third <= n / 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            boolean possibleFair = possibleFair(scanner.nextLong(), scanner.nextLong(), scanner.nextLong(), scanner.nextLong());
            System.out.println(possibleFair ? "yes" : "no");
        }
    }
}