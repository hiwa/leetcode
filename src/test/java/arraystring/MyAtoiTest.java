package arraystring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyAtoiTest {

    @Test
    void testIt() {

        MyAtoi myAtoi = new MyAtoi();
        assertEquals(-789, myAtoi.myAtoi("   -0789"));
        assertEquals(0, myAtoi.myAtoi("ss -0789"));
        assertEquals(0, myAtoi.myAtoi("  ss -0789"));
        assertEquals(789, myAtoi.myAtoi("  +0789"));

        assertEquals(2147483646, myAtoi.myAtoi("2147483646"));
        assertEquals(Integer.MAX_VALUE, myAtoi.myAtoi("2147483647"));
        assertEquals(Integer.MAX_VALUE, myAtoi.myAtoi("2147483648"));

        assertEquals(-2147483647, myAtoi.myAtoi("-2147483647"));
        assertEquals(Integer.MIN_VALUE, myAtoi.myAtoi("-2147483648"));
        assertEquals(Integer.MIN_VALUE, myAtoi.myAtoi("-2147483649"));


        Assertions.assertEquals(123, myAtoi.myRealAtoi("  123 "));
        Assertions.assertEquals(123, myAtoi.myRealAtoi("  123 rfewf"));
        Assertions.assertEquals(1233564645, myAtoi.myRealAtoi("  1233564645"));
        Assertions.assertEquals(-1233564645, myAtoi.myRealAtoi("  -1233564645"));
        Assertions.assertEquals(+1233564645, myAtoi.myRealAtoi("  +1233564645 gegt"));
        Assertions.assertEquals(Integer.MAX_VALUE, myAtoi.myRealAtoi("  564654564654654"));
        Assertions.assertEquals(Integer.MAX_VALUE, myAtoi.myRealAtoi("21474836478"));
        Assertions.assertEquals(Integer.MAX_VALUE, myAtoi.myRealAtoi("2147483648"));
        Assertions.assertEquals(2147483646, myAtoi.myRealAtoi("2147483646"));

    }
}

