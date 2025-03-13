package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.domain.Role;
import com.amazon_clone.amazon.member.repository.MemberRepository;
import com.amazon_clone.amazon.member.request.MemberCreate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @DisplayName("사용자가 추가 되어야한댜")
    @Test
    void member_add_o() {
        //given 무엇을 줬을 때
        MemberCreate request = MemberCreate.builder()
                .name("어드민")
                .address("경기도")
                .role(Role.ADMIN)
                .phoneNumber("010-1111-1111")
                .build();
        //when 어떠한 행동을 했을 때

        Mockito
                .when(memberRepository.findById(Mockito.any(Long.class)))
                .thenReturn(Optional.of(Member.builder()
                        .name("어드민")
                        .role(Role.ADMIN)
                        .build()));

        memberService.save(request);

        //then 이 결과가 나와야한다.

        Member findMember = memberRepository.findById(1L)
                .get();

        assertEquals(findMember.getName(), request.getName());
    }
}