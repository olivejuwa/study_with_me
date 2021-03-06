package com.ksk.project.study_with_me.web;

import com.ksk.project.study_with_me.service.LikeService;
import com.ksk.project.study_with_me.web.dto.like.LikePlaceSaveRequestDto;
import com.ksk.project.study_with_me.web.dto.like.LikePlaceSaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LikeApiController {

    private final LikeService likeService;

    @PutMapping("/board/place/posts/like")
    public LikePlaceSaveResponseDto saveLike(@RequestBody LikePlaceSaveRequestDto requestDto) {
        return likeService.saveOrUpdate(requestDto);
    }

    @DeleteMapping("/board/place/posts/like/{postNo}/{userCode}")
    public LikePlaceSaveResponseDto cancelLike(@PathVariable Long postNo, @PathVariable Long userCode) {
        return likeService.delete(postNo, userCode);
    }
}
