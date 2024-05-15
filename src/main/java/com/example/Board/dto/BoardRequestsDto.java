package com.example.Board.dto;

import lombok.Getter;

/**
 * 계층 간에 데이터를 보낼 때 사용하는 객체
 * Service나 Controller로 데이터를 보낼때 사용
 * 데이터를 담는 용도이기 때문에 필드값,Getter,Setter만 존재하며 다른 메서드는 존재X
 */


// 요청 받을 때 담겨지는 데이터 필드 값을 모아둔 Dto 구현
@Getter
public class BoardRequestsDto {
    private String title;
    private String author;
    private String password;
    private String contents;
}
