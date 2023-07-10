package encryptdecrypt;

/**
 * This interface defines the contract for encryption and decryption algorithms.
 * Implementing classes must provide methods to encrypt and decrypt text using a specific algorithm.
 */
public interface EncryptionDecryption {

    /**
     * Encrypts the provided plain text using a specific algorithm and key.
     *
     * @param plainText The text to be encrypted.
     * @param key       The encryption key.
     * @return The encrypted cipher text.
     */
    String encrypt(String plainText, int key);

    /**
     * Decrypts the provided cipher text using a specific algorithm and key.
     *
     * @param cipherText The text to be decrypted.
     * @param key        The decryption key.
     * @return The decrypted plain text.
     */
    String decrypt(String cipherText, int key);
}
