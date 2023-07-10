package encryptdecrypt;

/**
 * This class implements the EncryptionDecryption interface using the Shift algorithm.
 * The Shift algorithm encrypts and decrypts text by shifting each character by a given key.
 * Only alphabetic characters are shifted, while non-alphabetic characters are preserved.
 */
class ShiftAlgo implements EncryptionDecryption {

    /**
     * Encrypts the provided plain text using the Shift algorithm and the given key.
     *
     * @param plainText The text to be encrypted.
     * @param key       The encryption key.
     * @return The encrypted cipher text.
     */
    @Override
    public String encrypt(String plainText, int key) {
        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch == ' ') {
                cipherText += " ";
                continue;
            }
            char encryptedChar = ch;
            encryptedChar += key;
            if (Character.isUpperCase(ch) && encryptedChar > 'Z' || Character.isLowerCase(ch) && encryptedChar > 'z') {
                encryptedChar -= 26;
            }
            cipherText += encryptedChar;
        }
        return cipherText;
    }

    /**
     * Decrypts the provided cipher text using the Shift algorithm and the given key.
     *
     * @param cipherText The text to be decrypted.
     * @param key        The decryption key.
     * @return The decrypted plain text.
     */
    public String decrypt(String cipherText, int key) {
        String plainText = "";

        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (ch == ' ') {
                plainText += " ";
                continue;
            }
            char decryptedChar = ch;
            decryptedChar -= key;
            if (Character.isUpperCase(ch) && decryptedChar < 'A' || Character.isLowerCase(ch) && decryptedChar < 'a') {
                decryptedChar += 26;
            }
            plainText += decryptedChar;
        }
        return plainText;
    }
}
