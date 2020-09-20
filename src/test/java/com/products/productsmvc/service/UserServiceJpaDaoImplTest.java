package com.products.productsmvc.service;

import com.products.productsmvc.domain.Customer;
import com.products.productsmvc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Test the UserServiceJpaDaoImpl class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("jpadao")
public class UserServiceJpaDaoImplTest {
    /**
     * The userService.
     */
    private UserService userService;

    /**
     * Sets the userService to the value of the userService parameter.
     * @param userService The userService to set.
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Test the saveOrUpdate method and the password encryption.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testSaveOrUpdateUserWithPasswordEncryption() throws Exception {
        User user = new User();

        user.setUsername("SomeUsername");
        user.setPassword("MyPassword");

        User savedUser = userService.saveOrUpdate(user);

        assertNotNull(savedUser.getId());
        assertNotNull(savedUser.getEncryptedPassword());

        System.out.println("Encrypted Password");
        System.out.println(savedUser.getEncryptedPassword());

    }

    /**
     * Test the saveOrUpdate method and the password encryption.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testSaveOfUserWithCustomer() throws Exception {

        User user = new User();

        user.setUsername("someusername");
        user.setPassword("myPassword");

        Customer customer = new Customer();
        customer.setFirstName("Chevy");
        customer.setLastName("Chase");

        user.setCustomer(customer);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCustomer() != null;
        assert savedUser.getCustomer().getId() != null;
    }
}
