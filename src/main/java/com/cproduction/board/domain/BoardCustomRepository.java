package com.cproduction.board.domain;

import com.cproduction.board.dto.BoardListResponseDto;

import java.util.List;

public interface BoardCustomRepository {
    List<BoardListResponseDto> findAllList();
}
