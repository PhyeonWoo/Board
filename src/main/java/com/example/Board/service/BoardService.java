package com.example.Board.service;


import com.example.Board.dto.BoardRequestsDto;
import com.example.Board.dto.BoardResponseDto;
import com.example.Board.dto.SuccessResponseDto;
import com.example.Board.entity.Board;
import com.example.Board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 실제 사용할 메서드의 로직을 구현

@Service
@RequiredArgsConstructor
public class BoardService {

    // 데이터를 저장하거나 조회하려면 실제 데이터에 접근해야 하므로 Repository 객체 선언
    private final BoardRepository boardRepository;

    // BoardResponseDto 에서 Board 엔티티를 넣으면 BoardResponseDto로 객체를 생성해주는 생성자를 만들었기 때문에
    // map(BoardResponseDto::new) 를 통해 간편하게 dto로 바꿔줄 수 있다
    @Transactional(readOnly = true)
    public List<BoardResponseDto> getPosts() {
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    // 게시글 내용이 담긴 requestDto를 받아서 Board 엔티티로 만들어준다
    // Board 클래스에서 BoardRequestDto를 받아서 Board 객체를 생성해주는 생성자를 만들어줘야 한다
    @Transactional(readOnly = true)
    public BoardResponseDto createPosts(BoardRequestsDto requestsDto) {
        Board board = new Board(requestsDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    // 게시글의 id를 가진 데이터를 boardRepository에서 찾아서 BoardResponseDto 객체로 만들어 반환한다
    // 만약 boardRepository에 해당 id의 데이터가 없다면, 예외처리한다
    @Transactional(readOnly = true)
    public BoardResponseDto getPosts(Long id) {
        return boardRepository.findById(id).map(BoardResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
    }

    @Transactional(readOnly = true)
    public BoardResponseDto updatePost(Long id, BoardRequestsDto requestsDto) throws Exception {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        if(!requestsDto.getPassword().equals(board.getPassword()))
            throw new Exception("비밀번호가 일치하지 않습니다");

        board.update(requestsDto);
        return new BoardResponseDto(board);
    }

    @Transactional(readOnly = true)
    public SuccessResponseDto deletePost(Long id, BoardRequestsDto requestsDto) throws Exception {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        if(!requestsDto.getPassword().equals(board.getPassword()))
            throw new Exception("비밀번호가 일치하지 않습니다");

        boardRepository.deleteById(id);
        return new SuccessResponseDto(true);
    }
}
