package backtrack.parentheses;

/*
Problem : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/solution/
Solution :
https://www.youtube.com/watch?v=thL70BR3yMA&ab_channel=NickWhite

T & M : O(N)
In first loop we remove the invalid ')' knowing that for each closing parentheses there should be an opening parentheses.
{@balanceCounter} increments and decrements relatively when we see '(' and ')'.

In the second loop we check the result of the first loop backward. this is to find invalid '('. Example if we have (X)(; balanceCounter = 2 then the
invalid '(' is the last one.
This is like human life. death[)] cannot come before birth[(] and birth[(] cannot come after death[)]
 */
public class MinRemoveToReturnValid {

    public String minRemoveToMakeValid(String s) {

        StringBuilder builder = new StringBuilder();
        int balanceCounter = 0;

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                balanceCounter++;
            }
            if (s.charAt(i) == ')') {
                if (balanceCounter == 0) {
                    continue;
                }
                balanceCounter--;
            }
            builder.append(currentChar);
        }

        StringBuilder reversedResult = new StringBuilder();

        for (int i = builder.length() - 1; i > -1; i--) {
            char currentChar = builder.charAt(i);
            if (currentChar == '(' && balanceCounter > 0) {
                balanceCounter--;
                continue;
            }
            reversedResult.append(currentChar);
        }
        return reversedResult.reverse().toString();
    }
}
