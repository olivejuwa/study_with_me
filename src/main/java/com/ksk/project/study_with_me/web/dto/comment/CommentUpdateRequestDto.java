package com.ksk.project.study_with_me.web.dto.comment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {
    private Long commentNo;
    private String content;

    @Builder
    public CommentUpdateRequestDto(Long commentNo, String content) {
        this.commentNo = commentNo;
        this.content = content;
    }
}
