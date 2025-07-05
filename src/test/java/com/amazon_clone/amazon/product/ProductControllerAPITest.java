package com.amazon_clone.amazon.product;

import com.amazon_clone.amazon.product.domain.Product;
import com.amazon_clone.amazon.product.request.ProductAddRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc(addFilters = false) // 스프링 시큐리티 필터 비활성화
@AutoConfigureRestDocs
class ProductControllerAPITest {

    @MockitoBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("상품 등록 API 테스트")
    void addProduct_O() throws Exception {
        // Arrange
        ProductAddRequest request = new ProductAddRequest("Test Product", 10, "image.jpg", 100, "Description of test product");
        Product product = Product.builder()
                .name("Test Product")
                .build();

        Mockito.when(productService.add(Mockito.any(ProductAddRequest.class))).thenReturn(product);

        // Act & Assert
        mockMvc.perform(put("/api/product/add")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andDo(MockMvcRestDocumentation.document("add-product",
                        requestFields(
                                fieldWithPath("name").description("Product name"),
                                fieldWithPath("cnt").description("Product cnt"),
                                fieldWithPath("mainImage").description("Product mainImage URL"),
                                fieldWithPath("price").description("Product price"),
                                fieldWithPath("description").description("Product description")
                        ),
                        responseFields(
                                fieldWithPath("response.id").description("Product ID"),
                                fieldWithPath("response.name").description("Product name"),
                                fieldWithPath("response.cnt").description("Product cnt"),
                                fieldWithPath("response.mainImage").description("Product mainImage URL"),
                                fieldWithPath("response.price").description("Product price"),
                                fieldWithPath("response.description").description("Product description"),
                                fieldWithPath("response.categoryFk").description("Product category ID"),
                                fieldWithPath("status").description("Response status")
                        )
                ));
    }
}