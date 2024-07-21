package org.example.userservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Value
public class MemberResponse {

    MemberData data;
    String message;

    @Builder
    @Value
    public static class MemberData {
        Long memberId;
        String email;
        String name;
    }
}
