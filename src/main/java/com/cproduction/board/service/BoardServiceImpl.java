package com.cproduction.board.service;

import com.cproduction.board.domain.Board;
import com.cproduction.board.domain.BoardRepository;
import com.cproduction.board.dto.BoardListResponseDto;
import com.cproduction.board.dto.BoardResponseDto;
import com.cproduction.board.dto.BoardSaveRequestDto;
import com.cproduction.board.dto.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public void saveBoard(BoardSaveRequestDto requestDto) {
        boardRepository.save(requestDto.toEntity());
    }

    @Transactional(readOnly = true)
    @Override
    public List<BoardListResponseDto> getBoardList() {
        return boardRepository.findAllList();
    }

    @Transactional(readOnly = true)
    @Override
    public BoardResponseDto getBoard(long no) {
        Board board = boardRepository.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("not found this board"));

        return new BoardResponseDto(board);
    }

    @Transactional
    @Override
    public void updateBoard(long no, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("not found this board"));

        board.update(requestDto.getTitle(), requestDto.getContent());
    }

    @Transactional
    @Override
    public void removeBoard(long no) {
        Board board = boardRepository.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("not found this board"));

        boardRepository.delete(board);
    }

    @Transactional
    @Override
    public void likeBoard(long no) {
        Board board = boardRepository.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("not found this board"));

        board.like();
    }
}
