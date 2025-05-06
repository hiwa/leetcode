package interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ClosetToZeroTest {

    @Test
    void test() {
        ClosetToZero closetToZero = new ClosetToZero();
        List<Integer> input = Arrays.asList(10, 5, -3, -8);

        Assertions.assertEquals(closetToZero.find(input), 1);
    }


    }
