package arraystring;

/*
https://leetcode.com/problems/string-to-integer-atoi/

O(N), (1)

 */
public class MyAtoi {

    // My solution (easier)
    public int myRealAtoi(String s) {

        int result = 0;
        int sign = 1;
        s = s.trim();
        if (s.isEmpty()) return 0;
        char signChar = s.charAt(0);
        if (signChar == '-' || signChar == '+') {
            if (signChar == '-') sign = -1;
            s = s.substring(1);
        }
        for (Character current : s.toCharArray()) {
            if (Character.isDigit(current)) {
                if (result < Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Character.getNumericValue(current) <= Integer.MAX_VALUE % 10)) {
                    result = result * 10 + Character.getNumericValue(current);
                } else {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return sign * result;
    }

    public int myAtoi(String s) {

        if (s == null || s.isBlank()) {
            return 0;
        }
        int sign = 1;
        int length = s.length();
        int index = 0;
        int result = 0;

        //Skip spaces
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }

        if (s.charAt(index) == '-') {
            index++;
            sign = -1;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        while (index < length && Character.isDigit(s.charAt(index))) {

            // to get rid of ascii offset ('0' -> 48, '1' -> 49, etc)
            int currentDigit = s.charAt(index) - '0';

            // control out of range
            /*
             imagine MAX_VALUE = 118
             input = 111 > result = 109
             11 !< 11 but 118 mod 10 = 8 so if input char is <= 8 OK
             */
            if (result < Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && currentDigit <= Integer.MAX_VALUE % 10)) {
                result = result * 10 + (currentDigit);
                index++;

            } else {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return result * sign;
    }

}
