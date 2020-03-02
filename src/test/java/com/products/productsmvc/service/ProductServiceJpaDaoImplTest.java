package com.products.productsmvc.service;

import com.products.productsmvc.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test the ProductServiceJpaDaoImpl class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("jpadao")
public class ProductServiceJpaDaoImplTest {

    /**
     * The productService.
     */
    private ProductService productService;

    /**
     * Sets the productService to the value of the productService parameter.
     * @param productService The productService to set.
     */
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Test the listAll method.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testListAll() throws Exception{
        List<Product> products = (List<Product>)productService.listAll();

        assertEquals(5, products.size());
    }

    /**
     * Test the getById method.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testGetById() throws Exception{
        int id = 1;
        Product product = productService.getById(id);
        assertNotNull(product);
        assertEquals(id, product.getId().intValue());
    }

    /**
     * Test the saveOrUpdate method.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testSaveOrUpdate() throws Exception{
        Product product = new Product();
        product.setDescription("Product to save");
        product.setImageUrl("http://imageurl.com");
        product.setPrice(new BigDecimal(67));

        Product savedProduct = productService.saveOrUpdate(product);
        assertNotNull(savedProduct);
        assertEquals(product.getDescription(), savedProduct.getDescription());
        assertEquals(product.getImageUrl(), savedProduct.getImageUrl());
        assertEquals(product.getPrice(), savedProduct.getPrice());
    }

    /**
     * Test the delete method.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testDelete() throws Exception{
        List<Product> products = (List<Product>)productService.listAll();

        productService.delete(products.get(0).getId());

        List<Product> productsAfterDel = (List<Product>)productService.listAll();

        assertEquals(products.size() - 1, productsAfterDel.size());
    }
}
