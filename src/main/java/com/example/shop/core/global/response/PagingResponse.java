package com.example.shop.core.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PagingResponse<T> {
    private int page;

    private int totalPage;

    private Long totalCount;

    private List<T> data;
}
