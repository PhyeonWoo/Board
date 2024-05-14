package com.example.Board.entity;

import com.example.Board.dto.BoardRequestsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity // DB에 저장할 엔티티이기 때문에 쓴
@NoArgsConstructor
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // 동시에 사용할 경우 JPA가 기본 키를 자동으로 생성
    private Long id;

    private String title;
    private String author;
    private String password;
    private String contents;

    public Board(BoardRequestsDto requestsDto) {
        this.title = requestsDto.getTitle();
        this.contents = requestsDto.getContents();
        this.author = requestsDto.getAuthor();
        this.password = requestsDto.getPassword();
    }

    public void update(BoardRequestsDto requestsDto) {
    }
}
