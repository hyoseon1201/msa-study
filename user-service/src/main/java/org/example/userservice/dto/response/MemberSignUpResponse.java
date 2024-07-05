package org.example.userservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MemberSignUpResponse(MemberSignUpData data, String message) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String message;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public MemberSignUpResponse build() {
            MemberSignUpData memberSignUpData = new MemberSignUpData(email);
            return new MemberSignUpResponse(memberSignUpData, message);
        }
    }

    public record MemberSignUpData(String email) {
    }
}
