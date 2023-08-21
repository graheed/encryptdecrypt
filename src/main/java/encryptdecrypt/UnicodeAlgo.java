package encryptdecrypt;

/**
 *
 * This class implements the EncryptionDecryption interface using
 * the Unicode algorithm.
 *
 * The Unicode algorithm encrypts and decrypts text by shifting each
 * character's Unicode value by a given key.
 */
class UnicodeAlgo implements EncryptionDecryption {

    /**
     * Encrypts the provided plain text using the
     * Unicode algorithm and the given key.
     *
     * @param plainText The text to be encrypted.
     * @param key       The encryption key.
     * @return The encrypted cipher text.
     */
    @Override
    public String encrypt(String plainText, int key) {
        final StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char encryptedChar = plainText.charAt(i);
            encryptedChar += key;

            cipherText.append(encryptedChar);
        }
        return cipherText.toString();
    }

    /**
     * Decrypts the provided cipher text
     * using the Unicode algorithm and the given key.
     *
     * @param cipherText The text to be decrypted.
     * @param key        The decryption key.
     * @return The decrypted plain text.
     */
    public String decrypt(String cipherText, final int key) {
        final StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char decryptedChar = cipherText.charAt(i);
            decryptedChar -= key;
            plainText.append(decryptedChar);
        }
        return plainText.toString();
    }
}
