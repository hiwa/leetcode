package other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildHistogramTest {

    @Test
    void testIt0() {
        BuildHistogram buildHistogram = new BuildHistogram();
        assertEquals(4, buildHistogram.buildHistogram(new int[]{1, 2, 16, 17, 19, 20}, 4).size());
    }

    @Test
    void testIt() {
        BuildHistogram buildHistogram = new BuildHistogram();
        assertEquals(6, buildHistogram.buildHistogram(new int[]{1, 2, -5, 11, 15, 3, 14, 50, 1, 16, 17, 19, 20}, 6).size());
        // bar size = 10
        assertEquals(5, buildHistogram.buildHistogram(new int[]{1, 2, -5, 11, 15, 3, 14, 50, 1, 16, 17, 19, 20}, 6).get(0));
    }

    @Test
    void testIt2() {
        BuildHistogram buildHistogram = new BuildHistogram();
        assertEquals(6, buildHistogram.buildHistogram(new int[]{-2}, 6).size());
    }

    @Test
    void testIt3() {
        BuildHistogram buildHistogram = new BuildHistogram();
        assertEquals(2, buildHistogram.buildHistogram1(new int[]{1, 3, 7, 8, 12}, 2).size());
        assertEquals(6, buildHistogram.buildHistogram1(new int[]{-2, 4}, 6).size());

        assertEquals(6, buildHistogram.buildHistogram1(new int[]{1, 2, -5, 11, 15, 3, 14, 50, 1, 16, 17, 19, 20}, 6).size());
        // bar size = 10
        assertEquals(5, buildHistogram.buildHistogram1(new int[]{1, 2, -5, 11, 15, 3, 14, 50, 1, 16, 17, 19, 20}, 6).get(0));
        assertEquals(0, buildHistogram.buildHistogram1(new int[]{1}, 6).get(0));
    }

}