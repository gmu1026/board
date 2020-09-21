package com.cproduction.board.domain;

import com.cproduction.board.dto.BoardListResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.cproduction.board.domain.QBoard.board;

@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BoardListResponseDto> findAllList() {
        return jpaQueryFactory.select(Projections.constructor(
                BoardListResponseDto.class, board.no, board.title, board.createdDate))
                .from(board).orderBy(board.no.asc()).fetch();
    }
}
