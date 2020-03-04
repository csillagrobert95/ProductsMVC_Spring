package com.products.productsmvc.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Common bean configuration class.
 */
@Configuration
public class CommonBeanConfig {
    /**
     * Returns the StrongPasswordEncryptor bean.
     * @return The StrongPasswordEncryptor bean.
     */
    @Bean
    public StrongPasswordEncryptor strongEncryptor(){
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        return encryptor;
    }
}
