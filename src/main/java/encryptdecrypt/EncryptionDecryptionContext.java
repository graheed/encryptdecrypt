package encryptdecrypt;

/**
 * This class represents the context for encryption and decryption operations.
 * It provides a way to set the encryption/decryption algorithm and process input text based on the selected mode.
 */
public class EncryptionDecryptionContext {
    private EncryptionDecryption algo;

    /**
     * Sets the encryption/decryption algorithm to be used.
     *
     * @param algo The algorithm implementation.
     */
    public void setAlgo(EncryptionDecryption algo) {
        this.algo = algo;
    }

    /**
     * Processes the input text based on the selected mode (encryption or decryption) using the set algorithm.
     *
     * @param inputText The text to be processed.
     * @param key       The encryption/decryption key.
     * @param mode      The mode of operation ("enc" for encryption, "dec" for decryption).
     * @return The processed text (encrypted or decrypted) based on the selected mode.
     */
    public String process(String inputText, int key, String mode) {
        if ("enc".equals(mode)) {
            return this.algo.encrypt(inputText, key);
        } else if ("dec".equals(mode)) {
            return this.algo.decrypt(inputText, key);
        }
        return null;
    }
}
