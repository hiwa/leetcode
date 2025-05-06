package backtrack.parentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinRemoveToMakeAllValidResultsTest {

    @Test
    void testIt_1() {

        System.out.println("Input : (ab))c)(");
        MinRemoveToMakeAllValidResults minRemoveToMakeAllValidResults = new MinRemoveToMakeAllValidResults();

        assertEquals(2, minRemoveToMakeAllValidResults.removeInvalidParentheses("(ab))c)(").size());
    }

    @Test
    void testIt_2() {

        System.out.println(" Input : )())(()");
        MinRemoveToMakeAllValidResults minRemoveToMakeAllValidResults = new MinRemoveToMakeAllValidResults();

        assertEquals(1, minRemoveToMakeAllValidResults.removeInvalidParentheses(")())(()").size());
    }

    @Test
    void testIt_3() {

        System.out.println(" Input : 123");
        MinRemoveToMakeAllValidResults minRemoveToMakeAllValidResults = new MinRemoveToMakeAllValidResults();

        assertEquals(1, minRemoveToMakeAllValidResults.removeInvalidParentheses("123").size());
    }

}