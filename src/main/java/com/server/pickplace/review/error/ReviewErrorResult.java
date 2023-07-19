package com.server.pickplace.review.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewErrorResult {

    ;

    private final HttpStatus httpStatus;
    private final String message;


}
