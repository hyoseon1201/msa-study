package org.example.userservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Value
public class MemberSignUpResponse {

    MemberSignUpData data;
    String message;

    @Builder
    @Value
    public static class MemberSignUpData {
        String email;
    }
}
