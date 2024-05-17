package com.example.Board.repository;

import com.example.Board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

    // ModifiedAt 내림차순 기준으로 모든 데이터를 가져오기 위해,
    // Repository에 선언해주면 Service에서 메서드를 사용할 수 있다
    List<Board> findAllByOrderByModifiedAtDesc();
}
