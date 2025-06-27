package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.config.TestSecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@AutoConfigureMockMvc(addFilters = false) // 스프링 시큐리티 필터 비활성화
@AutoConfigureRestDocs
public class JUnit5ExampleTests {
    @RegisterExtension
    final RestDocumentationExtension restDocumentation = new RestDocumentationExtension("custom");

    @MockitoBean
    private MemberService memberService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("JUnit 5 Example Test")
    @Test
    void exampleTest() throws Exception {
        // Example test logic goes here
        // Use mockMvc to perform requests and verify responses
        Map<String, String> body = new HashMap<String, String>();
        body.put("email", "test@naver.com");
        body.put("password", "1234");
        body.put("name", "관리자");
        body.put("phoneNumber", "010-1234-5678");
        body.put("address", "서울시 강남구 역삼동");
        body.put("role", "ADMIN");

        String content = new ObjectMapper().writeValueAsString(body);


        mockMvc.perform(put("/api/member/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isCreated())
                .andDo(
                        document("exampleTest",
                        requestFields(
                                fieldWithPath("email").description("회원 이메일"),
                                fieldWithPath("password").description("회원 비밀번호"),
                                fieldWithPath("name").description("회원 이름"),
                                fieldWithPath("phoneNumber").description("회원 전화번호"),
                                fieldWithPath("address").description("회원 주소"),
                                fieldWithPath("role").description("회원 역할")
                        ),
                        responseFields(
                                fieldWithPath("response").description("null"),
                                fieldWithPath("status").description("CREATED")
                        )
                ));

    }
}
