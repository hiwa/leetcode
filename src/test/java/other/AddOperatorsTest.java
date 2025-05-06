package other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddOperatorsTest {

    @Test
    void testIt() {

        AddOperators addOperators = new AddOperators();
        assertEquals(2, addOperators.addOperators("123",6).size());
        assertEquals(3, addOperators.addOperators("1012",12).size());
    }

}