package com.sparta.sparta_personalproject.BlogEntity;

import com.sparta.sparta_personalproject.BlogDto.BlogRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Blog extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    public Blog(BlogRequestDto blogRequestDto) {
        this.name = blogRequestDto.getUsername();
        this.title = blogRequestDto.getTitle();
        this.password = blogRequestDto.getPassword();
        this.content = blogRequestDto.getContent();
    }

    public void update(BlogRequestDto blogRequestDto) {
        this.name = blogRequestDto.getUsername();
        this.title = blogRequestDto.getTitle();
        this.password = blogRequestDto.getPassword();
        this.content = blogRequestDto.getContent();
    }

    // 비밀번호가 일치한지 확인하는 코드 아마도..
    public boolean checkPassword(String blogPassword) {
        if(this.password.compareTo(blogPassword) == 0)
            return true;
        else
            return false;
    }
}
