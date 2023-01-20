package dev.gmelon.spring.springboot.domain.posts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PostsRepositoryTest {

    @Autowired PostsRepository postsRepository;

    @Test
    void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글 이름";
        String content = "테스트 게시글 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hsh1769@naver.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.of(2023, 1, 20, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println("---------------");
        System.out.println("posts.getCreatedTime() = " + posts.getCreatedTime());
        System.out.println("posts.getModifiedDate() = " + posts.getModifiedDate());

        assertThat(posts.getCreatedTime()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}