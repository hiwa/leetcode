package dp;

/*
    Given 3 numbers like {1, 3, 5}, return total number of ways we can form a number 'N' like (7)
    using the sum of the given three numbers.


    1---3  => 5

    f(1) : number of ways involving 1,3 to form 1 => 1 => 1
    f(2) : number of ways involving 1,3 to form 2 => 1+1 => 1
    f(3) : number of ways involving 1,3 to form 3 =>1+1+1 , 3 => 2
    f(4) : number of ways involving 1,3 to form 4 => 1+1+1+1, 1+3, 3+1 => 3
    f(5) : number of ways involving 1,3 to form 5 =>
    1+1+1+1+1 which is (1+1+1+1)+1 : f(4)+1
    1+1+3     which is (1+1)+3     : f(2)+3
    1+3+1     which is (1+3)+1     : f(4)+1
    3+1+1     which is (3+1)+1     : f(4)+1
    Thus:
    f(5) = f(4) + f(2) OR
    f(n) = f(n-1) + f(n-3) which means  to form state 5, we just need to form 4 and add "1" [ f(4)+1 ]OR form 2 and add "3" [ f(2) + 3]

    Time complexity : should be O(N) since we meet each n once.
    Space complexity : O(N) for the memo.

 */
public class NumberOfArrangements {

    public int solveWithArray(int number) {
        int[] memo = new int[number + 1];
        return solveWithArray(number, memo);
    }

    /**
     * @param number is the parameter used to define states to solve  sub-problems.
     *               state = f(n) for this problem defined as; all the ways to form n, from 1,3,5. As explained above f(2) = 1 since there is just
     *               one way to build 2 from 1,3,5 which is 1+1.
     * @param numberOfArrangements   is used for memoization
     * @return all the ways to form n, from 1,3,5
     */
    private int solveWithArray(int number, int[] numberOfArrangements) {
        // base case; for numbers less than 0, obviously there is no way to form, from positive numbers.
        if (number < 0) {
            return 0;
        }
        // f(0) is 1 this is a generic rule in DP. Similar to Fibonacci(0)=1
        if (number == 0) {
            return 1;
        }
        if (numberOfArrangements[number] > 0) {
            return numberOfArrangements[number];
        }

        numberOfArrangements[number] = solveWithArray(number - 1, numberOfArrangements) + solveWithArray(number - 3, numberOfArrangements)
                + solveWithArray(number - 5, numberOfArrangements);

        return numberOfArrangements[number];
    }

}
