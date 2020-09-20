package com.cproduction.board.dto;

import com.cproduction.board.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardResponseDto {
    private long no;
    private String title;
    private String content;
    private long likes;
    private LocalDateTime writeDate;

    public BoardResponseDto(Board board) {
        this.no = board.getNo();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.likes = board.getLikes();
        this.writeDate = board.getCreatedDate();
    }
}
