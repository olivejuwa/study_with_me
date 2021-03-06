package com.ksk.project.study_with_me.domain.boardPlaceRecommendation;

import com.ksk.project.study_with_me.domain.BaseTimeEntity;
import com.ksk.project.study_with_me.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class BoardPlaceRecommendation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;

    @ManyToOne
    @JoinColumn(name = "userCode")
    private User user;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 100, nullable = false)
    private String addressDetail;

    // TODO: Image 와 board 의 Entity 관계 설정 : 필드 타입 변경
    @Column(length = 100, nullable = false)
    private String thumbnailPath;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private String links;

    @Column(nullable = false)
    private int likeCount;

    @Column(nullable = false)
    private int dislikeCount;

    @Column(nullable = false)
    private int viewCount;

    @Builder
    public BoardPlaceRecommendation(Long postNo, User user, String title, String address, String addressDetail, String thumbnailPath,
                                    String content, String links, int likeCount, int dislikeCount, int viewCount) {
        this.postNo = postNo;
        this.user = user;
        this.title = title;
        this.address = address;
        this.addressDetail = addressDetail;
        this.thumbnailPath = thumbnailPath;
        this.content = content;
        this.links = links;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.viewCount = viewCount;
    }

    public void addViewCount() {
        this.viewCount++;
    }

    public void updateLikeCount(int updateCount) {
        if(updateCount < 0 && this.likeCount <= 0) {
            this.likeCount = 0;
            return;
        }

        this.likeCount += updateCount;
    }
    public void updateDislikeCount(int updateCount) {
        if(updateCount < 0 && this.dislikeCount <= 0) {
            this.dislikeCount = 0;
            return;
        }

        this.dislikeCount += updateCount;
    }

    public void update(String title, String address, String addressDetail, String thumbnailPath,
                       String content, String links) {
        this.title = title;
        this.address = address;
        this.addressDetail = addressDetail;
        this.thumbnailPath = thumbnailPath;
        this.content = content;
        this.links = links;
    }
}
