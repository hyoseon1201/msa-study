package org.example.userservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MemberResponse(MemberData data, String message) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long memberId;
        private String email;
        private String name;
        private String message;

        public Builder memberId(Long memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public MemberResponse build() {
            MemberData memberData = new MemberData(memberId, email, name);
            return new MemberResponse(memberData, message);
        }
    }

    public record MemberData(Long memberId, String email, String name) {
    }
}
