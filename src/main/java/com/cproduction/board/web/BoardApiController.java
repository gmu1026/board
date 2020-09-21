package com.cproduction.board.web;

import com.cproduction.board.dto.BoardSaveRequestDto;
import com.cproduction.board.dto.BoardUpdateRequestDto;
import com.cproduction.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping(value = "/api/board")
    public ResponseEntity<?> registerBoard(@RequestBody BoardSaveRequestDto requestDto) {
        boardService.saveBoard(requestDto);

        return ResponseEntity.ok("success board register");
    }

    @GetMapping(value = "/api/boards")
    public ResponseEntity<?> getBoardList() {
        return ResponseEntity.ok(boardService.getBoardList());
    }

    @PatchMapping(value = "/api/board/{no}")
    public ResponseEntity<?> updateBoard(@PathVariable("no") long no,
                                         @RequestBody BoardUpdateRequestDto requestDto) {
        boardService.updateBoard(no, requestDto);

        return ResponseEntity.ok("success board update");
    }

    @DeleteMapping(value = "/api/board/{no}")
    public ResponseEntity<?> removeBoard(@PathVariable("no") long no) {
        boardService.removeBoard(no);

        return ResponseEntity.ok("success board remove");
    }
}
