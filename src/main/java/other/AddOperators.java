package other;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/expression-add-operators/solution/
Solution : https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear/239225

  "12",3
  1+2,1-2,1*2OK
  "102",3
  1+0+2 OK, 1+0-2, 1+0*2
  1-0+2, 1-0-2, 1-0*2
  1*0+2, 1*0-2, 1*0*2
  10+2, 10-2, 10*2
  1+02 X  break
  1. build all the combinations > This is what the for loop does by substring(pos, i+1), each time the number extends by one and then meet the operations
     check leading zeros. 1+02 INVALID
  2. validate where we are at the end of input:
     a  > 1+0+2 parse and check against target : Not efficient
     a' > calculate the value on fly in each step and just compare with target: OK
        calculation in case of - and + is straightforward as they have same precedence.
        But for * since it has higher precedence, we need to know what is the previous number:
         Example : To get value of 1+0*2:
          1+0 = 1 ---> 1*2 = 2 KO
          instead this is what we should do : knowing that previous number is 0 in (1+0):
              1-0+(0*2) = 1 OK (for next step previous number is 0*2 = 0)

Time complexity  :
For each round in the loop we have 1 or 3 recursion calls. In the three recursion calls we decrease the input size by one (N-1) till we reach end of input

T(N) = 3*T(N-1) + 3*T(N-2)...3*T(0)
T(N-1) =          3*T(N-2) + ... 3*T(0)
Then
T(N) = 3*T(N-1) + T(N-1) = 4*T(N-1) = O(N^4)

Space: O(N) for stack calls . We don't consider the result array as it is part of the requirements and, we cannot do better than that.
*/
public class AddOperators {

    public List<String> addOperators(String num, int target) {

        if (num == null || num.isBlank()) {
            return new ArrayList<>();
        }
        List<String> validExpressions = new ArrayList<>();

        find(num, target, validExpressions, "", 0, 0, 0);

        return validExpressions;
    }

    private void find(String num, int target, List<String> result, String expression, long expressionValue, long previousNumber,
                      int position) {

        if (position == num.length() && expressionValue == target) {
            System.out.println(expression);
            result.add(expression);
            return;
        }
        for (int i = position; i < num.length(); i++) {
            if (i > position && num.charAt(position) == '0') {
                break;
            }
            long currentNumber = Long.parseLong(num.substring(position, i + 1));

            if (position == 0) {
                find(num, target, result, expression + currentNumber, currentNumber, currentNumber, i + 1);
            } else {
                find(num, target, result, expression + "+" + currentNumber, currentNumber + expressionValue, currentNumber, i + 1);
                find(num, target, result, expression + "-" + currentNumber, expressionValue - currentNumber, -currentNumber, i + 1);
                find(num, target, result, expression + "*" + currentNumber, expressionValue - previousNumber + previousNumber * currentNumber,
                        previousNumber * currentNumber, i + 1);
            }
        }
    }
}
