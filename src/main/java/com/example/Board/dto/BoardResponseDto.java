package com.example.Board.dto;


import com.example.Board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 계층 간에 데이터를 보낼 때 사용하는 객체

/**
 * 계층 간에 데이터를 보낼 때 사용하는 객체
 * Service나 Controller로 데이터를 보낼때 사용
 * 데이터를 담는 용도이기 때문에 필드값,Getter,Setter만 존재하며 다른 메서드는 존재X
 */

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String author;
    private LocalDateTime createAt;
    private  LocalDateTime modifiedAt;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.createAt = entity.getCreateAt();
        this.modifiedAt = entity.getModifiedAt();
        this.contents = entity.getContents();
    }
}
