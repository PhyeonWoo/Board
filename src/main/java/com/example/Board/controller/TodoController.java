package com.example.Board.controller;



import com.example.Board.entity.TodoEntity;
import com.example.Board.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/todo")
    public String list(Model model){
        List<TodoEntity> toDoEntityList = todoService.list();
        model.addAttribute("toDoEntityList",toDoEntityList);
        return "todolist";
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/todo";
    }

    @PostMapping("/todo/create")
    public String todoCreate(@RequestParam String content) {
        todoService.todoCreate(content);
        return "redirect:/todo";
    }


}
