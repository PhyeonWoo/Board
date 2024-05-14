package com.example.Board.dto;

import lombok.Getter;

@Getter
public class BoardRequestsDto {
    private String title;
    private String author;
    private String password;
    private String contents;
}
