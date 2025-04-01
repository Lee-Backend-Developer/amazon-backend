package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.common.Response;
import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.request.MemberLogin;
import com.amazon_clone.amazon.member.request.MemberRegister;
import com.amazon_clone.amazon.member.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    // 로그인
    @PostMapping("login")
    public ResponseEntity<MemberResponse> login(@RequestBody MemberLogin request) {
        Member login = memberService.login(request);
        MemberResponse response = new MemberResponse(login, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //회원가입
    @PutMapping("register")
    public ResponseEntity<Response> register(@RequestBody MemberRegister request) {
        Member register = memberService.register(request);
        MemberResponse memberResponse = new MemberResponse(register, HttpStatus.CREATED);
        return new ResponseEntity<>(memberResponse, HttpStatus.CREATED);
    }

}
