package com.korit.BoardStudy.controller;

import com.korit.BoardStudy.dto.board.AddBoardReqDto;
import com.korit.BoardStudy.security.model.PrincipalUser;
import com.korit.BoardStudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/add")
    public ResponseEntity<?> addBoard(@RequestBody AddBoardReqDto addBoardReqDto, @AuthenticationPrincipal PrincipalUser principalUser) {
        return ResponseEntity.ok(boardService.addBoard(addBoardReqDto, principalUser));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoardByBoardId(@PathVariable Integer boardId) {
        return ResponseEntity.ok(boardService.getBoardByBoardId(boardId));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getBoardList() {

        return ResponseEntity.ok(boardService.getBoardList());
    }

    @PostMapping("/remove/{boardId}")
    public ResponseEntity<?> removeBoardByBoardId(@PathVariable Integer boardId, @AuthenticationPrincipal PrincipalUser principalUser) {
        return ResponseEntity.ok(boardService.removeBoardByBoardId(boardId, principalUser));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateBoardByBoardId(@RequestBody UpdateBoardReqDto updateBoardReqDto) {
        return ResponseEntity.ok(boardService.updateBoardByBoardId(updateBoardReqDto));
    }

}

//https://discord.gg/vK7cm9xR
