package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.repository.MemberRepository;
import com.amazon_clone.amazon.member.request.MemberLogin;
import com.amazon_clone.amazon.member.request.MemberRegister;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member register(MemberRegister request) {
        Member saveMember = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .role(request.getRole())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();
        return memberRepository.save(saveMember);
    }

    @Transactional
    public void leave(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public Member login(MemberLogin login) {
        Optional<Member> getMember = memberRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
        return getMember.get();
    }
}
