package com.products.productsmvc.service.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements the methods for handling encryption.
 */
@Service
public class EncryptionServiceImpl implements EncryptionService{
    /**
     * Strong password encryptor.
     */
    private StrongPasswordEncryptor strongEncryptor;

    /**
     * Sets the strongEncryptor of the EncryptionService to the value of the strongEncryptor parameter.
     * @param strongEncryptor The StrongPasswordEncryptor to set.
     */
    @Autowired
    public void setStrongEncryptor(StrongPasswordEncryptor strongEncryptor) {
        this.strongEncryptor = strongEncryptor;
    }

    /**
     * {@inheritDoc}
     */
    public String encryptString(String input){
        return strongEncryptor.encryptPassword(input);
    }

    /**
     * {@inheritDoc}
     */
    public boolean checkPassword(String plainPassword, String encryptedPassword){
        return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
