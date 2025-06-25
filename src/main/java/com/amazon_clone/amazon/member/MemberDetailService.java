package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("email : {}", email);
        Optional<Member> getMember = memberRepository.findByEmailEquals(email);
        if(getMember
                .isEmpty()) throw new UsernameNotFoundException("찾을수 없음");

        return new MemberPrincipal(getMember.get().getEmail(), getMember.get().getPassword());
    }
}
