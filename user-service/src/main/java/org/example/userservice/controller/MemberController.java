package org.example.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.userservice.dto.request.MemberSignUpRequest;
import org.example.userservice.dto.response.MemberResponse;
import org.example.userservice.dto.response.MemberSignUpResponse;
import org.example.userservice.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service/members/")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<MemberSignUpResponse> signUp(@RequestBody MemberSignUpRequest request) {
        return memberService.createMember(request);
    }

    @GetMapping(value = "/{memberId}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable("memberId") Long memberId) {
        return memberService.getMemberById(memberId);
    }
}
