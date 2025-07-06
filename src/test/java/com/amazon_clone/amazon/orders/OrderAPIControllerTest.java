package com.amazon_clone.amazon.orders;

import com.amazon_clone.amazon.orders.dto.request.OrderAddRequest;
import com.amazon_clone.amazon.orders.dto.request.OrderRequest;
import com.amazon_clone.amazon.product.ProductController;
import com.amazon_clone.amazon.product.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc(addFilters = false) // 스프링 시큐리티 필터 비활성화
@AutoConfigureRestDocs
class OrderAPIControllerTest {

    @MockitoBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("주문 생성 API 테스트")
    @Test
    void createOrder_O() throws Exception {
        // Arrange
        OrderRequest request = OrderAddRequest.builder()
                .memberFk(1L)
                .cartFk(1L)
                .build();

        // Act & Assert
        mockMvc.perform(put("/api/order/create")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andDo(document("create-order",
                        requestFields(
                                fieldWithPath("memberFk").description("회원 ID"),
                                fieldWithPath("cartFk").description("장바구니 ID")
                        )));


    }
}