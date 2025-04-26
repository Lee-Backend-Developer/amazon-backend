package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.dto.response.MemberLoginResponse;
import com.amazon_clone.amazon.member.repository.MemberRepository;
import com.amazon_clone.amazon.member.dto.request.MemberLogin;
import com.amazon_clone.amazon.member.dto.request.MemberRegister;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member register(MemberRegister request) {
        // 중복 회원이 있는지 확인
        if(!memberRepository.findByEmailEquals(request.getEmail()).isEmpty())
            throw new EntityExistsException("이미 존재하는 회원입니다.");

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

    public MemberLoginResponse login(MemberLogin login) {
        Optional<Member> getMember = memberRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
        if(getMember.isEmpty()) {
            throw new EntityNotFoundException("아이디 또는 비밀번호가 잘못되었습니다.");
        }

        MemberLoginResponse response = MemberLoginResponse.builder()
                .email(getMember.get().getEmail())
                .name(getMember.get().getName())
                .phoneNumber(getMember.get().getPhoneNumber())
                .address(getMember.get().getAddress())
                .build();

        return response;
    }
}
