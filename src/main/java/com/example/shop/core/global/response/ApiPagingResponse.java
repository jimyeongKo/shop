package com.example.shop.core.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiPagingResponse<T> {

    private HttpStatus status;

    private PagingResponse<T> data;
}
