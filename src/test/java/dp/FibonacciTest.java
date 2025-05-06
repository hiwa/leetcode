package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testIt() {

        Fibonacci fib = new Fibonacci();
//        assertEquals(1134903170, fib.fibClassic(45));
//
//        assertEquals(1134903170, fib.fibDP(45));

        assertEquals(
                14930352, fib.fibMath(35));
        assertEquals(14930352, fib.fibDP(35));
        assertEquals(14930352, fib.fibClassic(35));

    }
//    @Test
//    void testIt_DP() {
//
//        Fib fib = new Fib();
//        assertEquals(3, fib.fibDP(4));
//        assertEquals(21, fib.fibDP(8));
//        assertEquals(21, fib.fibDP(50));
//    }

}