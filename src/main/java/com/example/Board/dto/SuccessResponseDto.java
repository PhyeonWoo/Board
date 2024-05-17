package com.example.Board.dto;

import lombok.Getter;


/**
 * 계층 간에 데이터를 보낼 때 사용하는 객체
 * Service나 Controller로 데이터를 보낼때 사용
 * 데이터를 담는 용도이기 때문에 필드값,Getter,Setter만 존재하며 다른 메서드는 존재X
 */


// 게시글 삭제를 성공했을 때 성공 여부를 담아서 보낼 dto 구현
@Getter
public class SuccessResponseDto {
    private boolean success;

    public SuccessResponseDto(boolean success) {
        this.success = success;
    }
}
