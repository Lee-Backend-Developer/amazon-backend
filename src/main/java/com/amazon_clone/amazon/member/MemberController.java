package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.common.Response;
import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.dto.request.MemberLogin;
import com.amazon_clone.amazon.member.dto.request.MemberRegister;
import com.amazon_clone.amazon.member.dto.response.MemberLoginResponse;
import com.amazon_clone.amazon.member.dto.response.MemberResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;
//    private final AuthenticationManager authenticationManager;

    // 로그인
    /*@PostMapping("login")
    public ResponseEntity<MemberResponse> login(@RequestBody MemberLogin request) {
        log.info("request : {}", request);
        MemberLoginResponse login = memberService.login(request);
        // login 성공 했을때 세션 생성
        // 1. 세션 저장
        // username, password 가져옴
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
//        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        MemberResponse response = new MemberResponse(login, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

    //회원가입
    @PutMapping("register")
    public ResponseEntity<Response> register(@RequestBody MemberRegister request) {
        Member register = memberService.register(request);
        MemberResponse memberResponse = new MemberResponse(register, HttpStatus.CREATED);
        return new ResponseEntity<>(memberResponse, HttpStatus.CREATED);
    }

    //회원탈퇴
    @DeleteMapping("leave/{id}")
    public ResponseEntity<Response> leave(@PathVariable Long id) {
        memberService.leave(id);
        MemberResponse memberResponse = new MemberResponse(null, HttpStatus.OK);
        return new ResponseEntity<>(memberResponse, HttpStatus.OK);
    }

}
