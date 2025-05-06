package arraystring;

/*
https://leetcode.com/discuss/interview-question/1950476/Rotational-Cipher

Just remember how to use offsets.

T : O(N)
M : O(N) for StringBuilder which is the final result, so we might say O(1)
 */
public class RotationalCipher {

    public static final int NUMBER_OF_LETTERS = 26;
    public static final int OFFSET_A = 'A';
    public static final int OFFSET_a = 'a';

    String rotationalCipher(String input, int rotationFactor) {
        StringBuilder output = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                output.append((Character.getNumericValue(ch) + rotationFactor) % 10);
            } else if (Character.isAlphabetic(ch)) {
                // add 5 to w = 5 + w(119) = 124 Out of range of a-z :
                // (0)------a(97)-------.....--w-...-z(122)...XXX
                // So we decrease by offset of 'a' (temp = 'w'-'a' % 26 = 22 % 26 = 4. And we add again offset 'a' => result = (char) temp + offset 'a'
                if (Character.isUpperCase(ch)) {
                    int temp = (ch - OFFSET_A + rotationFactor) % NUMBER_OF_LETTERS;
                    output.append((char) (OFFSET_A + temp));
                } else {
                    int temp = (ch - OFFSET_a + rotationFactor) % NUMBER_OF_LETTERS;
                    output.append((char) (OFFSET_a + temp));
                }
            } else {
                output.append(ch);
            }
        }
        return output.toString();
    }
}

