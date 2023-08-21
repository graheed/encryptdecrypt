package encryptdecrypt;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

class ShiftAlgoTest {

    private static ShiftAlgo shiftAlgo;

    @BeforeAll
    static void setUpBeforeAll() {
        shiftAlgo = new ShiftAlgo();
    }

    @DisplayName("Encrypt Method Test of Shift Algo")
    @Test
    void testEncrypt() {
        //given
        String plainText = "Let's get started then, shall we?";
        int key = 7;
        String cypherAnswer = "Sla.z nla zahyalk aolu3 zohss dlF";

        //when
        String cypherText = shiftAlgo.encrypt(plainText, key);

        //then
        assertEquals(cypherAnswer, cypherText);
    }

    @DisplayName("Decrypt Method Test of Shift Algo")
    @Test
    void testDecrypt() {
        //given
        String cypherText = "Ohw'v jhw vwduwhg wkhq, vkdoo zh?";
        int key = 3;
        String plainAnswer = "Let$s get started then) shall we<";

        //when
        String plainText = shiftAlgo.decrypt(cypherText, key);

        //then
        assertEquals(plainAnswer, plainText);

    }
}