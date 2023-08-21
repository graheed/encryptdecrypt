package encryptdecrypt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionDecryptionContextTest {
    private EncryptionDecryptionContext context;
    @BeforeEach
    void setUp() {
        context = new EncryptionDecryptionContext();
    }
    @DisplayName("Unicode Context Test")
    @Test
    void contextTestUnicode() {
        //given
        UnicodeAlgo unicode = new UnicodeAlgo();
        context.setAlgo(unicode);

        String plainText = "How can a clam cram in a clean cream can?";
        String cypherText = "Ry\u0081*mkx*k*mvkw*m|kw*sx*k*mvokx*m|okw*mkxI";
        String modeEnc = "enc";
        String modeDec = "dec";
        int key = 10;

        //when
        String cypherTextResult = context.process(plainText, key, modeEnc);
        String plainTextResult = context.process(cypherText, key, modeDec);

        //then
        assertEquals(plainText, plainTextResult);
        assertEquals(cypherText, cypherTextResult);


    }

    @DisplayName("Shift Context Test")
    @Test
    void contextTestShift() {
        //given
        ShiftAlgo shift = new ShiftAlgo();
        context.setAlgo(shift);

        String plainText = "Let's get started then";
        String cypherText = "Sla.z nla zahyalk aolu";
        String modeEnc = "enc";
        String modeDec = "dec";
        int key = 7;

        //when
        String cypherTextResult = context.process(plainText, key, modeEnc);
        String plainTextResult = context.process(cypherText, key, modeDec);

        //then
        assertEquals(plainText, plainTextResult);
        assertEquals(cypherText, cypherTextResult);
    }

    @DisplayName("Unsupported Mode Context Test")
    @Test
    void modeUnsupported() {
        //given
        ShiftAlgo shift = new ShiftAlgo();
        context.setAlgo(shift);

        String plainText = "Let's get started then";
        String modeEnc = "whutwhut?";

        int key = 7;

        //when
        String cypherTextResult = context.process(plainText, key, modeEnc);

        //then

        assertEquals("Mode not supported.", cypherTextResult);
    }
}