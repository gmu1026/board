package com.cproduction.board.dto;

import com.cproduction.board.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardSaveRequestDto {
    private String title;
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
