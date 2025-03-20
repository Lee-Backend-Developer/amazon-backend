package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.repository.MemberRepository;
import com.amazon_clone.amazon.member.request.MemberLogin;
import com.amazon_clone.amazon.member.request.MemberRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void register(MemberRegister request) {
        Member saveMember = Member.builder()
                .name(request.getName())
                .role(request.getRole())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();
        memberRepository.save(saveMember);
    }

    @Transactional
    public void leave(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public Member login(MemberLogin login) {
        Optional<Member> byEmailAndPassword = memberRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
        return byEmailAndPassword.get();
    }
}
