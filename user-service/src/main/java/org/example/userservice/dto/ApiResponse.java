package org.example.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Value
public class ApiResponse<T> {
    T data;
    String message;
}
