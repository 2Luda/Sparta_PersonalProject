package com.sparta.sparta_personalproject.BlogEntity;
import com.sparta.sparta_personalproject.BlogDto.BlogRequestDto;
import com.sparta.sparta_personalproject.BlogDto.LoginRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Entity
@NoArgsConstructor
public class Blog extends Timestamped{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String username;



    public Blog(BlogRequestDto blogRequestDto, Long userId) {
        this.title = blogRequestDto.getTitle();
        this.content = blogRequestDto.getContent();
        this.userId= userId;
        this.username = blogRequestDto.getUsername();

    }

    public void update(BlogRequestDto blogRequestDto) {
        this.title = blogRequestDto.getTitle();
        this.content = blogRequestDto.getContent();
    }

    // 비밀번호가 일치한지 확인하는 코드 아마도
//    public boolean checkPassword(String blogPassword) {
//        if(this.password.compareTo(blogPassword) == 0)
//            return true;
//        else
//            return false;
//    }
}
