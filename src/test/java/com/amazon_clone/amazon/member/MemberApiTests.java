package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.config.TestSecurityConfig;
import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.dto.request.MemberLogin;
import com.amazon_clone.amazon.member.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
//@AutoConfigureMockMvc(addFilters = false) // 스프링 시큐리티 필터 비활성화
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Import(TestSecurityConfig.class)
public class MemberApiTests {

    @MockitoBean
    private MemberRepository memberRepository;

    @MockitoBean
    private MemberDetailService memberDetailService;

    @MockitoBean
    private MemberService memberService;

    @Autowired
    private MockMvc mockMvc;


    @DisplayName("회원가입 API 테스트")
    @Test
    void register() throws Exception {
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
                        document("register",
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

    @DisplayName("로그인 API 테스트")
    @Test
    @WithMockUser(username = "test@naver.com", password = "1234")
    void login() throws Exception {
        // given
        Member mockMember = Member.builder()
                .email("test@naver.com")
                .password("1234")
                .build();

        Mockito.when(memberRepository.findByEmailAndPassword("test@naver.com", "1234"))
                .thenReturn(Optional.of(mockMember));

        // when & then
        mockMvc.perform(post("/api/member/login")
                        .param("email", "test@naver.com")
                        .param("password", "1234")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().isOk())
                .andDo(
                        document("login",
                                requestFields(
                                        fieldWithPath("email").description("회원 이메일"),
                                        fieldWithPath("password").description("회원 비밀번호")
                                ),
                                responseFields(
                                        fieldWithPath("response.email").description("회원 이메일"),
                                        fieldWithPath("response.name").description("회원 이름"),
                                        fieldWithPath("response.phoneNumber").description("회원 전화번호"),
                                        fieldWithPath("response.address").description("회원 주소"),
                                        fieldWithPath("status").description("OK")
                                )
                        ));
    }


    @DisplayName("로그인 API 테스트")
    @Test
    @WithMockUser(username = "test@naver.com", password = "1234", roles = "ADMIN")
    void login2() throws Exception {
        // Given
        Member mockMember = Member.builder()
                .email("test@naver.com")
                .password("1234")
                .build();

        MemberPrincipal mockPrincipal = new MemberPrincipal(mockMember.getEmail(), mockMember.getPassword());


        Mockito.when(memberDetailService.loadUserByUsername("test@naver.com"))
                .thenReturn(mockPrincipal);

        // When & Then
        mockMvc.perform(post("/api/member/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@naver.com")
                        .param("password", "1234"))
                .andExpect(status().isOk()); // 200 상태 코드 확인

    }

}