package encryptdecrypt;

/**
 * This class implements the EncryptionDecryption interface using the Unicode algorithm.
 * The Unicode algorithm encrypts and decrypts text by shifting each character's Unicode value
 * by a given key.
 */
class UnicodeAlgo implements EncryptionDecryption {

    /**
     * Encrypts the provided plain text using the Unicode algorithm and the given key.
     *
     * @param plainText The text to be encrypted.
     * @param key       The encryption key.
     * @return The encrypted cipher text.
     */
    @Override
    public String encrypt(String plainText, int key) {
        String cipherText = "";

        for(int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            char encryptedChar = ch;
            encryptedChar += key;

            cipherText += encryptedChar;
        }
        return cipherText;
    }

    /**
     * Decrypts the provided cipher text using the Unicode algorithm and the given key.
     *
     * @param cipherText The text to be decrypted.
     * @param key        The decryption key.
     * @return The decrypted plain text.
     */
    public String decrypt(String cipherText, int key) {
        String plainText = "";

        for(int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            char decryptedChar = ch;
            decryptedChar -= key;
            plainText += decryptedChar;
        }
        return plainText;
    }
}
