package org.example.userservice.service;

import org.example.userservice.dto.request.MemberSignUpRequest;
import org.example.userservice.dto.response.MemberResponse;
import org.example.userservice.dto.response.MemberSignUpResponse;
import org.springframework.http.ResponseEntity;

public interface MemberService {

    ResponseEntity<MemberSignUpResponse> createMember(MemberSignUpRequest request);

    ResponseEntity<MemberResponse> getMemberById(Long memberId);
}
