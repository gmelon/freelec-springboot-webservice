package dev.gmelon.spring.springboot.domain.posts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
}