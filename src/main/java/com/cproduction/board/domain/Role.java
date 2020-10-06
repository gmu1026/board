package com.cproduction.board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    GUEST("ROLE_GUEST", "guest"),
    MEMBER("ROLE_MEMBER", "member");

    private final String key;
    private final String title;
}
