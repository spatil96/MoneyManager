package com.moneyanager.user_service.UserService.payload;
import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResource {
    private String message;
    private boolean success;
    private HttpStatus status;
}