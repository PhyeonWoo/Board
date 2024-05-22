package com.example.Board.entity;

import com.example.Board.dto.TodoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    public TodoEntity(String content, String completed) {
        this.content = content;
        this.completed = completed;
    }

    private String completed;

    public TodoEntity(TodoRequestDto requestDto) {
    }
}
