package arraystring;

/*
https://leetcode.com/problems/add-binary/solution/

T: O(max(N,M)
M: O(max(N,M)
 */
public class AddBinary {
    //https://leetcode.com/problems/add-binary/discuss/24488/Short-AC-solution-in-Java-with-explanation/246072
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(); //Google immutability or string vs stringbuilder if you don't know why we use this instead of regular string
        int i = a.length() - 1, j = b.length() -1, carry = 0; //two pointers starting from the back, just think of adding two regular ints from you add from back
        while (i >= 0 || j >= 0) {
            int sum = carry; //if there is a carry from the last addition, add it to carry
            if (j >= 0) sum += b.charAt(j--) - '0'; //we subtract '0' to get the int value of the char from the ascii
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2); //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2; //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }

    public String addBinary1(String a, String b) {

        int lengthA = a.length();
        int lengthB = b.length();
        if (lengthB > lengthA) {
            return addBinary1(b, a);
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int indexB = lengthB - 1;
        for (int i = lengthA - 1; i > -1 ; --i) {
            if (a.charAt(i) == '1') {
                carry++;
            }
            if (indexB > -1) {
                if (b.charAt(indexB) == '1') {
                    carry++;

                }
                indexB--;
            }

            if (carry % 2 == 0) {
                result.append("0");

            }
            else {
                result.append("1");
            }
            carry = carry / 2;
        }

        if (carry == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }
}
