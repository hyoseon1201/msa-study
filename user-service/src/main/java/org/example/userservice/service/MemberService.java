package org.example.userservice.service;

import lombok.RequiredArgsConstructor;
import org.example.userservice.dto.ApiResponse;
import org.example.userservice.dto.request.MemberSignUpRequest;
import org.example.userservice.dto.response.MemberResponse;
import org.example.userservice.dto.response.MemberSignUpResponse;
import org.example.userservice.entity.Member;
import org.example.userservice.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public ResponseEntity<ApiResponse<MemberSignUpResponse>> createMember(MemberSignUpRequest request) {

        // TODO: 예외처리

        Member newMember = Member.create(request, bCryptPasswordEncoder.encode(request.password()));
        memberRepository.save(newMember);

        MemberSignUpResponse memberSignUpResponse = MemberSignUpResponse.builder()
                .email(request.email())
                .build();

        ApiResponse<MemberSignUpResponse> response = ApiResponse.<MemberSignUpResponse>builder()
                .data(memberSignUpResponse)
                .message("Success")
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse<MemberResponse>> getMemberById(Long memberId) {

        // TODO: 예외처리

        Member currentMember = memberRepository.findById(memberId)
                .orElseThrow();

        MemberResponse memberResponse = MemberResponse.builder()
                .memberId(memberId)
                .email(currentMember.getEmail())
                .name(currentMember.getName())
                .build();

        ApiResponse<MemberResponse> response = ApiResponse.<MemberResponse>builder()
                .data(memberResponse)
                .message("Success")
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
