package com.cproduction.board.service;

import com.cproduction.board.dto.BoardListResponseDto;
import com.cproduction.board.dto.BoardResponseDto;
import com.cproduction.board.dto.BoardSaveRequestDto;
import com.cproduction.board.dto.BoardUpdateRequestDto;

import java.util.List;

public interface BoardService {
    void saveBoard(BoardSaveRequestDto requestDto);
    List<BoardListResponseDto> getBoardList();
    BoardResponseDto getBoard(long no);
    void updateBoard(long no, BoardUpdateRequestDto requestDto);
    void removeBoard(long no);
}
