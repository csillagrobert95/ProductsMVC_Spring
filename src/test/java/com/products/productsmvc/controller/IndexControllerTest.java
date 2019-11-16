package com.products.productsmvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Test the IndexController class.
 */
public class IndexControllerTest {
    /** The MockMvc instance. */
    private MockMvc mockMvc;

    /** The IndexController instance. */
    private IndexController indexController;

    /**
     * Sets up the required instances for testing.
     */
    @Before
    public void setup() {
        indexController = new IndexController();
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    /**
     * Test the index method. Check if status is OK and check the view name.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }
}
