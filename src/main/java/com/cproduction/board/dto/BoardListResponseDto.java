package com.cproduction.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardListResponseDto {
    private long no;
    private String title;
    private LocalDateTime writeDate;

    public BoardListResponseDto(long no, String title, LocalDateTime writeDate) {
        this.no = no;
        this.title = title;
        this.writeDate = writeDate;
    }
}
