package com.sparta.sparta_personalproject.BlogDto;

import com.sparta.sparta_personalproject.BlogEntity.Blog;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlogResponseDto {

    private Long id;
    private String title;
    private String content;
    private String username;

    public BlogResponseDto(Blog blog) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.content = blog.getContent();
        this.username = blog.getUsername();
    }
}
