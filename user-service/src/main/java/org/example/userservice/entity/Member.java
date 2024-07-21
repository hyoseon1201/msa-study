package org.example.userservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.userservice.dto.request.MemberSignUpRequest;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_email", unique = true, nullable = false)
    private String email;

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_password", nullable = false)
    private String password;

    @Column(name = "member_is_disabled", nullable = false)
    private byte isDisabled = 0;

    @Column(name = "member_created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "member_last_login_at", nullable = false)
    private LocalDateTime lastLoginAt;

    public static Member create(MemberSignUpRequest request, String encodedPassword) {
        Member member = new Member();
        member.email = request.email();
        member.name = request.name();
        member.password = encodedPassword;
        member.isDisabled = 0;
        member.createdAt = LocalDateTime.now();
        member.lastLoginAt = LocalDateTime.now();
        return member;
    }
}
