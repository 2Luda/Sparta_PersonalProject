package com.sparta.sparta_personalproject.BlogDto;

import com.sparta.sparta_personalproject.BlogEntity.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDto {
    private Long id;
    private String title;
    private String content;
    private String username;

}

