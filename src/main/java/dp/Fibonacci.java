package dp;

/*
https://leetcode.com/problems/climbing-stairs/solution/
 */
public class Fibonacci {
    // T : O(LogN) as pow takes log n
    // M : O(1) constant space
    public int fibMath(int n) {
        long startTime = System.currentTimeMillis();

        double sqrt5 = Math.sqrt(5);
        double result = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);

        result = result / sqrt5;

        long endTime = System.currentTimeMillis();
        System.out.println("result for " + n + " = " + (int) result);
        System.out.println("DP Math: " + (endTime - startTime));

        return (int) result;
    }

    public long fibClassic(int n) {
        long startTime = System.currentTimeMillis();
        long result = fibRecursion(n);

        long endTime = System.currentTimeMillis();
        System.out.println("result for " + n + " = " + result);
        System.out.println("time: " + (endTime - startTime));
        return result;
    }

    public int fibDP(int n) {
        int[] results = new int[n + 1];
        long startTime = System.currentTimeMillis();
        int result = fibDPRecursion(n, results);

        long endTime = System.currentTimeMillis();
        System.out.println("result for " + n + " = " + result);
        System.out.println("DP time: " + (endTime - startTime));
        return result;
    }

    private int fibDPRecursion(int n, int[] results) {
        if (results[n] > 0) {
            return results[n];
        }

        if (n == 1 || n == 0) {
            results[n] = 1;
            return results[n];
        }

        results[n] = fibDPRecursion(n - 1, results) + fibDPRecursion(n - 2, results);
        return results[n];
    }

    private int fibRecursion(int n) {
        int result;
        if (n == 1 || n == 0) {
            return 1;
        }
        result = fibRecursion(n - 1) + fibRecursion(n - 2);
        return result;
    }

}
