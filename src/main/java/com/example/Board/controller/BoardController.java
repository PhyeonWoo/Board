package com.example.Board.controller;


import com.example.Board.dto.BoardRequestsDto;
import com.example.Board.dto.BoardResponseDto;
import com.example.Board.dto.SuccessResponseDto;
import com.example.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 전체 목록 조회
    @GetMapping("/api/post")
    public List<BoardResponseDto> getPosts() {
        return boardService.getPosts();
        // 게시글 내용을 BoardResponseDto에 담아 List형태로 Client에 보낸다
    }

    // 게시글 작성
    @PostMapping("/api/post")
    public BoardResponseDto createPost(@RequestBody BoardRequestsDto requestsDto) {
        return boardService.createPosts(requestsDto);
    }

    // 선택한 게시글 조회
    @GetMapping("/api/post/{id}")
    public BoardResponseDto getPosts(@PathVariable Long id) {
        return boardService.getPosts(id);
    }

    // 선택한 게시글 수정
    @PutMapping("/api/post/{id}")
    public BoardResponseDto updatePost(@PathVariable Long id,@RequestBody BoardRequestsDto requestsDto) throws Exception {
        return boardService.updatePost(id,requestsDto);
    }

    @DeleteMapping("/api/post/{id}")
    public SuccessResponseDto deletePost(@PathVariable Long id, @RequestBody BoardRequestsDto requestsDto) throws Exception {
        return boardService.deletePost(id,requestsDto);
    }
}
