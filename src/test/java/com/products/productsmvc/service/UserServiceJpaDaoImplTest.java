package com.products.productsmvc.service;

import com.products.productsmvc.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
     * The productService.
     */
    private ProductService productService;

    /**
     * Sets the userService to the value of the userService parameter.
     * @param userService The userService to set.
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /**
     * Sets the productService to the value of the productService parameter.
     * @param productService The productService to set.
     */
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
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

    /**
     * Test the adding cart to user.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testAddCartToUser() throws Exception {
        User user = new User();

        user.setUsername("someusername");
        user.setPassword("myPassword");

        user.setCart(new Cart());

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
    }

    /**
     * Test the adding cart to user with cart details.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testAddCartToUserWithCartDetails() throws Exception {
        User user = new User();

        user.setUsername("someusername");
        user.setPassword("myPassword");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
        assert savedUser.getCart().getCartDetails().size() == 2;
    }

    /**
     * Test the adding and removing cart to user with cart details.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testAddAndRemoveCartToUserWithCartDetails() throws Exception {
        User user = new User();

        user.setUsername("someusername");
        user.setPassword("myPassword");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getCart().getCartDetails().size() == 2;

        savedUser.getCart().removeCartDetail(savedUser.getCart().getCartDetails().get(0));

        userService.saveOrUpdate(savedUser);

        assert savedUser.getCart().getCartDetails().size() == 1;
    }
}
