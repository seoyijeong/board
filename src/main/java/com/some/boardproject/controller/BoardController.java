package com.some.boardproject.controller;

import com.some.boardproject.dto.BoardDTO;
import com.some.boardproject.dto.ResponseDTO;
import com.some.boardproject.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("board/boardWrite")
    public String writeBoard(String cat, Model model){
        model.addAttribute("cat", cat);
        return "board/boardWrite";
    }

//    @PostMapping("board/writeText")
//    public @ResponseBody ResponseDTO<?> writeText(@Valid @RequestBody BoardDTO boardDTO) {
//
//        return "board/boardWrite";
//    }

    @GetMapping("board/boardList")
    public String healthBoard(){

        return "board/boardList";
    }
}
