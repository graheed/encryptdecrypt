package encryptdecrypt;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Disabled
public class MainTest {

    //@DisplayName("Shift Encryption Test - Input - CommandLine")
    @Test
    public void testEncryptionWithShiftAlgorithmCL() {
        //given
        String[] args = {"-mode", "enc", "-key", "3", "-data", "Hello, Universe!", "-alg", "shift", "-out", "output.txt"};
        String outputFilePath = "output.txt";
        String expectedOutput = "Khoor/ Xqlyhuvh$";

        //when
        Main.main(args);

        //then
        try {
            String actualOutput = Files.readString(Path.of(outputFilePath));
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException ignored) {

        }
    }

    @Test
    public void testEncryptionWithShiftAlgorithmFile() {
        //given
        String[] args = {"-mode", "enc", "-key", "3", "-in", "inputTextEncrypt.txt", "-alg", "shift", "-out", "output.txt"};
        String outputFilePath = "output.txt";
        String expectedOutput = "Khoor/ Xqlyhuvh$";

        //when
        Main.main(args);

        //then
        try {
            String actualOutput = Files.readString(Path.of(outputFilePath));
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException ignored) {

        }
    }

    @Test
    public void testEncryptionWithUnicodeAlgorithmCL() {
        //given
        String[] args = {"-mode", "enc", "-key", "10", "-data", "Hello, Universe!", "-alg", "unicode", "-out", "output.txt"};
        String outputFilePath = "output.txt";
        String expectedOutput = "Rovvy6*_xs\u0080o|}o+";

        //when
        Main.main(args);

        //then
        try {
            String actualOutput = Files.readString(Path.of(outputFilePath));
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException ignored) {

        }
    }

    @Test
    public void testEncryptionWithUnicodeAlgorithmFile() {
        //given
        String[] args = {"-mode", "enc", "-key", "10", "-in", "inputTextEncrypt.txt", "-alg", "unicode", "-out", "output.txt"};
        String outputFilePath = "output.txt";
        String expectedOutput = "Rovvy6*_xs\u0080o|}o+";

        //when
        Main.main(args);

        //then
        try {
            String actualOutput = Files.readString(Path.of(outputFilePath));
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException ignored) {

        }
    }

    @Test
    public void testDecryptionWithShiftAlgorithmCL() {
        //given
        String[] args = {"-mode", "dec", "-key", "2", "-data", "Vjg ecrkvcn jcu dggp vcmgp#", "-alg", "shift", "-out", "output.txt"};
        String outputFilePath = "output.txt";
        String expectedOutput = "The capital has been taken!";

        //when
        Main.main(args);

        //then
        try {
            String actualOutput = Files.readString(Path.of(outputFilePath));
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException ignored) {

        }
    }

    @Test
    public void testDecryptionWithShiftAlgorithmFile() {
        //given
        String[] args = {"-mode", "dec", "-key", "2", "-in", "inputTextDecryptShift.txt", "-alg", "shift", "-out", "output.txt"};
        String outputFilePath = "output.txt";
        String expectedOutput = "The capital has been taken!";

        //when
        Main.main(args);

        //then
        try {
            String actualOutput = Files.readString(Path.of(outputFilePath));
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException ignored) {

        }
    }

    @Test
    public void testDecryptionWithUnicodeAlgorithmCL() {
        //given
        String[] args = {"-mode", "dec", "-key", "2", "-data", "Vjg\"ecrkvcn\"jcu\"dggp\"vcmgp#", "-alg", "unicode", "-out", "output.txt"};
        String outputFilePath = "output.txt";
        String expectedOutput = "The capital has been taken!";

        //when
        Main.main(args);

        //then
        try {
            String actualOutput = Files.readString(Path.of(outputFilePath));
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException ignored) {

        }
    }

    @Test
    public void testDecryptionWithUnicodeAlgorithmFile() {
        //given
        String[] args = {"-mode", "dec", "-key", "2", "-in", "inputTextDecryptUnicode.txt", "-alg", "unicode", "-out", "output.txt"};
        String outputFilePath = "output.txt";
        String expectedOutput = "The capital has been taken!";

        //when
        Main.main(args);

        //then
        try {
            String actualOutput = Files.readString(Path.of(outputFilePath));
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException ignored) {

        }
    }






}
