package com.amazon_clone.amazon.member;

import com.amazon_clone.amazon.common.Response;
import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.request.MemberRegister;
import com.amazon_clone.amazon.member.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    //회원가입
    @PutMapping("register")
    public ResponseEntity<Response> register(@RequestBody MemberRegister request) {
        Member register = memberService.register(request);
        MemberResponse memberResponse = new MemberResponse(register, HttpStatus.OK);
        return new ResponseEntity<>(memberResponse, HttpStatus.OK);
    }

}
