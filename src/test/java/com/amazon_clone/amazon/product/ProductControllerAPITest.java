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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
    @DisplayName("상품 조회 API 테스트")
    void getProducts_O() throws Exception {
        // Arrange
        Product product = Product.builder()
                .name("Test Product")
                .cnt(10)
                .mainImage("image.jpg")
                .price(100)
                .description("Description of test product")
                .build();

        Mockito.when(productService.productPages(Mockito.any()))
                .thenReturn(new PageImpl<>(List.of(product)));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/product"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response.content[0].name").value("Test Product"))
                .andDo(MockMvcRestDocumentation.document("get-products",
                        responseFields(
                                fieldWithPath("response.content[0].id").description("Product ID"),
                                fieldWithPath("response.content[0].name").description("Product name"),
                                fieldWithPath("response.content[0].cnt").description("Product cnt"),
                                fieldWithPath("response.content[0].mainImage").description("Product mainImage URL"),
                                fieldWithPath("response.content[0].price").description("Product price"),
                                fieldWithPath("response.content[0].description").description("Product description"),
                                fieldWithPath("response.content[0].categoryFk").description("Product category ID"),
                                fieldWithPath("response.pageable").description("Pagination information"),
                                fieldWithPath("response.last").description("last"),
                                fieldWithPath("response.totalPages").description("Total number of pages"),
                                fieldWithPath("response.first").description("Is first page"),
                                fieldWithPath("response.totalElements").description("Total number of elements"),
                                fieldWithPath("response.size").description("Size of each page"),
                                fieldWithPath("response.number").description("Current page number"),
                                fieldWithPath("response.sort.sorted").description("Is sorted"),
                                fieldWithPath("response.sort.unsorted").description("Is unsorted"),
                                fieldWithPath("response.sort.empty").description("Is empty"),
                                fieldWithPath("response.numberOfElements").description("Number of elements in the current page"),
                                fieldWithPath("response.empty").description("Is empty page"),
                                fieldWithPath("status").description("Response status")
                        )
                ));
    }


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

    @Test
    @DisplayName("상품 삭제 API 테스트")
    void deleteProduct_O() throws Exception {
        // Arrange
        Long productId = 1L;
        Mockito.doNothing().when(productService).delete(productId);

        // Act & Assert
        mockMvc.perform(delete("/api/product/delete/{id}", productId))
                .andExpect(status().isOk())
                .andDo(MockMvcRestDocumentation.document("delete-product",
                        pathParameters(
                                parameterWithName("id").description("Product ID to delete")
                        ),
                        responseFields(
                                fieldWithPath("response").description("Response object, null if successful"),
                                fieldWithPath("status").description("Response status")
                        )
                ));
    }
}