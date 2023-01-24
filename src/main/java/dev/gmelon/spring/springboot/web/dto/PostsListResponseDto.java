package dev.gmelon.spring.springboot.web.dto;

import dev.gmelon.spring.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * ListResponseDto가 별도로 필요한 이유??
 * -> 수정 시 필요한 정보와 리스트 조회 시 필요한 정보가 다르므로 ResponseDto에서 필요한 정보만 출력하기보다 **정말 필요한 정보만 갖는** Dto를 별도로 생성해 사용
 */

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
