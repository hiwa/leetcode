package sortsearch;

/*

Brute force : O(N)

FastPow:
O(LogN), O(1)
 */
public class MyPow {

    public double myPow(double x, int n) {
        return n < 0 ? fastPow(1 / x, -1 * n) : fastPow(x, n);
    }

    private double fastPow(double x, double n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
