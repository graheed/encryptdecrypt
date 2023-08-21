package encryptdecrypt;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnicodeAlgoTest {

    private static UnicodeAlgo unicodeAlgo;
    @BeforeAll
    static void setUpBeforeAll() {
        unicodeAlgo = new UnicodeAlgo();
    }

    @DisplayName("Encrypt Method Test of Unicode Algo")
    @Test
    void testEncrypt() {
        //given
        String plainText = "How can a clam cram in a clean cream can?";
        int key = 10;
        String cypherAnswer = "Ry\u0081*mkx*k*mvkw*m|kw*sx*k*mvokx*m|okw*mkxI";

        //when
        String cypherText = unicodeAlgo.encrypt(plainText, key);

        //then
        assertEquals(cypherAnswer, cypherText);
    }

    @DisplayName("Decrypt Method Test of Unicode Algo")
    @Test
    void testDecrypt() {
        //given
        String cypherText = "Ry\u0081*mkx*k*mvkw*m|kw*sx*k*mvokx*m|okw*mkxI";
        int key = 10;

        String plainAnswer = "How can a clam cram in a clean cream can?";


        //when
        String plainText = unicodeAlgo.decrypt(cypherText, key);

        //then
        assertEquals(plainAnswer, plainText);
    }
}