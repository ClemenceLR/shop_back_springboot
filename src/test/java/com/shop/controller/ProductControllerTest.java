package com.shop.controller;

import com.shop.dao.Product;
import com.shop.manager.ProductManager;
import com.shop.utils.TestConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    private final String PRODUCT_BASE_PATH = "/products";
    private final String API_WITH_ID = PRODUCT_BASE_PATH +  "/{id}";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductManager productManager;

    @Test
    void getAllProducts() throws Exception {
        //GIVEN
        List<Product> productList = TestConstants.getAllProducts();
        doReturn(productList).when(productManager).retrieveAllProducts();

        //WHEN
        MvcResult result = mockMvc.perform(
                get(PRODUCT_BASE_PATH)
        ).andExpect(status().is2xxSuccessful())
                .andReturn();

        //THEN
        List<Product> actualResultProductList = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        assertThat(actualResultProductList).containsExactlyInAnyOrderElementsOf(productList);
    }

    @Test
    void getProductById() throws Exception {
        //GIVEN
        Long id = 1L;
        Product product = TestConstants.getProduct();
        doReturn(product).when(productManager).retrieveProductById(id);

        //WHEN
        MvcResult result = mockMvc.perform(
                        get(API_WITH_ID, id)
                ).andExpect(status().is2xxSuccessful())
                .andReturn();

        //THEN
        Product actualResultProduct = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        assertThat(actualResultProduct).isEqualTo(product);
    }

    @Test
    void patchProductById() throws Exception {
        //GIVEN
        Long id = 1L;
        Product product = TestConstants.getProduct();
        doReturn(product).when(productManager).updateProduct(id, product);

        //WHEN
        MvcResult result = mockMvc.perform(
                        patch(API_WITH_ID, id)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(product))
                )
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        //THEN
        Product actualResultProduct = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        assertThat(actualResultProduct).isEqualTo(product);
    }

    @Test
    void deleteProductById() throws Exception {
        //GIVEN
        Long id = 1L;

        //WHEN
        mockMvc.perform(
                        delete(API_WITH_ID, id)
                )
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    void createProductById() throws Exception {
        //GIVEN
        Product newProduct = TestConstants.getProduct();

        //WHEN
       mockMvc.perform(
                        post(PRODUCT_BASE_PATH)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(productManager)

                                )
                )
                .andExpect(status().is2xxSuccessful())
                .andReturn();

    }



}
