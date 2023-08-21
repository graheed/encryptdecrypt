package encryptdecrypt;

/**
 * This class implements the EncryptionDecryption
 * interface using the Shift algorithm.
 *
 * The Shift algorithm encrypts and decrypts text by
 * shifting each character by a given key.
 *
 * Only alphabetic characters are shifted, while
 * non-alphabetic characters are preserved.
 */
class ShiftAlgo implements EncryptionDecryption {

    /**
     * Encrypts the provided plain text
     * using the Shift algorithm and the given key.
     *
     * @param plainText The text to be encrypted.
     * @param key       The encryption key.
     * @return The encrypted cipher text.
     */
    @Override
    public String encrypt(String plainText, final int key) {
        final StringBuilder cipherText = new StringBuilder();
        final int alphabetSize = 26;

        for (int i = 0; i < plainText.length(); i++) {
            Character ch = plainText.charAt(i);
            if (ch.equals(' ')) {
                cipherText.append(" ");
                continue;
            }
            char encryptedChar = ch;
            encryptedChar += key;
            if (Character.isUpperCase(ch) && encryptedChar > 'Z' || Character.isLowerCase(ch) && encryptedChar > 'z') {
                encryptedChar -= alphabetSize;
            }
            cipherText.append(encryptedChar);
        }
        return cipherText.toString();
    }

    /**
     * Decrypts the provided cipher text using
     * the Shift algorithm and the given key.
     *
     * @param cipherText The text to be decrypted.
     * @param key        The decryption key.
     * @return The decrypted plain text.
     */
    public String decrypt(String cipherText, final int key) {
        final StringBuilder plainText = new StringBuilder();
        final int alphabetSize = 26;
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (ch == ' ') {
                plainText.append(" ");
                continue;
            }
            char decryptedChar = ch;
            decryptedChar -= key;
            if (Character.isUpperCase(ch) && decryptedChar < 'A' || Character.isLowerCase(ch) && decryptedChar < 'a') {
                decryptedChar += alphabetSize;
            }
            plainText.append(decryptedChar);
        }
        return plainText.toString();
    }
}
