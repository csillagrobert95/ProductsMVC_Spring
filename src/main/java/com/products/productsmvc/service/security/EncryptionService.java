package com.products.productsmvc.service.security;

/**
 * This interface defines the methods for handling encryption.
 */
public interface EncryptionService {
    /**
     * Encrypts the input String.
     * @param input The String to encrypt.
     * @return The encrypted String.
     */
    String encryptString(String input);

    /**
     * Checks a plain password against an encrypted password.
     * @param plainPassword The plain password.
     * @param encryptedPassword The encrypted password.
     * @return True if the passwords match, false otherwise.
     */
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
