package backtrack;

import java.util.LinkedList;

/*

0,1,00,01,11,
 */
public class BinaryCombinations {

    public void printCombinations(int n) {
        // ArrayList has better performance in general. BUT for frequent insertion/removing LinkedList is better
        LinkedList<String> combinations = new LinkedList<>();
        if (n < 1) {
        // return combinations;
            System.out.println("Not supported");
        }
        String dictionary = "01";

        //This is the base value needed to combine results in the below loop
        combinations.add("");

        // check the head. If the combination has same length as the digits we are done. example : 23 => ad DONE
        while (combinations.peek().length() != n) {
            // remove from head
            String removed = combinations.remove();
            for (char binary : dictionary.toCharArray()) {
                // add to tail
                combinations.addLast(removed + binary);
                System.out.println(removed + binary);
            }
        }
//        return combinations;
    }
}
