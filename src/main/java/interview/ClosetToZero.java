package interview;

import java.util.Arrays;
import java.util.List;
//
//10,20,5,-1,-10, 3 ->-1
//
//-10,-1,3,5,10,20 ->  abs(max negative, min positive)


public class ClosetToZero {

        public int find(List<Integer> input) {
            int closet = Integer.MAX_VALUE;
            for (int i : input) {
                if (i == 0) {
                    return 0;
                } else {
                    closet = Math.abs(closet) > Math.abs(i) ? i : closet; //-10, -1,
                }
            }
            return closet;
        }

    /**
     * @return the number that is closest to zero
     */
    static int closestToZero(int[] ints) {
        Arrays.sort(ints); // sort the array in ascending order

        int closest = ints[0]; // assume the first element is the closest to zero

        for (int i = 1; i < ints.length; i++) {
            // compare the absolute value of the current element to the absolute value of the closest element
            if (Math.abs(ints[i]) < Math.abs(closest) || (Math.abs(ints[i]) == Math.abs(closest) && ints[i] > 0)) {
                closest = ints[i];
            }
        }

        return closest;
    }


}


