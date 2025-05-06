package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*


 */
public class BuildHistogram {

    /*
     T: O(N) for while loop + O(N) for find max/min in array
     Space: O(1) for constant and O(N) for the result
     */
    public List<Integer> buildHistogram1(int[] array, int interval) {

        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        // Fill result with zero, this is to avoid control of IndexOutOfBoundsException
        // Simply we set them all to 0 and update later when needed.

        //List<Integer> list = new ArrayList<Integer>(Collections.nCopies(interval, 0)); //initiate list with interval size filled by 0.
        for (int i = 0; i < interval; i++) {
            result.add(0);
        }

        // We don't need to sort, just get max and min of input to find range of input
        int maxValue = Arrays.stream(array).max().getAsInt();
        int minValue = Arrays.stream(array).min().getAsInt();

        int inputRange = maxValue - minValue;
        int barSize = inputRange % interval == 0 ? inputRange / interval : (inputRange / interval) + 1;

        // When maxValue==minValue, which means we only have identical values in the input.
        // Based on requirement we can return the initial list or fill it by count of identical items for first bar.
        // We should take care of barSize == 0, otherwise in line 47 we face division by zero.
        if (barSize == 0) {
            return result;
        }

        int i = 0;
        while (i < array.length) {
            int barIndex = (array[i] - minValue) / barSize;

            /*
             It might happen that barIndex is bigger than result index, which is also possible in histogram.
             Example : [1,4], interval 3
             barSize = (4-1)/3=1 :
                index 0: 1<=x<2
                index 1: 2<=x<3
                index 2: 3<=x<4
                -----------------
                barIndex = (4-1)/1=3
                We should add 4 in index 2, NOT 3 as its not a valid index.
            */
            if (barIndex > result.size() - 1) {
                result.set(result.size() - 1, result.get(result.size() - 1) == null ? 1 : result.get(result.size() - 1) + 1);
            } else {
                result.set(barIndex, result.get(barIndex) == null ? 1 : result.get(barIndex) + 1);
            }
            i++;
        }
        return result;
    }

    /*
     T : O(N) for the loop and O(NLogN) for sorting > O(NlongN)
    Space : (1), except for input and output, only constant vars used.
     */
    public List<Integer> buildHistogram(int[] array, int interval) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Arrays.sort(array);

        int inputRange = (array[array.length - 1] - array[0]);

        // Round up for histogram. It means 19/4=>5 (5,10,15,20) otherwise we lose one interval if we round down to 4 (4,8,12,16)
        int barSize = inputRange % interval == 0 ? inputRange / interval : inputRange / interval + 1;

        int barHeight = 0;
        int bar = barSize;

        int i = 0;
        while (result.size() < interval) {
            if (i < array.length && array[i] <= bar) {
                barHeight++;
                i++;
            } else {
                result.add(barHeight);
                barHeight = 0;
                bar += barSize;
            }
        }
        return result;
    }
}

